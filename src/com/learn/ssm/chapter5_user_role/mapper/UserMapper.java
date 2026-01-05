package com.learn.ssm.chapter5_user_role.mapper;

import com.learn.ssm.chapter4.pojo.User;

import java.util.List;

public interface UserMapper {

     User getUser(Long id);
     List<User> findUsersByRoleId(Long role_id);
}
