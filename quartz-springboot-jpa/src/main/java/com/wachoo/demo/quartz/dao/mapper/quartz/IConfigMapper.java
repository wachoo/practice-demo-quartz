package com.wachoo.demo.quartz.dao.mapper.quartz;

import com.wachoo.demo.quartz.entity.dbo.QuartzConfigDO;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @desc:
 * @author: wangchao3
 * @since: JDK1.8
 * @date: 2018/10/26 15:30
 */
public interface IConfigMapper {

  /**
   * 新增
   *
   * @param config
   * @return
   * @date: 2018/10/26 11:34
   * @author:wangchao3
   */
  @Insert("INSERT INTO config(id,cron,creator) VALUES(#{id}, #{cron}, #{creator})")
  Boolean insert(QuartzConfigDO config);


  /**
   * 修改
   *
   * @param config
   * @return
   * @date: 2018/10/26 11:34
   * @author:wangchao3
   */
  @Update("UPDATE config SET id=#{id},cron=#{cron} ,creator=#{creator} WHERE id =#{id}")
  Boolean update(QuartzConfigDO config);


  /**
   * 删除
   *
   * @param id
   * @return
   * @date: 2018/10/26 11:34
   * @author:wangchao3
   */
  @Delete("DELETE FROM config WHERE id =#{id}")
  Boolean delele(Long id);


  /**
   * 获取
   *
   * @param id
   * @return
   * @date: 2018/10/26 11:34
   * @author:wangchao3
   */
  @Select("SELECT * FROM config WHERE id = #{id}")
  @Results({
      @Result(property = "id", column = "id"),
      @Result(property = "cron", column = "cron"),
      @Result(property = "creator", column = "creator")
  })
  QuartzConfigDO select(Long id);


  /**
   * 获取
   *
   * @param config
   * @return
   * @date: 2018/10/26 11:34
   * @author:wangchao3
   */
  @Select("SELECT * FROM config WHERE id = #{id}")
  @Results({
      @Result(property = "id", column = "id"),
      @Result(property = "cron", column = "cron"),
      @Result(property = "creator", column = "creator")
  })
  List<QuartzConfigDO>  selectConfig(QuartzConfigDO config);

}
