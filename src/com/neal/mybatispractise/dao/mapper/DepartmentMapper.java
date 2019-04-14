package com.neal.mybatispractise.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.neal.mybatispractise.entity.Department;

public interface DepartmentMapper {
	public Department getDeptById(@Param("deptId") Integer deptId); 
	
	public List<Department> getDeptByDept(Department dept); 
	
}
