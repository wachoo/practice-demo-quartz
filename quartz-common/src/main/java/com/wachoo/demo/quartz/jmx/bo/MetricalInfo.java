package com.wachoo.demo.quartz.jmx.bo;

import java.beans.ConstructorProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @desc: 基本监测属性指标
 * @author: wangchao3
 * @since: JDK1.8
 * @date: 2018/9/28 18:26
 */
@Setter
@Getter
@NoArgsConstructor
public class MetricalInfo {

  private String apiName;
  private Double qps;
  private Long qpsNum;
  private Long resTotalNum;
  private Long resSucNum;
  private Long resFailNum;
  private Long resNullNum;
  private Long resNotNullNum;

  @ConstructorProperties({"apiName", "qps", "qpsNum", "resTotalNum",
      "resSucNum", "resFailNum", "resNullNum", "resNotNullNum"})
  public MetricalInfo(String apiName, Double qps, Long qpsNum, Long resTotalNum,
      Long resSucNum, Long resFailNum, Long resNullNum, Long resNotNullNum) {
    this.apiName = apiName;
    this.qps = qps;
    this.qpsNum = qpsNum;
    this.resTotalNum = resTotalNum;
    this.resSucNum = resSucNum;
    this.resFailNum = resFailNum;
    this.resNullNum = resNullNum;
    this.resNotNullNum = resNotNullNum;
  }

}
