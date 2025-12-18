package com.learn.ssm.chapter5.mapper;

import com.learn.ssm.chapter5.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    User getUser(Long id);
    List<User> getUserRowBounds(RowBounds rowBounds);
    List<Map<String,Object>> selectDynamicColumns(@Param("columns") String columns);
}
