package com.learn.ssm.chapter5.mapper;

import com.learn.ssm.chapter5.pojo.Dept;

public interface DeptMapper {
    int insertDept(Dept dept);
    int insertDept2(Dept dept);
    int insertDeptBefore(Dept dept);
    int insertDeptAfter(Dept dept);
}
