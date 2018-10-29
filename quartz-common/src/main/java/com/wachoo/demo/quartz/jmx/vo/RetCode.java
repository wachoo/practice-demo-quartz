package com.wachoo.demo.quartz.jmx.vo;

/**
 * 响应代号枚举接口.
 *
 * @author wangliping
 * @date 2016-03-03
 * @since JDK1.7
 */
public interface RetCode {

    /**
     * 获取响应代号.
     *
     * @return
     */
    int getCode();

    /**
     * 获取响应描述.
     *
     * @return
     */
    String getMessage();

}
