package com.springBootDemo.utils;

import com.springBootDemo.bean.User;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * created by lipenghui on 2019/4/12
 **/
public class Util {
  public static User getCurrentUser() {
    User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    return user;
  }
}
