package com.wachoo.demo.quartz.jmx.mbean.impl;

import static com.wachoo.demo.quartz.jmx.constants.MonitorConts.API_USERPROFILE_COUNT_NAME_UPDATE;
import static com.wachoo.demo.quartz.jmx.constants.MonitorConts.API_USERPROFILE_NAME_UPDATE;

import com.wachoo.demo.quartz.aspect.JmxMetricalAOP;
import com.wachoo.demo.quartz.jmx.bo.MetricalCounter;
import com.wachoo.demo.quartz.jmx.mbean.AbstractServerMonitor;
import com.wachoo.demo.quartz.jmx.mbean.IServerMonitorEx;
import java.util.Map;

/**
 * @desc:
 * @author: wangchao3
 * @since: JDK1.8
 * @date: 2018/9/29 14:04
 */
public class ServerMonitorForUserProfileUpdate extends AbstractServerMonitor implements
    IServerMonitorEx {

  @Override
  public void load() {
    Map<String, MetricalCounter> monitor_profileMap = JmxMetricalAOP
        .getMonitorMap();
    MetricalCounter counter = monitor_profileMap.get(API_USERPROFILE_NAME_UPDATE);
    if (counter == null) {
      counter = new MetricalCounter(API_USERPROFILE_NAME_UPDATE,
          API_USERPROFILE_COUNT_NAME_UPDATE);
    }
    buildParams(counter);
  }
}
