package com.springBootDemo.mapper;

import com.springBootDemo.bean.Role;
import com.springBootDemo.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;;
import java.util.List;

/**
 * created by robin.wu on 2019/4/2
 **/
@Mapper
public interface UserMapper {
  List<User> getUser(@Param("age") int age);

  long reg(User user);

  User loadUserByUserName(@Param("username") String username);

  List<User> getUserByNickname(@Param("nickname") String nickname);

  int updateUserEmail(@Param("email") String email, @Param("id") Long id);

  int updateUserEnabled(@Param("enabled") Boolean enabled, @Param("uid") Long uid);

  int deleteUserById(Long uid);

  int deleteUserRolesByUid(Long id);

  int setUserRoles(@Param("rids") Long[] rids, @Param("id") Long id);

  List<Role>  getAllRole();

  User getUserById(@Param("id") Long id);
}
