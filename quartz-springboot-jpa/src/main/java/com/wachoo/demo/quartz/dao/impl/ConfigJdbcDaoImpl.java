package com.wachoo.demo.quartz.dao.impl;

import com.wachoo.demo.quartz.dao.IConfigDao;
import com.wachoo.demo.quartz.entity.dbo.QuartzConfigDO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @desc:
 * @author: wangchao3
 * @since: JDK1.8
 * @date: 2018/10/26 11:33
 */
//@Repository(value = "ConfigJdbcDaoImpl")
public class ConfigJdbcDaoImpl implements IConfigDao {

  @Autowired
  @Qualifier("jdbcTemplate_h2_1")
  private JdbcTemplate jdbcTemplate_h2_1;

  @Autowired
  @Qualifier("jdbcTemplate_mariadb_1")
  private JdbcTemplate jdbcTemplate_mariadb_1;

  @Override
  public Boolean insert(QuartzConfigDO quartzConfigDO) {
    return true;
  }

  @Override
  public Boolean update(QuartzConfigDO quartzConfigDO) {
    return null;
  }

  @Override
  public Boolean delete(Long id) {
    return null;
  }

  @Override
  public QuartzConfigDO select(Long id) {
    return null;
  }

  @Override
  public List<QuartzConfigDO> selectConfig(QuartzConfigDO config) {
    return null;
  }
}
