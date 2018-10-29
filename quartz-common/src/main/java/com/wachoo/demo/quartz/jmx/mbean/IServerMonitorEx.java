package com.wachoo.demo.quartz.jmx.mbean;

import javax.management.MXBean;

/**
 * @desc: 基于MXBean的ServerMonitor指标扩展监测器接口
 * @author: wangchao3
 * @since: JDK1.8
 * @date: 2018/9/29 14:01
 */
@MXBean
public interface IServerMonitorEx extends IMXBeanBase {


  /**
   * 加载
   */
  @Override
  void load();

  /**
   * 获取接口名称
   *
   * @return
   */
  String getApiName();

  /**
   * 获取QPS
   */
  Double getQps();

  /**
   * 获取QPS计数
   */
  Long getQpsNum();

  /**
   * 获取请求返回总数
   */
  Long getResTotalNum();

  /**
   * 获取请求数-成功
   */
  Long getResSucNum();

  /**
   * 获取请求数-失败
   */
  Long getResFailNum();

  /**
   * 获取请求数-空
   */
  Long getResNullNum();

  /**
   * 获取请求数-非空
   */
  Long getResNotNullNum();
}