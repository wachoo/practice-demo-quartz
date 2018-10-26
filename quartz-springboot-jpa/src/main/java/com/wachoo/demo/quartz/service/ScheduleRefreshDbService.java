package com.wachoo.demo.quartz.service;

import com.wachoo.demo.quartz.repository.ConfigRepository;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @desc:
 * @author: wangchao3
 * @since: JDK1.8
 * @date: 2018/10/25 15:07
 */
@Configuration
@EnableScheduling
@Component
@Slf4j
public class ScheduleRefreshDbService {

  @Autowired
  private ConfigRepository repository;

  @Resource(name = "jobDetail")
  private JobDetail jobDetail;

  @Resource(name = "jobTrigger")
  private CronTrigger cronTrigger;

  @Resource(name = "scheduler")
  private Scheduler scheduler;

  /**
   * 每隔5s查库，并根据查询结果决定是否重新设置定时任务
   *
   * @throws SchedulerException
   */
  @Scheduled(fixedRate = 5000)
  public void scheduleUpdateCronTrigger() throws SchedulerException {
    CronTrigger trigger = (CronTrigger) scheduler.getTrigger(cronTrigger.getKey());
    // 当前Trigger使用的
    String currentCron = trigger.getCronExpression();
    // 从数据库查询出来的
    String searchCron = repository.findOne(1L).getCron();
    log.info("currentCron: {}", currentCron);
    log.info("futureCron: {}", searchCron);
    log.info("---------------------");
    // 如果当前使用的cron表达式和从数据库中查询出来的cron表达式不一致，则刷新任务
    if (!currentCron.equals(searchCron)) {
      // 表达式调度构建器
      CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(searchCron);
      // 按新的cronExpression表达式重新构建trigger
      trigger = (CronTrigger) scheduler.getTrigger(cronTrigger.getKey());

      // 按新的cronExpression表达式重新构建trigger
      trigger = trigger.getTriggerBuilder().withIdentity(cronTrigger.getKey())
          .withSchedule(scheduleBuilder).build();
      // 按新的trigger重新设置job执行
      scheduler.rescheduleJob(cronTrigger.getKey(), trigger);
      currentCron = searchCron;
    }
  }

}
