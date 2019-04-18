package com.springBootDemo.controller.admin;

import com.springBootDemo.bean.RespBean;
import com.springBootDemo.bean.Role;
import com.springBootDemo.bean.User;
import com.springBootDemo.service.UserService;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * created by lipenghui on 2019/4/11
 **/
@RestController
@RequestMapping("/admin")
public class UserManaController {
  @Autowired
  UserService userService;

  @RequestMapping(value = "/user", method = RequestMethod.GET)
  public RespBean getUserByNickname(String nickname) {
    List<User> users = userService.getUserByNickname(nickname);
    RespBean respBean = new RespBean("0", "有结果", users);
    return respBean;
  }

  @RequestMapping(value = "/roles", method = RequestMethod.GET)
  public RespBean getAllRoles() {
    List<Role> roles = userService.getAllRole();
    Map<String, Object> map = new HashMap<>();
    map.put("roles", roles);
    return new RespBean("0", "", map);
  }

  @RequestMapping(value = "/user/enabled", method = RequestMethod.PUT)
  public RespBean updateUserEnabled(Boolean enabled, Long uid) {
    if (userService.updateUserEnabled(enabled, uid) == 1) {
      return new RespBean("0", "更新成功");
    } else {
      return new RespBean("1", "更新失败");
    }
  }

  @RequestMapping(value = "/user/{uid}", method = RequestMethod.DELETE)
  public RespBean deleteUserById(@PathVariable Long uid) {
    if (userService.deleteUserById(uid) == 1) {
      return new RespBean("0", "删除成功");
    } else {
      return new RespBean("1", "删除失败");
    }
  }

  @RequestMapping(value = "/user/role", method = RequestMethod.PUT)
  public RespBean updateUserRoles(Long[] rids, Long id) {
    if (userService.updateUserRoles(rids, id) == rids.length) {
      return new RespBean("0", "更新成功");
    } else {
      return new RespBean("1", "更新失败");
    }
  }
}
