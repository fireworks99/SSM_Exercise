package com.learn.ssm.chapter5_user_role.mapper;

import com.learn.ssm.chapter5_user_role.pojo.Role;

import java.util.List;

public interface RoleMapper {

    Role getRole(Long id);
    List<Role> findRolesByUserId(Long user_id);
}
