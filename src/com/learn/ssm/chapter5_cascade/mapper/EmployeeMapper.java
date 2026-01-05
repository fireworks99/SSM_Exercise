package com.learn.ssm.chapter5_cascade.mapper;

import com.learn.ssm.chapter5_cascade.pojo.Employee;

public interface EmployeeMapper {
    Employee getEmployee(Long id);
    Employee getEmployee2(Long id);
}
