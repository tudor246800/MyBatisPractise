package com.neal.mybatispractise.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.github.pagehelper.PageHelper;
import com.neal.mybatispractise.dao.mapper.DepartmentMapper;
import com.neal.mybatispractise.dao.mapper.EmployeeMapper;
import com.neal.mybatispractise.entity.Department;
import com.neal.mybatispractise.entity.EmpStatus;
import com.neal.mybatispractise.entity.Employee;

public class MybatisTest {

	public SqlSessionFactory getSqlSessionFactory() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		return new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void test() throws IOException {
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession session = sqlSessionFactory.openSession();
		try {
			Employee employee = session.selectOne("org.neal.mybatispractis.EmployeeMapper.selectEmployeeById", 1);
			System.out.println(employee.toString());
		} finally {
			session.close();
		}
	}

	@Test
	public void testMapper() throws IOException {
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession session = sqlSessionFactory.openSession();
		try {
			EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
//			EmployeeMapperAnnotation employeeMapperAnnotation = session.getMapper(EmployeeMapperAnnotation.class);
//			Employee employee = employeeMapper.getEmployeeById(1);
//			Employee employee2 = employeeMapperAnnotation.getEmployeeByIdAnnotation(1);
			
//			Employee employee = employeeMapper.getEmployeeByIdAndName(1, "Neal san");
//			Map<String, Object> queryParams=new HashMap<>();
//			queryParams.put("id", 1);
//			queryParams.put("lastName", "Neal san");
//			queryParams.put("tableName", "tb1_employee");
//			Employee employee = employeeMapper.getEmployeeByMap(queryParams);
			
//			System.out.println(employee);
			
			List<Employee> res = employeeMapper.getEmployeeByNameFuzzy("Neal");
			for(Employee employee : res){
				System.out.println(employee);
			}
			
//			Map<String, Object> employee = employeeMapper.getEmployeeByIdToMap(1);
//			System.out.println(employee);
			
//			Map<Integer, Employee> employee = employeeMapper.getEmployeeByNameFuzzyToMap("Neal%");
//			System.out.println(employee);
			
//			Employee employee = employeeMapper.getEmployeeByIdResultMap(1);
//			System.out.println(employee);
//			System.out.println(employee.getDept());
//			Employee employeeQuery = new Employee();
//			employeeQuery.setGender("0");
//			employeeQuery.setLastName("Nea%");
//			List<Employee> res = employeeMapper.getEmpDynamic(employeeQuery);
//			System.out.println(res);
			
//			List<Employee> res = employeeMapper.getEmpDynamicForeach(Arrays.asList(1, 4, 5));
//			List<Employee> res = employeeMapper.getEmpDynamicForeach(Arrays.asList());
//			for(Employee employee : res){
//				System.out.println(employee);
//			}
			
		} finally {
			session.close();
		}
	}

	@Test
	public void testCDUS() throws IOException {
		SqlSessionFactory sessionFactory = getSqlSessionFactory();
		SqlSession sqlSession = sessionFactory.openSession(ExecutorType.BATCH);
		try {
			Employee employee = new Employee(null, "Neal 2", "1", "4561.com", 1, EmpStatus.LOGIN);
			Employee employee2 = new Employee(null, "Neal 3", "1", "4526.com",2 , EmpStatus.LOGOUT);
			Employee employee3 = new Employee(null, "Neal 4", "1", "4546.com", 2,  EmpStatus.REMOVED);
//			Employee employee = new Employee(1, "Neal", null, null, nul3l);
			EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
//			employeeMapper.addEmployee(employee);
//			Integer res = employeeMapper.updateEmployee(employee);
//			employeeMapper.delEmployee(employee);
//			System.out.println(res);
			employeeMapper.addEmps(Arrays.asList(employee,employee2,employee3));
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}
	
	@Test
	public void testDept() throws IOException{
		SqlSessionFactory sessionFactory = getSqlSessionFactory();
		SqlSession sqlSession = sessionFactory.openSession();
		
		try{
			DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);
//			Department department = departmentMapper.getDeptById(1);
//			System.out.println(department);
//			System.out.println(department.getEmps());
			
			List<Department> departments = departmentMapper.getDeptByDept(new Department());
			for(Department dept :departments){
				System.out.println(dept);
			}
		}finally{
			sqlSession.close();
		}
	}
	
	@Test
	public void testCacheLevelOne() throws IOException{
		SqlSessionFactory sessionFactory = getSqlSessionFactory();
		SqlSession sqlSession = sessionFactory.openSession();
		try{
			EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
			Employee emp = mapper.getEmployeeById(1);
			System.out.println(emp);
			sqlSession.clearCache();
			Employee emp2 = mapper.getEmployeeById(1);
			System.out.println(emp2);
		}finally{
			sqlSession.close();
		}
	}
	
	@Test
	public void testCacheLevelTwo() throws IOException{
		SqlSessionFactory sessionFactory = getSqlSessionFactory();
		SqlSession sqlSession = sessionFactory.openSession();
		SqlSession sqlSession2 = sessionFactory.openSession();
		try{
			EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
			EmployeeMapper mapper2 = sqlSession2.getMapper(EmployeeMapper.class);
			Employee emp = mapper.getEmployeeById(1);
			System.out.println(emp);
			sqlSession.close();
			Employee emp2 = mapper2.getEmployeeById(1);
			System.out.println(emp2);
		}finally{
			sqlSession.close();
		}
	}
	
	@Test
	public void testPage() throws IOException{
		SqlSessionFactory sessionFactory = getSqlSessionFactory();
		SqlSession sqlSession = sessionFactory.openSession();
		try{
			EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
			PageHelper.startPage(1, 5);
			List<Employee> res = mapper.getEmpsPage();
			for(Employee employee : res){
				System.out.println(employee);
			}
		}finally{
			sqlSession.close();
		}
	}

}
