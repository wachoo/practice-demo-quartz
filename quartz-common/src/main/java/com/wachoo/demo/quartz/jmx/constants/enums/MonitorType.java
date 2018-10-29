package com.wachoo.demo.quartz.jmx.constants.enums;

/**
 * @desc: 接口操作类型
 * @author: wangchao3
 * @since: JDK1.8
 * @date: 2018/9/28 10:18
 */
public enum MonitorType {
  USERPROFILE_GET("getProfile"),
  USERPROFILE_UPDATE("updateProfile"),
  USERPROFILE_DELETE("deleteProfile");

  private String type;

  MonitorType(String type) {
    this.type = type;
  }

  public static MonitorType ofType(String type) {
    switch (type) {
      case "getProfile":
        return USERPROFILE_GET;
      case "updateProfile":
        return USERPROFILE_UPDATE;
      case "deleteProfile":
        return USERPROFILE_DELETE;
      default:
        return null;
    }
  }

  public String getType() {
    return this.type;
  }
}
