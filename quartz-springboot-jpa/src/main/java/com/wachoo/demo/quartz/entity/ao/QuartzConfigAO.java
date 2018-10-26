package com.wachoo.demo.quartz.entity.ao;

import java.io.Serializable;
import lombok.Data;

/**
 * @desc:
 * @author: wangchao3
 * @since: JDK1.8
 * @date: 2018/10/26 11:41
 */
@Data
public class QuartzConfigAO implements Serializable {


  private static final long serialVersionUID = 3451711768597109253L;
  private Long id;

  private String cron;

  private String creator;
}
