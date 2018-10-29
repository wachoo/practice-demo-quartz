package com.wachoo.demo.quartz.jmx.task;

import com.wachoo.demo.quartz.aspect.JmxMetricalAOP;
import com.wachoo.demo.quartz.jmx.JmxMetricalMain;
import com.wachoo.demo.quartz.jmx.bo.MetricalCounter;
import com.wachoo.demo.quartz.jmx.mbean.IMXBeanBase;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @desc: Monitor模块执行计划
 * @author: wangchao3
 * @since: JDK1.8
 * @date: 2018/9/29 16:52
 */
@Service
@PropertySource("classpath:application.properties")
public class UserProfileMonitorJob {

  private static final Logger LOG = LoggerFactory.getLogger(UserProfileMonitorJob.class);

  /**
   * 定时刷新获取监控值记录
   *
   * @date: 2018/9/28 14:46
   * @author:wangchao3
   */
  @Scheduled(cron = "${task.scheduled.cron.recordReLoad:*/30 * * * * ?}")
  public void recordReLoad() {
    Map<String, IMXBeanBase> monitorMap = JmxMetricalMain.getMonitorMap();
    monitorMap.forEach((k, v) -> v.load());
//    LOG.info("定时刷新获取监控值记录");
  }

  /**
   * QPS计数任务 每隔1s初始化一次qps
   *
   * @date: 2018/9/28 14:46
   * @author:wangchao3
   */
  @Scheduled(fixedRate = 1000)
  public void qpsRecord() {
    Map<String, MetricalCounter> monitorMap = JmxMetricalAOP.getMonitorMap();
    monitorMap
        .forEach((monitorType, MetricalCounter) -> MetricalCounter.qpsInit());
//    LOG.info("QPS计数任务 每隔1s初始化一次qps");
  }

  /**
   * 计数任务 每天24:00初始化重置一次MetricalCounter计数
   */
  @Scheduled(cron = "${task.scheduled.cron.resetMonitorCounter:59 59 23 ? * *}")
  public void resetMonitorCounter() {
    Map<String, MetricalCounter> monitorMap = JmxMetricalAOP.getMonitorMap();
    monitorMap
        .forEach((monitorType, MetricalCounter) -> MetricalCounter.resetAll());
    LOG.info(
        "The counting task is reset once a day for MetricalCounter initialization at 24:00");
  }

}
