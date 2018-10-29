package com.wachoo.demo.quartz.jmx.mbean;

/**
 * @desc: 初始化MXBean加载方法, 所有待注册的XMBean均需实现此接口
 * @author: wangchao3
 * @since: JDK1.8
 * @date: 2018/9/28 15:49
 */

public interface IMXBeanBase {

  /**
   * 加载元素
   */
  void load();

}
