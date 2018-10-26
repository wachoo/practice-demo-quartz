package com.wachoo.demo.quartz.repository;

import com.wachoo.demo.quartz.entity.ConfigDO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @desc:
 * @author: wangchao3
 * @since: JDK1.8
 * @date: 2018/10/25 15:46
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class ConfigRepositoryTest {

  @Autowired
  private ConfigRepository configRepository;

  @Test
  public void saveTest() throws Exception {
    ConfigDO config = new ConfigDO();
    config.setCron("0 30 20 * * ?");
    config.setCreator("wachoo");
    ConfigDO configDO = configRepository.save(config);
    log.info(configDO.toString());
    Assert.assertNotNull(config.getId());
  }

  @Test
  public void findOneTest() throws Exception {
    ConfigDO configDO = configRepository.findOne(1l);
    log.info(configDO.toString());
    Assert.assertNotNull(configDO);
    Assert.assertTrue(1l == configDO.getId());
  }
}