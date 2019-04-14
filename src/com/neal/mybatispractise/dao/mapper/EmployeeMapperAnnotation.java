package com.neal.mybatispractise.dao.mapper;

import org.apache.ibatis.annotations.Select;

import com.neal.mybatispractise.entity.Employee;

public interface EmployeeMapperAnnotation {
	@Select("select * from tb1_employee where id=#{id}")
	public Employee getEmployeeByIdAnnotation(Integer id);
}
