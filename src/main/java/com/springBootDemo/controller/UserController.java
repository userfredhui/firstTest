package com.springBootDemo.controller;

import com.springBootDemo.bean.RespBean;
import com.springBootDemo.bean.User;
import com.springBootDemo.service.UserService;
import com.springBootDemo.utils.Util;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * created by robin.wu on 2019/4/2
 **/
@RestController
public class UserController {

  private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

  @Autowired
  UserService userService;

  @RequestMapping("/current-user")
  public RespBean currentUser() {
    RespBean respBean = new RespBean("0", "成功了", Util.getCurrentUser());
    return respBean;
  }

  @GetMapping("/register")
  public RespBean register(User user) {
    int result = userService.reg(user);
    if (result == 0) {
      return new RespBean("0", "注册成功！");
    } else if (result == 1) {
      return new RespBean("1", "用户名已经存在！");
    } else {
      return new RespBean("1", "注册失败！");
    }
  }

  @RequestMapping(value = "/update-user-email", method = RequestMethod.PUT)
  public RespBean updateUserEmail(@RequestParam(value = "email") String email) {
    int result = userService.updateUserEmail(email);
    if (result == 1) {
      return new RespBean("0", "修改邮箱成功");
    } else {
      return new RespBean("1", "修改邮箱失败");
    }
  }

  @RequestMapping(value = "/user-by-id", method = RequestMethod.GET)
  public RespBean getUserById(@RequestParam(value = "id") Long id) {
    User user = userService.getUserById(id);
    return new RespBean("0", "", user);
  }
}
