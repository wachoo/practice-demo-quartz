package com.wachoo.demo.quartz.configure;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @desc:
 * @author: wangchao3
 * @since: JDK1.8
 * @date: 2018/10/26 14:52
 */
public class JdbcTemplateConfig {

  @Bean
  @Qualifier("jdbcTemplate_h2_1")
  public JdbcTemplate jdbcTemplate_h2_1(
      @Qualifier("datasource_h2_1") DataSource dataSource) {
    return new JdbcTemplate(dataSource);
  }

  @Bean
  @Qualifier("jdbcTemplate_mariadb_1")
  public JdbcTemplate jdbcTemplate_mariadb_1(
      @Qualifier("datasource_mariadb_1") DataSource dataSource) {
    return new JdbcTemplate(dataSource);
  }
}
