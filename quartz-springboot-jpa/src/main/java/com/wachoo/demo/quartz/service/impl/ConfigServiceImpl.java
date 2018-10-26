package com.wachoo.demo.quartz.service.impl;

import com.wachoo.demo.quartz.dao.IConfigDao;
import com.wachoo.demo.quartz.entity.ao.QuartzConfigAO;
import com.wachoo.demo.quartz.entity.dbo.QuartzConfigDO;
import com.wachoo.demo.quartz.service.IConfigService;
import com.wachoo.demo.quartz.utils.BeanGenerator.IBeanGenerator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @desc:
 * @author: wangchao3
 * @since: JDK1.8
 * @date: 2018/10/26 12:30
 */
@Service
public class ConfigServiceImpl implements IConfigService {

  @Autowired
  @Qualifier("QuartzConfigMybatisDaoImpl")
  private IConfigDao configDao;

  @Autowired
  private IBeanGenerator beanGenerator;


  @Override
  public Boolean insertConfig(QuartzConfigAO config) {
    QuartzConfigDO quartzConfigDO = beanGenerator.convert(config, QuartzConfigDO.class);
    return configDao.insert(quartzConfigDO);
  }

  @Override
  public Boolean updateConfig(QuartzConfigAO config) {
    QuartzConfigDO quartzConfigDO = beanGenerator.convert(config, QuartzConfigDO.class);
    return configDao.update(quartzConfigDO);
  }

  @Override
  public Boolean delConfig(Long id) {
    return configDao.delete(id);
  }

  @Override
  public QuartzConfigAO selectConfig(Long id) {
    QuartzConfigDO select = configDao.select(id);
    QuartzConfigAO convert = beanGenerator.convert(select, QuartzConfigAO.class);
    return convert;
  }

  @Override
  public List<QuartzConfigAO> selectConfig(QuartzConfigAO config) {
    QuartzConfigDO quartzConfigDO = beanGenerator.convert(config, QuartzConfigDO.class);
    List<QuartzConfigDO> quartzConfigDOS = configDao.selectConfig(quartzConfigDO);
    List<QuartzConfigAO> convert = beanGenerator.convert(quartzConfigDOS, QuartzConfigAO.class);
    return convert;
  }
}
