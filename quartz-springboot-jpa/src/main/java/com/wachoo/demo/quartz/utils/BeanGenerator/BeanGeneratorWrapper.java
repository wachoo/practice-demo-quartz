package com.wachoo.demo.quartz.utils.BeanGenerator;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.dozer.Mapper;
import org.dozer.spring.DozerBeanMapperFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.Assert;

/**
 * @desc:
 * @author: wangchao3
 * @since: JDK1.8
 * @date: 2018/10/26 12:01
 */
@Configuration
public class BeanGeneratorWrapper implements IBeanGenerator {

  @Autowired
  private Mapper mapper;

  @Bean
  public DozerBeanMapperFactoryBean initDozerBeanMapper() {
    return new DozerBeanMapperFactoryBean();
  }

  @Override
  public <T extends Serializable, S extends Serializable> T convert(S s, Class<T> clz) {
    // TODO Auto-generated method stub
    return mapper.map(s, clz);
  }

  @Override
  public <T extends Serializable, S extends Serializable> Collection<T> convert(Collection<S> s,
      Class<T> clz) {
    if (s == null) {
      return null;
    }

    Collection<T> retList = null;
    if (Set.class.isAssignableFrom(s.getClass())) {
      retList = new HashSet<T>();
    }

    if (List.class.isAssignableFrom(s.getClass())) {
      retList = new ArrayList<T>();
    }

    if (retList == null) {
      Assert.isNull(retList, "Unable to generate container class, Type abnormality");
    }

    Iterator<S> it = s.iterator();
    while (it.hasNext()) {
      Serializable srcOV = it.next();
      retList.add(convert(srcOV, clz));
    }

    return retList;
  }

  @Override
  public <T extends Serializable, S extends Serializable> List<T> convert(List<S> s, Class<T> clz) {
    // TODO Auto-generated method stub
    if (s == null) {
      return Collections.EMPTY_LIST;
    }
    List<T> retList = new ArrayList<T>();
    Iterator<S> it = s.iterator();
    while (it.hasNext()) {
      Serializable srcOV = it.next();
      retList.add(convert(srcOV, clz));
    }
    return retList;
  }

  @Override
  public <T extends Serializable, S extends Serializable> Set<T> convert(Set<S> s, Class<T> clz) {
    // TODO Auto-generated method stub
    if (s == null) {
      return Collections.EMPTY_SET;
    }
    Set<T> retList = new HashSet<T>();
    Iterator<S> it = s.iterator();
    while (it.hasNext()) {
      Serializable srcOV = it.next();
      retList.add(convert(srcOV, clz));
    }

    return retList;
  }

  @Override
  public <T extends Serializable, S extends Serializable> T[] convert(S[] s, Class<T> clz) {
    if (s == null) {
      return null;
    }

    @SuppressWarnings("unchecked")
    T[] arr = (T[]) Array.newInstance(clz, s.length);

    for (int i = 0; i < s.length; i++) {
      arr[i] = convert(s[i], clz);
    }

    return arr;
  }


}