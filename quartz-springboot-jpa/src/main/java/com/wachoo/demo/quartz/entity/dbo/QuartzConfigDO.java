package com.wachoo.demo.quartz.entity.dbo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

/**
 * @desc:
 * @author: wangchao3
 * @since: JDK1.8
 * @date: 2018/10/25 15:01
 */
@Entity(name = "quartz_config")
@Data
public class QuartzConfigDO implements Serializable{


  private static final long serialVersionUID = 5278329540197167213L;
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column
  private String cron;

  @Column
  private String creator;
}
