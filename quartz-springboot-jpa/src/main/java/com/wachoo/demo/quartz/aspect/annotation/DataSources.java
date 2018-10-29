package com.wachoo.demo.quartz.aspect.annotation;

import static com.wachoo.demo.quartz.instants.DataSourceInsts.DATASOURCE_H2_1;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @desc: 数据源-用于在编码时指定方法
 * @author: wangchao3
 * @since: JDK1.8
 * @date: 2018/10/26 15:15
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({
    ElementType.METHOD
})
public @interface DataSources {

  String value() default DATASOURCE_H2_1;
}