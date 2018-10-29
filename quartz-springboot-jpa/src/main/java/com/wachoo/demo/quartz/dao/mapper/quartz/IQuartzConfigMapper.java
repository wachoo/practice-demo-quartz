package com.wachoo.demo.quartz.dao.mapper.quartz;

import com.wachoo.demo.quartz.entity.dbo.QuartzConfigDO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * @desc:
 * @author: wangchao3
 * @since: JDK1.8
 * @date: 2018/10/26 15:30
 */
@Mapper
public interface IQuartzConfigMapper {

  /**
   * 新增
   *
   * @param config
   * @return
   * @date: 2018/10/26 11:34
   * @author:wangchao3
   */
  Boolean insert(QuartzConfigDO config);


  /**
   * 修改
   *
   * @param config
   * @return
   * @date: 2018/10/26 11:34
   * @author:wangchao3
   */
  Boolean update(QuartzConfigDO config);


  /**
   * 删除
   *
   * @param id
   * @return
   * @date: 2018/10/26 11:34
   * @author:wangchao3
   */
  Boolean delete(Long id);


  /**
   * 获取
   *
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
