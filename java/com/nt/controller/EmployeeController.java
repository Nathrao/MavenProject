package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nt.dao.EmployeeDAOImpl;
import com.nt.entity.Employee;

@Controller
@RequestMapping("/EmployeeDetails")
public class EmployeeController {
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public @ResponseBody String saveEmployee(@RequestBody Employee emp)
	{
		Employee employee=new Employee();
		employee.setEmpId(emp.getEmpId());
		employee.setEmpName(emp.getEmpName());
		employee.setSalary(emp.getSalary());
		EmployeeDAOImpl dao=new EmployeeDAOImpl();
		dao.insertEmployee(employee);
		return "Registration Successful";
	}

}
