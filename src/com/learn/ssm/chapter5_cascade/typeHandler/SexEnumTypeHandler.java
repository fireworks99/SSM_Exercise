package com.learn.ssm.chapter5_cascade.typeHandler;

import com.learn.ssm.chapter5_cascade.enumeration.SexEnum;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SexEnumTypeHandler implements TypeHandler<SexEnum> {

    // 把 Java 类型的参数转换成 JDBC 类型，设置到 PreparedStatement 中
    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, SexEnum parameter, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i, parameter.getId());
    }

    // 从 ResultSet 中取出某列，根据列名，转换成 Java 类型
    @Override
    public SexEnum getResult(ResultSet resultSet, String columnName) throws SQLException {
        int id = resultSet.getInt(columnName);
        return SexEnum.getSexById(id);
    }

    // 从 ResultSet 中取出某列，根据列索引，转换成 Java 类型
    @Override
    public SexEnum getResult(ResultSet resultSet, int columnIndex) throws SQLException {
        int id = resultSet.getInt(columnIndex);
        return SexEnum.getSexById(id);
    }

    // 从 CallableStatement 中取出某列（通常是存储过程的输出参数），转换成 Java 类型
    @Override
    public SexEnum getResult(CallableStatement callableStatement, int columnIndex) throws SQLException {
        int id = callableStatement.getInt(columnIndex);
        return SexEnum.getSexById(id);
    }
}
