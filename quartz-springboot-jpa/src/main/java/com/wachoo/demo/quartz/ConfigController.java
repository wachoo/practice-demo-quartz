package com.wachoo.demo.quartz;

import com.wachoo.demo.quartz.entity.ConfigDO;
import com.wachoo.demo.quartz.repository.ConfigRepository;
import java.util.Map;
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


  @ResponseBody
  @PostMapping("/v1/save")
  public ConfigDO verify(@RequestBody ConfigDO body) {
    ConfigDO save = configRepository.save(body);
    return save;
  }

}
