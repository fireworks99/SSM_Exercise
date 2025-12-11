package com.learn.ssm.chapter5.mapper;

import com.learn.ssm.chapter5.pojo.PageParam;
import com.learn.ssm.chapter5.pojo.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface RoleMapper {
    public Role getRole(Long id);
    public List<Role> findRolesByMap(Map<String,Object> parameterMap);
    public List<Role> findRolesByAnnotation(@Param("roleName") String roleName, @Param("note") String note) ;
    public List<Role> findRolesByBean(Role role);
    public List<Role> findByMix(@Param("params") Role role, @Param("page") PageParam PageParam) ;
}
