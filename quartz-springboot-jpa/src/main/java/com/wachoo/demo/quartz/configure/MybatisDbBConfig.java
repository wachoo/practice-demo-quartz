package com.wachoo.demo.quartz.configure;

import static com.wachoo.demo.quartz.instants.DataSourceInsts.DATASOURCE_MARIADB_1;

import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @desc:
 * @author: wangchao3
 * @since: JDK1.8
 * @date: 2018/10/26 12:36
 */
//@Configuration
@MapperScan(basePackages = {
    "com.wachoo.demo.quartz.dao.mapper.quartz"}, sqlSessionFactoryRef = "sqlSessionFactory_mariadb_1")
public class MybatisDbBConfig {

  @Autowired
  @Qualifier(DATASOURCE_MARIADB_1)
  private DataSource datasource_mariadb_1;

  @Bean
  @Qualifier("sqlSessionFactory_mariadb_1")
  public SqlSessionFactory sqlSessionFactory_mariadb_1() throws Exception {
    SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
    factoryBean.setDataSource(datasource_mariadb_1);
    return factoryBean.getObject();

  }

  @Bean
  public SqlSessionTemplate sqlSessionTemplate_mariadb_1() throws Exception {
    SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory_mariadb_1());
    return template;
  }
}
