package com.learn.ssm.chapter5_user_role.main;

import com.learn.ssm.chapter5_user_role.mapper.RoleMapper;
import com.learn.ssm.chapter5_user_role.pojo.Role;
import com.learn.ssm.chapter5_user_role.pojo.User;
import com.learn.ssm.chapter5_user_role.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        SqlSession sqlSession = null;

        try {
            Logger logger = Logger.getLogger(Main.class);
            sqlSession = SqlSessionFactoryUtils.openSqlSession();
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            Role role = roleMapper.getRole(1L);
//            logger.info(role.toString());函数无限互相调用，造成栈溢出(StackOverflow)
            List<User> userList = role.getUserList();
//            logger.info(userList);//函数无限互相调用，造成栈溢出(StackOverflow)

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
