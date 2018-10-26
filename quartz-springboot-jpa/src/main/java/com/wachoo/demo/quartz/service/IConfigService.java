package com.wachoo.demo.quartz.service;

import com.wachoo.demo.quartz.entity.ao.QuartzConfigAO;
import java.util.List;

/**
 * @desc:
 * @author: wangchao3
 * @since: JDK1.8
 * @date: 2018/10/26 12:29
 */
public interface IConfigService {

  /**
   * 新增
   *
   * @param config
   * @return
   * @date: 2018/10/26 11:34
   * @author:wangchao3
   */
  Boolean insertConfig(QuartzConfigAO config);


  /**
   * 修改
   *
   * @param config
   * @return
   * @date: 2018/10/26 11:34
   * @author:wangchao3
   */
  Boolean updateConfig(QuartzConfigAO config);


  /**
   * 删除
   *
   * @param id
   * @return
   * @date: 2018/10/26 11:34
   * @author:wangchao3
   */
  Boolean delConfig(Long id);


  /**
   * 获取
   *
   * @param id
   * @return
   * @date: 2018/10/26 11:34
   * @author:wangchao3
   */
  QuartzConfigAO selectConfig(Long id);

  /**
   * 获取
   *
   * @param config
   * @return
   * @date: 2018/10/26 11:34
   * @author:wangchao3
   */
  List<QuartzConfigAO> selectConfig(QuartzConfigAO config);
}
