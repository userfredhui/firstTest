package com.springBootDemo.mapper;

import com.springBootDemo.bean.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * created by lipenghui on 2019/4/11
 **/
@Mapper
public interface RolesMapper {
  int addRoles(@Param("roles") String[] roles, @Param("uid") Long uid);

  List<Role> getRolesByUid(Long uid);
}
