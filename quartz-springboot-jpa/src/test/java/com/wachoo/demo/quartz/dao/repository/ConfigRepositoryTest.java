package com.wachoo.demo.quartz.dao.repository;

import com.wachoo.demo.quartz.entity.dbo.QuartzConfigDO;
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
    QuartzConfigDO config = new QuartzConfigDO();
    config.setCron("0 30 20 * * ?");
    config.setCreator("wachoo");
    QuartzConfigDO quartzConfigDO = configRepository.save(config);
    log.info(quartzConfigDO.toString());
    Assert.assertNotNull(config.getId());
  }

  @Test
  public void findOneTest() throws Exception {
    QuartzConfigDO quartzConfigDO = configRepository.findOne(1l);
    log.info(quartzConfigDO.toString());
    Assert.assertNotNull(quartzConfigDO);
    Assert.assertTrue(1l == quartzConfigDO.getId());
  }
}