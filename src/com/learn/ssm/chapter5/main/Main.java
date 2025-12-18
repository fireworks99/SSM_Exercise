package com.learn.ssm.chapter5.main;

import com.learn.ssm.chapter5.mapper.DeptMapper;
import com.learn.ssm.chapter5.mapper.UserMapper;
import com.learn.ssm.chapter5.pojo.Dept;
import com.learn.ssm.chapter5.pojo.PageParam;
import com.learn.ssm.chapter5.pojo.Role;
import com.learn.ssm.chapter5.pojo.User;
import com.learn.ssm.chapter5.utils.SqlSessionFactoryUtils;
import com.learn.ssm.chapter5.mapper.RoleMapper;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        SqlSession sqlSession = null;

        try {
            sqlSession = SqlSessionFactoryUtils.openSqlSession();
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            Role role = roleMapper.getRole(11L);
            System.out.println(role.toString());

            // 1.Map传参
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("roleName", "is");
            hashMap.put("note", "st");
            List<Role> rolesByMap = roleMapper.findRolesByMap(hashMap);
            System.out.println(rolesByMap.toString());

            // 2.注解传参
            List<Role> rolesByAnnotation = roleMapper.findRolesByAnnotation("is", "st");
            System.out.println(rolesByAnnotation.toString());

            // 3.Java Bean传参
            Role role1 = new Role();
            role1.setRoleName("is");
            role1.setNote("st");
            List<Role> rolesByBean = roleMapper.findRolesByBean(role1);
            System.out.println(rolesByBean.toString());

            // 4.混合传参(注解 + Java Bean)
            PageParam pageParam = new PageParam();
            pageParam.setPageNo(1);
            pageParam.setPageSize(1);
            List<Role> byMix = roleMapper.findByMix(role1, pageParam);
            System.out.println(byMix);

            System.out.println("------------------------------------------------------------------------------------------");

            // resultMap应用场景: 多表联合查询
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user1 = userMapper.getUser(1L);
            User user2 = userMapper.getUser(2L);
            System.out.println(user1.toString());
            System.out.println(user2.toString());

            // RowBounds
            RowBounds rowBounds = new RowBounds(1, 1);
            List<User> users = userMapper.getUserRowBounds(rowBounds);
            System.out.println(users.toString());

            // insert
            DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);
            Dept dept = new Dept();
            dept.setName("销售部");
            deptMapper.insertDept(dept);
            System.out.println(dept.toString());//Dept{id=null, name='销售部'}

            Dept dept1 = new Dept();
            dept1.setName("运维部");
            deptMapper.insertDept2(dept1);
            System.out.println(dept1.toString());//Dept{id=8, name='运维部'}

            Dept deptBefore = new Dept();
            deptBefore.setName("Before部");
            deptMapper.insertDeptBefore(deptBefore);
            System.out.println(deptBefore.toString());//Dept{id=11, name='Before部'}

            Dept deptAfter = new Dept();
            deptAfter.setName("After部");
            deptMapper.insertDeptAfter(deptAfter);
            System.out.println(deptAfter.toString());//Dept{id=12, name='After部'}

            // Dynamic column + resultType=map
            List<Map<String, Object>> list = userMapper.selectDynamicColumns("id,username,deptId");
            System.out.println(list);//[{deptId=1, id=1, username=admin}, {deptId=2, id=2, username=user}]

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
