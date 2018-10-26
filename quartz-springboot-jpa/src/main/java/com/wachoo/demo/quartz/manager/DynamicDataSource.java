package com.wachoo.demo.quartz.manager;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @desc:
 * @author: wangchao3
 * @since: JDK1.8
 * @date: 2018/10/26 15:06
 */
@Slf4j
public class DynamicDataSource extends AbstractRoutingDataSource {

  @Override
  protected Object determineCurrentLookupKey() {
    log.info("数据源为:{}", DataSourceContextHolder.getDB());

    return DataSourceContextHolder.getDB();
  }

}
