package com.wachoo.demo.quartz.configure;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

/**
 * @desc:
 * @author: wangchao3
 * @since: JDK1.8
 * @date: 2018/10/25 15:03
 */
@Configuration
@Component
@EnableScheduling
@Slf4j
public class ScheduleTask {


  public void sayHello() {
    log.info("Hello Quartz, I am a ScheduleTask!!!");
  }

}
