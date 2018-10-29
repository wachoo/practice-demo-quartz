package com.wachoo.demo.quartz.jmx.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @desc: jmx任务监控配置
 * @author: wangchao3
 * @since: JDK1.8
 * @date: 2018/9/29 16:55
 */
@Configuration
@ComponentScan("com.apus.hella.server.jmx.task")
@EnableScheduling
public class TaskSchedulerConfig {

}
