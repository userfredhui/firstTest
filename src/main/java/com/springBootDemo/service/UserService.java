package com.springBootDemo.service;

import com.springBootDemo.bean.Role;
import com.springBootDemo.bean.User;
import com.springBootDemo.mapper.UserMapper;
import com.springBootDemo.mapper.RolesMapper;
import com.springBootDemo.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.sql.Timestamp;
import java.util.List;

/**
 * created by lipenghui on 2019/4/2
 **/
@Service
public class UserService implements UserDetailsService {
  @Autowired
  UserMapper userMapper;
  @Autowired
  RolesMapper rolesMapper;

  @Override
  public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
    User user = userMapper.loadUserByUserName(s);
    if (user == null) {
      return new User();
    }
    List<Role> roles = rolesMapper.getRolesByUid(user.getId());
    user.setRoles(roles);
    return user;
  }

  /**
   * 注册方法 1是用户已经存在 2 失败 0 成功
   * @param user
   * @return
   */
  public int reg(User user) {
    User loadUserByUserName =  userMapper.loadUserByUserName(user.getUsername());
    if (loadUserByUserName != null) {
      return 1;
    }
    // 插入用户，插入之前先对密码进行加密
    user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
    user.setEnabled(true); // 用户可用
    user.setRegTime(new Timestamp(System.currentTimeMillis()));
    Long result = userMapper.reg(user);
    // 配置用户的角色，默认都是普通用户
    String[] roles = new String[]{"2"};
    int i = rolesMapper.addRoles(roles, user.getId());
    boolean b = i == roles.length && result == 1; // 添加成功
    if (b) {
      return 0;
    } else {
      return 2;
    }
  }

  /**
   * 登录方法 1是用户不存在 2 密码错误 0 成功
   * @param user
   * @return
   */
  public int login(User user) {
    User loadUserByUserName =  userMapper.loadUserByUserName(user.getUsername());
    System.out.println("loadUserByUserName---------:" + loadUserByUserName);
    if (loadUserByUserName == null) {
      return 1;
    }
    String currentUserPassword = user.getPassword();
    String savedPassword = loadUserByUserName.getPassword();
    System.out.println("currentUserPassword--------+" + currentUserPassword + "savedPassword------+" + savedPassword);
    boolean b = currentUserPassword.equals(savedPassword); // 密码是否一样
    if (b) {
      return 0;
    } else {
      return 2;
    }
  }

  public List<User> getUserByNickname(String nickname) {
    List<User> users = userMapper.getUserByNickname(nickname);
    return users;
  }

  public int updateUserEmail(String email) {
    return userMapper.updateUserEmail(email, Util.getCurrentUser().getId());
  }

  public int updateUserEnabled(Boolean enabled, Long uid) {
    return userMapper.updateUserEnabled(enabled, uid);
  }

  public int deleteUserById(Long uid) {
    return userMapper.deleteUserById(uid);
  }

  public int updateUserRoles(Long[] rids, Long id) {
    int i = userMapper.deleteUserRolesByUid(id);
    System.out.println("i----------------------------:" + i);
    return userMapper.setUserRoles(rids, id);
  }

  public List<Role> getAllRole() {
    return userMapper.getAllRole();
  }

  public User getUserById(Long id) {
    return userMapper.getUserById(id);
  }
}
