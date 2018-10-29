package com.wachoo.demo.quartz.jmx;

import com.wachoo.demo.quartz.jmx.mbean.IMXBeanBase;
import java.lang.management.ManagementFactory;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @desc: 使用MBeanServer注册开放jmx接口实现
 * @author: wangchao3
 * @since: JDK1.8
 * @date: 2018/9/25 19:05
 */
@Component("JmxMetricalMain")
public class JmxMetricalMain {

  private static final Logger LOG = LoggerFactory.getLogger(JmxMetricalMain.class);


  private static Map<String, IMXBeanBase> monitorMap;

  private String JMX_MBEAN_PATH = "com.apus.dap.hella.common.jmx.mbean";

  @PostConstruct
  public void init() {
    //1. 初始化map容器
    monitorMap = new HashMap<>(100);
    //2. 初始化MBeanServer
    LOG.info("JmxMetricalMain#initMbServerForMonitor() init...");
    initMbServerForMonitor();
    LOG.info("JmxMetricalMain#initMbServerForMonitor() init: success, size: {}",
        monitorMap.size());
  }

  public void initMbServerForMonitor() {
    try {
      MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
      //获取接口IMXBeanBase的所有实现类
      List<Class> imxBeanBaseList = getIMXBeanBaseList();
      imxBeanBaseList.parallelStream().forEach(e -> {
        try {
          MBeanRegister4ServerMonitor(mbs, (IMXBeanBase) e.newInstance());
        } catch (Exception e1) {
          LOG.error("initMbServerForMonitor, register MXBean exception!!!");
          LOG.error(e1.getMessage(), e1);
        }
      });
    } catch (Exception e) {
      LOG.error(e.getMessage(), e);
    }
  }

  private void MBeanRegister4ServerMonitor(MBeanServer mbs, IMXBeanBase monitor)
      throws MalformedObjectNameException, InstanceAlreadyExistsException, MBeanRegistrationException, NotCompliantMBeanException {
    String name = monitor.getClass().getSimpleName();
    name = "com.wachoo.demo.quartz:type=" + name;
    ObjectName objectName = new ObjectName(name);
    mbs.registerMBean(monitor, objectName);
    monitorMap.put(name, monitor);
  }

  /**
   * 获取IMXBeanBase的所有实现
   *
   * @return
   */
  public List<Class> getIMXBeanBaseList() {
    List<Class> moduleList = new ArrayList<>();
    String PACKAGE_NAME = JMX_MBEAN_PATH;
    Reflections reflection = new Reflections(PACKAGE_NAME);
    Set<Class<? extends IMXBeanBase>> classes = reflection.getSubTypesOf(IMXBeanBase.class);
    if (classes != null) {
      for (Class<? extends IMXBeanBase> config : classes) {
        boolean isAbstract = Modifier.isAbstract(config.getModifiers());
        if (!isAbstract) {
          moduleList.add(config);
        }
      }
    }
    return moduleList;
  }

  public static Map<String, IMXBeanBase> getMonitorMap() {
    return monitorMap;
  }

  public void getIMXBeanBaseTest() {
    List<Class> imxBeanBaseList = getIMXBeanBaseList();
    imxBeanBaseList.parallelStream().forEach(e -> {
      System.out.println(e.getName());
    });
  }

}
