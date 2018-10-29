package com.wachoo.demo.quartz.jmx.mbean;

import com.wachoo.demo.quartz.jmx.bo.MetricalCounter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @desc:
 * @author: wangchao3
 * @since: JDK1.8
 * @date: 2018/9/29 15:22
 */
public class AbstractServerMonitor {

  private static final Logger LOG = LoggerFactory
      .getLogger(AbstractServerMonitor.class);

  private String apiName;
  private Double qps;
  private Long qpsNum;
  private Long resTotalNum;
  private Long resSucNum;
  private Long resFailNum;
  private Long resNullNum;
  private Long resNotNullNum;


  public String getApiName() {
    return apiName;
  }


  public Double getQps() {
    return qps;
  }


  public Long getQpsNum() {
    return qpsNum;
  }


  public Long getResTotalNum() {
    return resTotalNum;
  }


  public Long getResSucNum() {
    return resSucNum;
  }


  public Long getResFailNum() {
    return resFailNum;
  }


  public Long getResNullNum() {
    return resNullNum;
  }


  public Long getResNotNullNum() {
    return resNotNullNum;
  }

  public void buildParams(MetricalCounter counter) {
    if (counter == null) {
      return;
    }
    apiName = counter.getApiName();
    qps = counter.getQps();
    qpsNum = counter.getQpsNum();
    resTotalNum = counter.getResTotalNum();
    resSucNum = counter.getResSucNum();
    resFailNum = counter.getResFailNum();
    resNullNum = counter.getResNullNum();
    resNotNullNum = counter.getResNotNullNum();
    LOG.info(
        "{}: {qps:{}, qpsNum:{}, resTotalNum:{}, resSucNum:{}, resFailNum:{}, resNullNum:{}, resNotNullNum:{}}",
        apiName, qps, qpsNum, resTotalNum, resSucNum, resFailNum, resNullNum, resNotNullNum);
  }
}
