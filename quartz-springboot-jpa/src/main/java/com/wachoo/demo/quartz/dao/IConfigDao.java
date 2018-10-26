package com.wachoo.demo.quartz.dao;

import com.wachoo.demo.quartz.entity.dbo.QuartzConfigDO;
import java.util.List;

/**
 * @desc:
 * @author: wangchao3
 * @since: JDK1.8
 * @date: 2018/10/26 11:32
 */
public interface IConfigDao {

  /**
   * 新增
   * @param quartzConfigDO
   * @return
   * @date: 2018/10/26 11:34
   * @author:wangchao3
   */
  Boolean insert(QuartzConfigDO quartzConfigDO);


  /**
   * 修改
   * @param quartzConfigDO
   * @return
   * @date: 2018/10/26 11:34
   * @author:wangchao3
   */
  Boolean update(QuartzConfigDO quartzConfigDO);


  /**
   * 删除
   * @param id
   * @return
   * @date: 2018/10/26 11:34
   * @author:wangchao3
   */
  Boolean delete(Long id);


  /**
   * 获取
   * @param id
   * @return
   * @date: 2018/10/26 11:34
   * @author:wangchao3
   */
  QuartzConfigDO select(Long id);

  /**
   * 获取
   *
   * @param config
   * @return
   * @date: 2018/10/26 11:34
   * @author:wangchao3
   */
  List<QuartzConfigDO> selectConfig(QuartzConfigDO config);

}
