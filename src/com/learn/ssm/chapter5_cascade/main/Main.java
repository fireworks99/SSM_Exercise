package com.learn.ssm.chapter5_cascade.main;

import com.learn.ssm.chapter5.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;

public class Main {
    public static void main(String[] args) {
        SqlSession sqlSession = null;

        try {
            sqlSession = SqlSessionFactoryUtils.openSqlSession();
//            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
//            Role role = roleMapper.getRole(11L);
//            System.out.println(role.toString());


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
