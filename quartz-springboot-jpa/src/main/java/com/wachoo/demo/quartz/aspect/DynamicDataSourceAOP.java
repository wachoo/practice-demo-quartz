package com.wachoo.demo.quartz.aspect;

import com.wachoo.demo.quartz.aspect.annotation.DataSources;
import com.wachoo.demo.quartz.manager.DataSourceContextHolder;
import java.lang.reflect.Method;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * @desc:
 * @author: wangchao3
 * @since: JDK1.8
 * @date: 2018/10/26 15:17
 */
@Aspect
@Component
public class DynamicDataSourceAOP {

  @Pointcut("@annotation(com.wachoo.demo.quartz.aspect.annotation.DataSources)|| @target(com.wachoo.demo.quartz.aspect.annotation.DataSources)")
  public void annotationDS() {
  }

  @Pointcut("(execution(public * com.wachoo.demo.quartz.dao.impl.*.*(..)))")
  public void dataSourceDao() {
  }

  @Before(value = "annotationDS()&&dataSourceDao()")
  public void beforeSwitchDS(JoinPoint point) {

    //获得当前访问的class
    Class<?> className = point.getTarget().getClass();

    //获得访问的方法名
    String methodName = point.getSignature().getName();
    //得到方法的参数的类型
    Class[] argClass = ((MethodSignature) point.getSignature()).getParameterTypes();
    String dataSource = DataSourceContextHolder.DEFAULT_DS;
    try {
      // 得到访问的方法对象
      Method method = className.getMethod(methodName, argClass);

      // 判断是否存在@DS注解
      if (method.isAnnotationPresent(DataSources.class)) {
        DataSources annotation = method.getAnnotation(DataSources.class);
        // 取出注解中的数据源名
        dataSource = annotation.value();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    // 切换数据源
    DataSourceContextHolder.setDB(dataSource);

  }


  @After(value = "annotationDS()&&dataSourceDao()")
  public void afterSwitchDS(JoinPoint point) {

    DataSourceContextHolder.clearDB();

  }
}
