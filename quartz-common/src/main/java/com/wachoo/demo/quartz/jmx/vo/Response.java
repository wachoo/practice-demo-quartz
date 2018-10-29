package com.wachoo.demo.quartz.jmx.vo;


import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;

/**
 * 通讯响应.
 *
 * @author wangliping
 * @date 2016-02-25
 * @since JDK1.7
 */
public class Response<T> implements Serializable {

  private static final long serialVersionUID = -8341314569973693251L;

  private int code; // 响应代号

  private T object; // 响应数据

  private String error; // 错误信息

  private String message; // 响应信息

  private Exception exception; // 异常

  public Response() {
  }

  public Response(int code, T object, String error, String message, Exception exception) {
    super();
    this.code = code;
    this.object = object;
    this.error = error;
    this.message = message;
    this.exception = exception;
  }

  /**
   * 接口调用成功，不需要返回对象
   */
  public static <T> Response<T> newSuccess() {
    Response<T> result = new Response<T>();
    return result;
  }

  /**
   * 接口调用成功，有返回对象
   */
  public static <T> Response<T> newSuccess(T object) {
    Response<T> result = new Response<T>();
    result.setObject(object);
    return result;
  }

  /**
   * 接口调用失败，有错误码和描述，没有返回对象
   */
  public static <T> Response<T> newFailure(RetCode responseCode) {
    Response<T> result = new Response<T>();
    result.setCode(responseCode.getCode());
    result.setMessage(responseCode.getMessage());
    return result;
  }

  /**
   * 接口调用失败，有错误码和描述，没有返回对象
   */
  public static <T> Response<T> newFailure(int code, String message) {
    Response<T> result = new Response<T>();
    result.setCode(code != 0 ? code : -1);
    result.setMessage(message);
    return result;
  }

  /**
   * 接口调用失败，有错误字符串码和描述，没有返回对象
   */
  public static <T> Response<T> newFailure(String error, String message) {
    Response<T> result = new Response<T>();
    result.setCode(-1);
    result.setError(error);
    result.setMessage(message);
    return result;
  }

  /**
   * 转换或复制错误结果
   */
  public static <T> Response<T> newFailure(Response<?> failure) {
    Response<T> result = new Response<T>();
    result.setCode(failure.getCode() != 0 ? failure.getCode() : -1);
    result.setError(failure.getError());
    result.setMessage(failure.getMessage());
    result.setException(failure.getException());
    return result;
  }

  /**
   * 接口调用失败，返回异常信息
   */
  public static <T> Response<T> newException(Exception e) {
    Response<T> result = new Response<T>();
    result.setCode(-1);
    result.setException(e);
    result.setMessage(e.getMessage());
    return result;
  }

  /**
   * 判断返回结果是否成功
   */
  public boolean isSuccess() {
    return code == 0;
  }

  /**
   * 判断返回结果是否有结果对象
   */
  public boolean hasObject() {
    return code == 0 && object != null;
  }

  /**
   * 判断返回结果是否有异常
   */
  public boolean hasException() {
    return exception != null;
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public T getObject() {
    return object;
  }

  public void setObject(T object) {
    this.object = object;
  }

  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Exception getException() {
    return exception;
  }

  public void setException(Exception exception) {
    this.exception = exception;
  }

  @Override
  public String toString() {
    StringBuilder result = new StringBuilder("Response");
    if (object != null) {
      result.append("<" + object.getClass().getSimpleName() + ">");
    }
    result.append(": {code=" + code);
    if (object != null) {
      result.append(", object=" + object);
    }
    if (error != null) {
      result.append(", error=" + error);
    }
    if (message != null) {
      result.append(", message=" + message);
    }
    if (exception != null) {
      StringWriter stringWriter = new StringWriter();
      exception.printStackTrace(new PrintWriter(stringWriter));
      result.append(", exception=" + stringWriter.toString());
    }
    result.append(" }");
    return result.toString();
  }
}
