package com.st.springboot.thymeleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.st.springboot.thymeleaf.entity.Data;
import com.st.springboot.thymeleaf.entity.Employee;
import com.st.springboot.thymeleaf.service.EmployeeService;


@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/index")
	public String index(Model model)
	{
		return "/employees/index";
	}
	
	
	@GetMapping("/list")
	public String getlist(Model model)
	{
		model.addAttribute("employees", employeeService.findAll());
		return "/employees/list-employee";
	}
	
	@GetMapping("/showFormForAdd")
	public String getFormForAdd(Model model)
	{
		Employee employee=new Employee();
		model.addAttribute("employee",employee);
		return "/employees/employee-form";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee employee)
	{
		employeeService.save(employee);
		Data d=new Data();
		d.setData("Bhargav");
		employeeService.saveData(d);
		return "redirect:/employees/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String update(@RequestParam("employeeId")int id,Model model)
	{
		Employee employee=employeeService.findById(id);
		model.addAttribute("employee",employee);
		return "/employees/employee-form";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("employeeId")int id,Model model)
	{
		employeeService.deleteById(id);
		return "redirect:/employees/list";
	}
	

}
