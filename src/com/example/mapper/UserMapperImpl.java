package com.example.mapper;

import com.example.pojo.User;

import java.lang.reflect.Method;

public class UserMapperImpl implements UserMapper {
    @Override
    public User selectUserById(int id) {
        // 连接数据库并实现：SELECT * FROM users WHERE id = #{id}
        return null;
    }

    // 通过反射，生成对象并调度方法
    public Object reflect() {
        UserMapperImpl object = null;
        try {
            object = (UserMapperImpl) Class.forName("com.example.mapper.UserMapperImpl").newInstance();
            Method method = object.getClass().getMethod("selectUserById", Integer.class);
            method.invoke(object, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return object;
    }
}
