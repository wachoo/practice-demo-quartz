package com.wachoo.demo.quartz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * springboot整合quartz
 *
 * @date: 2018/10/25 14:35
 * @author:wangchao3
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class QuartzApplication {

  public static void main(String[] args) {
    SpringApplication.run(QuartzApplication.class, args);
  }
}
