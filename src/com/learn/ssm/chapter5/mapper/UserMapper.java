package com.learn.ssm.chapter5.mapper;

import com.learn.ssm.chapter5.pojo.User;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface UserMapper {
    User getUser(Long id);
    List<User> getUserRowBounds(RowBounds rowBounds);
}
