package com.learn.ssm.chapter5_cascade.mapper;

import com.learn.ssm.chapter5_cascade.pojo.EmployeeTask;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeTaskMapper {
    List<EmployeeTask> getEmployeeTasksByEmpId(Long empId);
}
