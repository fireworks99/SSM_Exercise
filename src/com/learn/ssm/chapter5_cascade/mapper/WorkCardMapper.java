package com.learn.ssm.chapter5_cascade.mapper;

import com.learn.ssm.chapter5_cascade.pojo.WorkCard;

public interface WorkCardMapper {
    WorkCard getWorkCardByEmpId(Long empId);
}
