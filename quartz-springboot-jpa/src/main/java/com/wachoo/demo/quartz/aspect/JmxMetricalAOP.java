package com.wachoo.demo.quartz.aspect;

import static com.wachoo.demo.quartz.jmx.constants.MonitorConts.API_PROTOCOL_CLASS_NAME;
import static com.wachoo.demo.quartz.jmx.constants.MonitorConts.SEP;

import com.google.common.collect.Maps;
import com.wachoo.demo.quartz.aspect.annotation.JmxMetrical;
import com.wachoo.demo.quartz.jmx.bo.MetricalCounter;
import com.wachoo.demo.quartz.jmx.manager.MetricalCounterManager;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @desc: 接口切面度量类
 * @author: wangchao3
 * @since: JDK1.8
 * @date: 2018/9/27 19:45
 */
@Aspect
  @Component
  public class JmxMetricalAOP {

    private static final Logger LOG = LoggerFactory.getLogger(JmxMetricalAOP.class);


    private static MetricalCounterManager metricalCounterManager;

    private static final String POINTCUT_METHOD =
        "(execution(public * " + API_PROTOCOL_CLASS_NAME + ".*(..)))";

    @PostConstruct
    public void init() {
      //初始化一个全局度量器管理类
      metricalCounterManager = new MetricalCounterManager(Maps.newHashMap());
      LOG.info("JmxMetricalAOP.methodAnnotated init:success");
    }

    @Pointcut("@annotation(com.wachoo.demo.quartz.aspect.annotation.JmxMetrical) || @target(com.wachoo.demo.quartz.aspect.annotation.JmxMetrical)")
    public void annotationProcessor() {
    }

    @Pointcut(POINTCUT_METHOD)
    public void publicMethod() {
      LOG.info("JmxMetricalAOP.methodJoinPointed");
    }

    @Around("publicMethod() && annotationProcessor()")
    public Object timedJoinPoint(ProceedingJoinPoint joinPoint) throws Throwable {
      Signature signature = joinPoint.getSignature();
      Method method = ((MethodSignature) signature).getMethod();
      final String methodName = signature.getName();

      /**
       * 1.获取唯一接口全路径
       */
      String fullApiName = getFullApiName(joinPoint, signature, methodName);

      if (method.getDeclaringClass().isInterface()) {
        method = joinPoint.getTarget().getClass()
            .getDeclaredMethod(methodName, method.getParameterTypes());
      }

      /**
       * 2. 方法上的注解优先级比类上的注解高,可以覆盖类上注解的值，获取相关值
       */
      //是否注解
      Boolean isJmxMetrical = false;
      //注解对象名
      String jmxMetricalName = null;
      //注解对象参数
      Object[] jmxMetricalArgs = null;
      //注解对象class
      Class<? extends JmxMetrical> aClass = null;

      JmxMetrical jmxMetrical = null;
      //处理方法上的注解
      if (method.isAnnotationPresent(JmxMetrical.class)) {
        isJmxMetrical = true;
        jmxMetrical = method.getAnnotation(JmxMetrical.class);
        jmxMetricalName = jmxMetrical.name();
        aClass = jmxMetrical.getClass();
        if (jmxMetrical.displayArgs()) {
          jmxMetricalArgs = joinPoint.getArgs();
        }
      } else {
        //处理类上面的注解
        Object target = joinPoint.getTarget();
        if (target.getClass().isAnnotationPresent(JmxMetrical.class)) {
          isJmxMetrical = true;
          jmxMetrical = target.getClass().getAnnotation(JmxMetrical.class);
          jmxMetricalName = jmxMetrical.name();
          aClass = jmxMetrical.getClass();
          if (jmxMetrical.displayArgs()) {
            jmxMetricalArgs = joinPoint.getArgs();
          }
        }
      }
      /**
       * 3. 切入点度量
       */
      //切入点方法执行结果
      Object result = null;
      Boolean thrown = false;
      try {
        result = joinPoint.proceed();
      } catch (Throwable throwable) {
        thrown = true;
        //如果需要度量
      }

      //如果不需要度量
      if (!isJmxMetrical) {
        return result;
      }
      metricalCounterManager.metricApi(fullApiName, result, thrown);
      return result;
    }


    private String getFullApiName(ProceedingJoinPoint joinPoint, Signature signature,
        String methodName) {
      //通过包路径方式获取
      String[] packageName = signature.getDeclaringTypeName().split("\\.");
      StringBuilder stringBuilder = new StringBuilder();
      for (int i = 0; i < packageName.length; ++i) {
        if (i < packageName.length - 1) {
          stringBuilder.append(packageName[i].substring(0, 1));
        } else {
          stringBuilder.append(packageName[i]);
        }
        if (i == packageName.length - 1) {
          stringBuilder.append(SEP);
          continue;
        }
        stringBuilder.append(".");
      }
      String fullApiName = stringBuilder + signature.getName();
      LOG.info("Executing: " + fullApiName);
      //通过接口方式获取
//    String className = joinPoint.getTarget().getClass().getInterfaces()[0].getName();
//    String fullApiName = className + SEP + methodName;
      return fullApiName;
    }


    /**
     * 后置异常通知
     */
    @AfterThrowing("publicMethod() && annotationProcessor()")
    public void demandRefund() {
      LOG.info("com.apus.hella.protocol.dto.*#{} exception!!!");
    }


    public static List<MetricalCounter> getMonitorList() {
      List<MetricalCounter> monitor_profiles = getMonitorMap().values().stream()
          .collect(Collectors.toList());
      return monitor_profiles;
    }

  public static Map<String, MetricalCounter> getMonitorMap() {
    return metricalCounterManager.getMonitorMap();
  }
}
