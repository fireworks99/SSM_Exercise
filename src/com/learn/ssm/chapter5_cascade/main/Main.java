package com.learn.ssm.chapter5_cascade.main;

import com.learn.ssm.chapter5.utils.SqlSessionFactoryUtils;
import com.learn.ssm.chapter5_cascade.mapper.EmployeeMapper;
import com.learn.ssm.chapter5_cascade.pojo.Employee;
import com.learn.ssm.chapter5_cascade.pojo.FemaleEmployee;
import com.learn.ssm.chapter5_cascade.pojo.MaleEmployee;
import org.apache.ibatis.session.SqlSession;

import org.apache.log4j.Logger;

public class Main {
    public static void main(String[] args) {
        SqlSession sqlSession = null;

        try {
            Logger logger = Logger.getLogger(Main.class);
            sqlSession = SqlSessionFactoryUtils.openSqlSession();
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

            Employee employee = employeeMapper.getEmployee(1L);// 返回 MaleEmployee 对象
            logger.info(employee.toString()) ;

            Employee employee2 = employeeMapper.getEmployee(2L);// 返回 FemaleEmployee 对象
            logger.info(employee2.toString());

            Employee employee3 = employeeMapper.getEmployee(3L);// 返回 MaleEmployee 对象
            logger.info(employee3.toString());

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
