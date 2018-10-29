package com.wachoo.demo.quartz.jmx.manager;

import static com.wachoo.demo.quartz.jmx.constants.MonitorConts.COUNT_;

import com.wachoo.demo.quartz.jmx.bo.MetricalCounter;
import com.wachoo.demo.quartz.jmx.vo.Response;
import java.util.List;
import java.util.Map;

/**
 * @desc: 度量计数器管理类
 * @author: wangchao3
 * @since: JDK1.8
 * @date: 2018/10/19 17:14
 */
public class MetricalCounterManager {


  private Map<String, MetricalCounter> monitor_map;

  public MetricalCounterManager(Map<String, MetricalCounter> monitor_map) {
    this.monitor_map = monitor_map;
  }

  /**
   *
   * 对接口进行度量
   * @param key 缓存的计数器key
   * @param result 结果
   * @param thrown 是否异常
   * @date: 2018/10/19 17:04
   * @author:wangchao3
   */
  public void metricApi(String key, Object result, Boolean thrown) {
    //获取key对应的度量器
    MetricalCounter metricalCounter = monitor_map.get(key);
    if (metricalCounter == null) {
      metricalCounter = new MetricalCounter(key,COUNT_ + key);
      monitor_map.put(key, metricalCounter);
    }
    if (thrown) {
      metricalCounter.failAddAndGet(1);
    }
    //对结果response计数
    if (result == null) {
      metricalCounter.nullAddAndGet(1);
    } else if (result instanceof Map) {
      if (((Map) result).size() > 0) {
        metricalCounter.notNullAddAndGet(1);
      } else {
        metricalCounter.nullAddAndGet(1);
      }
    } else if (result instanceof List) {
      if (((List) result).size() > 0) {
        metricalCounter.notNullAddAndGet(1);
      } else {
        metricalCounter.nullAddAndGet(1);
      }
    } else if (result instanceof Boolean) {
      if ((Boolean) result) {
        metricalCounter.sucAddAndGet(1);
      } else {
        metricalCounter.failAddAndGet(1);
      }

    } else if (result instanceof Response) {
      Response res = (Response) result;
      if (res.isSuccess()) {
        metricalCounter.sucAddAndGet(1);
      } else {
        metricalCounter.failAddAndGet(1);
      }
      if (res.hasObject()) {
        metricalCounter.notNullAddAndGet(1);
      } else {
        metricalCounter.nullAddAndGet(1);
      }
    }
  }

  public Map<String, MetricalCounter> getMonitorMap() {
    return monitor_map;
  }
}
