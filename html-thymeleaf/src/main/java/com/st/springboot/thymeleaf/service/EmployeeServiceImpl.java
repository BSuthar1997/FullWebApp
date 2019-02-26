package com.st.springboot.thymeleaf.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.springboot.thymeleaf.dao.DataRepository;
import com.st.springboot.thymeleaf.dao.EmployeeRepository;
import com.st.springboot.thymeleaf.entity.Data;
import com.st.springboot.thymeleaf.entity.Employee;




@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private DataRepository dataRepository;
	
	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAllByOrderByLastNameAsc();
	}

	@Override
	public Employee findById(int id) {
		
		Optional<Employee> result=employeeRepository.findById(id);
		
		Employee employee=null;
		if(result.isPresent())
		{
			employee=result.get();
		}
		else
		{
			throw new RuntimeException("Did not find user"+id);
		}
		return employee;
	}

	@Override
	public void save(Employee employee) {
		employeeRepository.save(employee);

	}

	@Override

	public void deleteById(int id) {
		employeeRepository.deleteById(id);

	}

	@Override
	public void saveData(Data data) {
		
		dataRepository.save(data);
	}

}
