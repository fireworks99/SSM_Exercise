package com.learn.ssm.chapter4.main;

import com.learn.ssm.chapter4.pojo.User;
import com.learn.ssm.chapter4.mapper.UserMapper;
import com.learn.ssm.chapter4.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;

public class Main {
    public static void main(String[] args) {
        SqlSession sqlSession = null;

        try {
            sqlSession = SqlSessionFactoryUtils.openSqlSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            User user = new User();
            user.setId(1L);
            user.setUsername("admin");
            user.setSex(1);
            int num = userMapper.insertUser(user);
            System.out.println(num);//1

            User user1 = userMapper.getUser(1L);
            System.out.println(user1.getPassword());//null

            //提交事务
            sqlSession.commit();
        } catch (Exception e) {
            if(sqlSession != null) {
                sqlSession.rollback();
            }
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}
