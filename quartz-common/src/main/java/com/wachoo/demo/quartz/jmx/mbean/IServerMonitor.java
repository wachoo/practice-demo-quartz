package com.wachoo.demo.quartz.jmx.mbean;

import com.wachoo.demo.quartz.jmx.bo.MetricalInfo;
import java.util.List;
import javax.management.MXBean;

/**
 * 基于MXBean的ServerMonitor监测器接口
 *
 * @desc:
 * @author: wangchao3
 * @since: JDK1.8
 * @date: 2018/9/26 19:06
 */
@MXBean
public interface IServerMonitor extends IMXBeanBase {

  List<MetricalInfo> getMonitorInfos();


}
