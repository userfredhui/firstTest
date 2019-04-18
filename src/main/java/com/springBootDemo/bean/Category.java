package com.springBootDemo.bean;

import java.sql.Timestamp;

/**
 * created by lipenghui on 2019/4/12
 **/
public class Category {
  private Long id;
  private String cateName;
  private Timestamp date;

  public Category() {}

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCateName() {
    return cateName;
  }

  public void setCateName(String cateName) {
    this.cateName = cateName;
  }

  public Timestamp getDate() {
    return date;
  }

  public void setDate(Timestamp date) {
    this.date = date;
  }
}
