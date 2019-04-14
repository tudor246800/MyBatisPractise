package com.neal.mybatispractise.interceptor;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import com.neal.mybatispractise.entity.EmpStatus;

public class MyEnumHandler implements TypeHandler<EmpStatus>{

	@Override
	public void setParameter(PreparedStatement ps, int i, EmpStatus parameter, JdbcType jdbcType) throws SQLException {
		// TODO Auto-generated method stub
		ps.setString(i, parameter.getCode().toString());
	}

	@Override
	public EmpStatus getResult(ResultSet rs, String columnName) throws SQLException {
		// TODO Auto-generated method stub
		return EmpStatus.getEmpStatusByCode(rs.getInt(columnName));
	}

	@Override
	public EmpStatus getResult(ResultSet rs, int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		return EmpStatus.getEmpStatusByCode(rs.getInt(columnIndex));
	}

	@Override
	public EmpStatus getResult(CallableStatement cs, int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		return EmpStatus.getEmpStatusByCode(cs.getInt(columnIndex));
	}

}
