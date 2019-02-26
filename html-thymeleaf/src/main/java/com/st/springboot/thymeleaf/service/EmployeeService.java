package com.st.springboot.thymeleaf.service;

import java.util.List;

import com.st.springboot.thymeleaf.entity.Data;
import com.st.springboot.thymeleaf.entity.Employee;


public interface EmployeeService {
	
	public List<Employee> findAll();
	
	public Employee findById(int id);
	
	public void save(Employee employee);
	
	public void deleteById(int id);
  
	
	public void saveData(Data data);
}
