/*
 *  Copyright ©Tsunasama 2018 - 2023.
 *  Project : TextLearning
 *  File : optionTypeHandler.java
 *  Date : 18-5-21 下午11:01
 */

package com.tsuna.textLearning.persistance.typeHandler;

import com.tsuna.textLearning.persistance.bean.Option;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class optionTypeHandler implements TypeHandler<Option> {
    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, Option option, JdbcType jdbcType) throws SQLException {
        preparedStatement.setString(i, option.getDb());
    }

    @Override
    public Option getResult(ResultSet resultSet, String s) throws SQLException {
        return Option.getOption(resultSet.getString(s));
    }

    @Override
    public Option getResult(ResultSet resultSet, int i) throws SQLException {
        return Option.getOption(resultSet.getString(i));
    }

    @Override
    public Option getResult(CallableStatement callableStatement, int i) throws SQLException {
        return Option.getOption(callableStatement.getString(i));
    }
}
