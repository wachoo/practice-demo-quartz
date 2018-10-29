package com.wachoo.demo.quartz.jmx.mbean.impl;

import com.alibaba.fastjson.JSON;
import com.wachoo.demo.quartz.aspect.JmxMetricalAOP;
import com.wachoo.demo.quartz.jmx.bo.MetricalCounter;
import com.wachoo.demo.quartz.jmx.bo.MetricalInfo;
import com.wachoo.demo.quartz.jmx.mbean.IServerMonitor;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @desc: 基于MXBean的userProfile接口监测器
 * @author: wangchao3
 * @since: JDK1.8
 * @date: 2018/9/26 19:09
 */
public class ServerMonitorForAll implements IServerMonitor {

  private static final Logger LOG = LoggerFactory.getLogger(ServerMonitorForAll.class);

  private static List<MetricalInfo> MetricalInfos = new ArrayList<>();

  @Override
  public void load() {
    List<MetricalCounter> monitor_profiles = JmxMetricalAOP.getMonitorList();
    MetricalInfos.clear();
    monitor_profiles.parallelStream().forEach(e -> {
      MetricalInfo MetricalInfo = new MetricalInfo();
      MetricalInfo.setApiName(e.getApiName());
      MetricalInfo.setQps(e.getQps());
      MetricalInfo.setQpsNum(e.getQpsNum());
      MetricalInfo.setResTotalNum(e.getResTotalNum());
      MetricalInfo.setResSucNum(e.getResSucNum());
      MetricalInfo.setResFailNum(e.getResFailNum());
      MetricalInfo.setResNullNum(e.getResNullNum());
      MetricalInfo.setResNotNullNum(e.getResNotNullNum());
      MetricalInfos.add(MetricalInfo);
    });
    LOG.info(getMonitorInfoJson());
  }


  @Override
  public List<MetricalInfo> getMonitorInfos() {
    return MetricalInfos;
  }

  public String getMonitorInfoJson() {
    return JSON.toJSONString(MetricalInfos);
  }
}
