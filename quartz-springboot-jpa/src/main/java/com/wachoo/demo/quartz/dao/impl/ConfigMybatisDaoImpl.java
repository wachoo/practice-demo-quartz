package com.wachoo.demo.quartz.dao.impl;

import static com.wachoo.demo.quartz.instants.DataSourceInsts.DATASOURCE_MARIADB_1;

import com.wachoo.demo.quartz.aspect.annotation.DataSources;
import com.wachoo.demo.quartz.dao.IConfigDao;
import com.wachoo.demo.quartz.dao.mapper.quartz.IConfigMapper;
import com.wachoo.demo.quartz.entity.dbo.QuartzConfigDO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @desc:
 * @author: wangchao3
 * @since: JDK1.8
 * @date: 2018/10/26 11:33
 */
@Repository(value = "ConfigMybatisDaoImpl")
public class ConfigMybatisDaoImpl implements IConfigDao {

  @Autowired
  IConfigMapper configMapper;


  @Override
  public Boolean insert(QuartzConfigDO quartzConfigDO) {
    configMapper.insert(quartzConfigDO);
    return true;
  }

  @Override
  public Boolean update(QuartzConfigDO quartzConfigDO) {
    configMapper.update(quartzConfigDO);
    return true;
  }

  @Override
  public Boolean delete(Long id) {
    configMapper.delele(id);
    return true;
  }

  @Override
  /**
   * 使用mariaDb_1
   */
  @DataSources(DATASOURCE_MARIADB_1)
  public QuartzConfigDO select(Long id) {
    return configMapper.select(id);
  }

  @Override
  public List<QuartzConfigDO> selectConfig(QuartzConfigDO config) {
    return configMapper.selectConfig(config);
  }
}
