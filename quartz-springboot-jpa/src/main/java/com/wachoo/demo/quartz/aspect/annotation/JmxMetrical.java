package com.wachoo.demo.quartz.aspect.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @desc:
 * @author: wangchao3
 * @since: JDK1.8
 * @date: 2018/10/19 16:03
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface JmxMetrical {

  String name() default "";

  boolean displayArgs() default false;
  /**
   * 增删改的数据的类型
   */
  Class<?> clazz();
}
