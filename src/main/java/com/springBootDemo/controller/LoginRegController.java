package com.springBootDemo.controller;

import com.springBootDemo.bean.RespBean;
import com.springBootDemo.bean.User;
import com.springBootDemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * created by lipenghui on 2019/4/11
 **/
@RestController
public class LoginRegController {
  @Autowired
  UserService userService;

  @RequestMapping("/login_error")
  public RespBean loginError() {
    return new RespBean("1", "登录失败！");
  }

  @RequestMapping("/login_success")
  public RespBean loginSuccess() {
    return new RespBean("0", "登录成功！");
  }

  @RequestMapping("/login_page")
  public RespBean loginPage() {
    return new RespBean("2", "尚未登录，请登录！");
  }

  @RequestMapping("/reg")
  public RespBean reg(User user) {
    int result = userService.reg(user);
    if (result == 0) {
      // 成功
      return new RespBean("0", "注册成功");
    } else if (result == 1) {
      return new RespBean("1", "用户名重复，注册失败！");
    } else {
      return new RespBean("1", "注册失败！");
    }
  }
}
