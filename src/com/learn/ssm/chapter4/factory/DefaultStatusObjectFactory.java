package com.learn.ssm.chapter4.factory;

import com.learn.ssm.chapter4.pojo.User;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

public class DefaultStatusObjectFactory extends DefaultObjectFactory {

    @Override
    public <T> T create(Class<T> type) {

        // 让 MyBatis 按正常方式创建对象
        T obj = super.create(type);

        // 如果是 User 类，自动设置密码
        if (obj instanceof User) {
            User user = (User) obj;

            if(user.getPassword() == "") {
                user.setPassword("123456");  // 默认值
            }
            System.out.println("ObjectFactory 设置默认密码为 123456");
        }

        return obj;
    }
}
