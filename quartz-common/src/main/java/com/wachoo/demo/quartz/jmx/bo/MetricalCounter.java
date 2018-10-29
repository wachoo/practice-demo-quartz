package com.wachoo.demo.quartz.jmx.bo;

import com.apus.monitor.metrics.Counter;
import com.apus.monitor.reporter.Reporter;
import com.apus.monitor.reporter.SL4JReporter;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 基本检测属性指标计算器
 *
 * @author: wangchao3
 * @since: JDK1.8
 * @date: 2018/9/26 11:14
 */
public class MetricalCounter {

  private final Logger LOG = LoggerFactory.getLogger(MetricalCounter.class);


  private Reporter reporter = new SL4JReporter(
      com.apus.monitor.metrics.MetricManager.getDefaultManager());

  private String api_name;
  private String counter_name;
  private String counter_name_qps;
  private Counter counter_suc;

  private AtomicLong res_qps;
  private AtomicLong res_total;
  private AtomicLong res_success;
  private AtomicLong res_fail;
  private AtomicLong res_null;
  private AtomicLong res_not_null;

  private long beginTime = 0L;


  public MetricalCounter(String apiName, String counterName) {
    api_name = apiName;
    counter_name = counterName;
    counter_name_qps = counterName + ".qps";
    counter_suc = com.apus.monitor.metrics.MetricManager.getDefaultManager().counter(counter_name);

    res_qps = new AtomicLong();
    res_total = new AtomicLong();
    res_success = new AtomicLong();
    res_fail = new AtomicLong();
    res_null = new AtomicLong();
    res_not_null = new AtomicLong();
  }

  public void start() {
    beginTime = System.currentTimeMillis();
    reporter.start();
  }

  public void stop() {
    LOG.info(" total time used: {} ms", (System.currentTimeMillis() - beginTime));
    reporter.stop();
  }

  /**
   * 初始化res_qps
   *
   * @return
   */
  public final long qpsInit() {
    return res_qps.getAndSet(0L);
  }
  /**
   * 重置所有指标
   *
   * @return
   */
  public void resetAll() {
    res_qps.set(0L);
    res_total.set(0L);
    res_success.set(0L);
    res_fail.set(0L);
    res_null.set(0L);
    res_not_null.set(0L);
  }


  public final long qpsAddAndGet(long delta) {
    return res_qps.addAndGet(delta);
  }

  public final long totalAddAndGet(long delta) {
    //记录QPS
    inc();
    qpsAddAndGet(delta);
    return res_total.addAndGet(delta);
  }

  public final long sucAddAndGet(long delta) {
    totalAddAndGet(delta);
    return res_success.addAndGet(delta);
  }

  public final long failAddAndGet(long delta) {
    totalAddAndGet(delta);
    return res_fail.addAndGet(delta);
  }

  public final long nullAddAndGet(long delta) {
    sucAddAndGet(delta);
    return res_null.addAndGet(delta);
  }

  public final long notNullAddAndGet(long delta) {
    sucAddAndGet(delta);
    return res_not_null.addAndGet(delta);
  }


  public void inc() {
    counter_suc.inc();
  }


  public String getApiName() {
    return api_name;
  }


  public double getQps() {
    Map<String, Number> map = counter_suc.result();
    Double qps = (Double) map.get(counter_name_qps);
    return qps;
  }


  public Long getQpsNum() {
    return res_qps.get();
  }

  public Long getResTotalNum() {
    return res_total.get();
  }

  public Long getResSucNum() {
    return res_success.get();
  }

  public Long getResFailNum() {
    return res_fail.get();
  }

  public Long getResNullNum() {
    return res_null.get();
  }

  public Long getResNotNullNum() {
    return res_not_null.get();
  }
}
