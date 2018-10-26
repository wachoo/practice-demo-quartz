package com.wachoo.demo.quartz.controller;

import com.wachoo.demo.quartz.dao.repository.ConfigRepository;
import com.wachoo.demo.quartz.entity.ao.QuartzConfigAO;
import com.wachoo.demo.quartz.service.IConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc:
 * @author: wangchao3
 * @since: JDK1.8
 * @date: 2018/10/25 17:47
 */
@RestController
@RequestMapping("/quartz")
public class ConfigController {

  @Autowired
  ConfigRepository configRepository;
  @Autowired
  private IConfigService iConfigService;

  @ResponseBody
  @PostMapping("/v1/save")
  public Boolean save(@RequestBody QuartzConfigAO body) {
    Boolean aBoolean = iConfigService.insertConfig(body);
    return aBoolean;
  }

}
