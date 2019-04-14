package com.neal.mybatispractise.dao.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import com.neal.mybatispractise.entity.Employee;

public interface EmployeeMapper {
	public Employee getEmployeeById(Integer id);

	public Employee getEmployeeByIdAndName(@Param("id") Integer id, @Param("lastName") String lastName);

	public Employee getEmployeeByMap(Map<String, Object> queryParams);

	public Map<String, Object> getEmployeeByIdToMap(Integer id);

	public List<Employee> getEmployeeByNameFuzzy(@Param("lastName") String lastName);

	@MapKey("id")
	public Map<Integer, Employee> getEmployeeByNameFuzzyToMap(@Param("lastName") String lastName);
	
	public Employee getEmployeeByIdResultMap(@Param("id") Integer id);
	
	public List<Employee> getEmpDynamic(Employee employee);
	
	public List<Employee> getEmpDynamicForeach(@Param("ids")List<Integer> ids);
	
	public List<Employee> getEmpsPage(); 

	public Integer addEmployee(Employee employee);
	
	public void addEmps(@Param("emps")List<Employee> emps);

	public Integer updateEmployee(Employee employee);

	public Integer delEmployee(Employee employee);

}
