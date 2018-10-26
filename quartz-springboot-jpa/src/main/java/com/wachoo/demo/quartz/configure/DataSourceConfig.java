package com.wachoo.demo.quartz.configure;

import static com.wachoo.demo.quartz.instants.DataSourceInsts.DATASOURCE_DYNAMIC;
import static com.wachoo.demo.quartz.instants.DataSourceInsts.DATASOURCE_H2_1;
import static com.wachoo.demo.quartz.instants.DataSourceInsts.DATASOURCE_MARIADB_1;

import com.wachoo.demo.quartz.manager.DynamicDataSource;
import java.util.HashMap;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @desc:
 * @author: wangchao3
 * @since: JDK1.8
 * @date: 2018/10/26 11:19
 */
@Configuration
public class DataSourceConfig {

  @Bean(name = DATASOURCE_H2_1)
  @Primary
  @ConfigurationProperties(prefix = "spring.datasource.h2_1")
  public DataSource datasource_h2_1() {
    return DataSourceBuilder.create().build();
  }

  @Bean(name = DATASOURCE_MARIADB_1)
  @ConfigurationProperties(prefix = "spring.datasource.mariadb1")
  public DataSource datasource_mariadb_1() {
    return DataSourceBuilder.create().build();
  }

  /**
   * 动态数据源: 通过AOP在不同数据源之间动态切换
   *
   * @return
   */
  @Bean(name = DATASOURCE_DYNAMIC)
  public DataSource dataSource() {
    DynamicDataSource dynamicDataSource = new DynamicDataSource();
    // 默认数据源
    dynamicDataSource.setDefaultTargetDataSource(datasource_h2_1());

    // 配置多数据源
    Map<Object, Object> dsMap = new HashMap(5);
    dsMap.put(DATASOURCE_H2_1, datasource_h2_1());
    dsMap.put(DATASOURCE_MARIADB_1, datasource_mariadb_1());

    dynamicDataSource.setTargetDataSources(dsMap);

    return dynamicDataSource;
  }

}
