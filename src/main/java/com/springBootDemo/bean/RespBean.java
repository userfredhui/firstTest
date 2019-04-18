package com.springBootDemo.bean;


import java.util.List;

/**
 * created by lipenghui on 2019/4/4
 **/
public class RespBean {
  private String code;
  private String message;
  private Object data;

  public RespBean() {

  }

  public RespBean(String code, String message) {
    this.code = code;
    this.message = message;
  }

  public RespBean(String code, String message, List data) {
    this.code = code;
    this.message = message;
    this.data = data;
  }

  public RespBean(String code, String message, Object data) {
    this.code = code;
    this.message = message;
    this.data = data;
  }

  public RespBean(String code, String message, String data) {
    this.code = code;
    this.message = message;
    this.data = data;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }
}
