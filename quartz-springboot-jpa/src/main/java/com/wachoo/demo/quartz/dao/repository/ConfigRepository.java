package com.wachoo.demo.quartz.dao.repository;

import com.wachoo.demo.quartz.entity.dbo.QuartzConfigDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @desc:
 * @author: wangchao3
 * @since: JDK1.8
 * @date: 2018/10/25 15:08
 */
@Repository
public interface ConfigRepository extends JpaRepository<QuartzConfigDO, Long> {

}
