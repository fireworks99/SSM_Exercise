package com.learn.ssm.chapter5_sp.mapper;

import com.learn.ssm.chapter5_sp.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    void deleteUser(Long id);

    void getUserCount(Map<String, Object> params);

    void countUserBySex(Map<String, Object> params);

    List<User> listUsers();
}
