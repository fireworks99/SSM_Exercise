package com.learn.ssm.chapter3.main;

import com.learn.ssm.chapter3.mapper.RoleMapper;
import com.learn.ssm.chapter3.pojo.Role;
import com.learn.ssm.chapter3.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        testRoleMapper();
    }

    private static void testRoleMapper() {
        Logger logger = Logger.getLogger(Main.class);
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtils.openSqlSession();
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);

            Role role = new Role();
            role.setId(1L);
            role.setRoleName("Admin");
            role.setNote("System role");
            int num = roleMapper.insertRole(role);
            logger.info(num);//1

            Role role1 = roleMapper.getRole(1L);
            logger.info(role1);//com.learn.ssm.chapter3.pojo.Role@551a20d6

            role1.setRoleName("Administrator");
            num = roleMapper.updateRole(role1);
            logger.info(num);//1

            Role role2 = new Role();
            role2.setId(2L);
            role2.setRoleName("Visitor");
            role2.setNote("Unregistered");
            num = roleMapper.insertRole(role2);
            logger.info(num);//1

            List<Role> roles = roleMapper.findRoles("i");
            logger.info(roles);
            // [com.learn.ssm.chapter3.pojo.Role@7a11c4c7, com.learn.ssm.chapter3.pojo.Role@4cc547a]

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
