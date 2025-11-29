package com.learn.ssm.chapter4.mapper;

import com.learn.ssm.chapter4.pojo.User;

public interface UserMapper {
    int insertUser(User user);
    User getUser(Long id);
}
