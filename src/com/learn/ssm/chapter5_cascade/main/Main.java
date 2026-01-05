package com.learn.ssm.chapter5_cascade.main;

import com.learn.ssm.chapter5_cascade.utils.SqlSessionFactoryUtils;
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
            logger.info(employee instanceof MaleEmployee);//true
            logger.info(employee.toString());

            Employee employee4 = employeeMapper.getEmployee2(1L);
            logger.info(employee4.toString());

            Employee employee2 = employeeMapper.getEmployee(2L);// 返回 FemaleEmployee 对象
            logger.info(employee2 instanceof FemaleEmployee);//true
            logger.info(employee2.toString());

            Employee employee5 = employeeMapper.getEmployee2(2L);
            logger.info(employee5.toString());

            Employee employee3 = employeeMapper.getEmployee(3L);// 返回 MaleEmployee 对象
            logger.info(employee3 instanceof MaleEmployee);//true
            logger.info(employee3.toString());

            Employee employee6 = employeeMapper.getEmployee2(3L);
            logger.info(employee6.toString());

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
