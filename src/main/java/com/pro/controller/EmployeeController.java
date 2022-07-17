package com.pro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pro.entities.Employee;
import com.pro.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService service;

	@Autowired
	Employee emp;

	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
	public ModelAndView addEmployee(@RequestParam("name") String name, @RequestParam("salary") String salary) {

		emp.setName(name);
		emp.setSalary(Integer.parseInt(salary));

		ModelAndView mv = new ModelAndView();
		mv.setViewName("welcome");

		String res = null;

		if (service.addEmployee(emp)) {
			res = "employee details added in database Successfully!!!";
			mv.addObject("res", res);
		} else {
			res = "unable to add employee details in database!!!";
			mv.addObject("res", res);
		}
		return mv;
	}
}
