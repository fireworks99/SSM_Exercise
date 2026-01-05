package com.learn.ssm.chapter5_sp.main;

import com.learn.ssm.chapter5_sp.mapper.UserMapper;
import com.learn.ssm.chapter5_sp.pojo.User;
import com.learn.ssm.chapter5_sp.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        SqlSession sqlSession = null;

        try {
            Logger logger = Logger.getLogger(Main.class);
            sqlSession = SqlSessionFactoryUtils.openSqlSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            userMapper.deleteUser(2L);

            Map<String, Object> map = new HashMap<>();
            userMapper.getUserCount(map);
            Integer userCount = (Integer) map.get("total");
            logger.info(userCount);//1

            Map<String, Object> map2 = new HashMap<>();
            map2.put("p_sex", 1);
            userMapper.countUserBySex(map2);
            Integer total = (Integer) map2.get("total");
            logger.info(total);//1

            List<User> users = userMapper.listUsers();
            logger.info(users);//[User{id=1, username='Max}]

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
