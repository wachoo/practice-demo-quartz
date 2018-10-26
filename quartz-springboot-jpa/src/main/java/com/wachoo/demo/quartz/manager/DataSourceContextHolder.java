package com.wachoo.demo.quartz.manager;

import static com.wachoo.demo.quartz.instants.DataSourceInsts.DATASOURCE_H2_1;

import lombok.extern.slf4j.Slf4j;

/**
 * @desc:
 * @author: wangchao3
 * @since: JDK1.8
 * @date: 2018/10/26 15:03
 */
@Slf4j
public class DataSourceContextHolder {

  /**
   * 默认数据源-datasource_h2_1
   * @See
   */
  public static final String DEFAULT_DS = DATASOURCE_H2_1;

  private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

  /**
   * 设置数据源名
   * @param dbType
   */
  public static void setDB(String dbType) {
    log.debug("切换到{}数据源", dbType);
    contextHolder.set(dbType);
  }

  /**
   * 获取数据源名
   * @return
   */
  public static String getDB() {
    return (contextHolder.get());
  }

  /**
   * 清除数据源名
   */
  public static void clearDB() {
    contextHolder.remove();
  }
}
