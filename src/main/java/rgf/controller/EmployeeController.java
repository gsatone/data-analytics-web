package main.java.rgf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import main.java.rgf.data.service.EmployeeService;
import main.java.rgf.data.service.EmployeeServiceImpl;

@Controller
@RequestMapping(value = "/employee")
public class EmployeeController {

	 @Autowired
     private EmployeeService employeeService;
	
	 @RequestMapping(method=RequestMethod.GET)
	 public String welcomeEmployee(ModelMap model) {
		 System.out.println("EmployeeController Invoked");
		 model.addAttribute("name", "Hello Employee!");
		 model.addAttribute("greetings", "Welcome to Risk Assessment!!!");
		 return "hello";

	 }

	 @RequestMapping(value = "/listEmployees", method = RequestMethod.GET)
	 public String listEmployees(ModelMap model) {model.addAttribute("employeesList",
			 employeeService.listEmployee());
	 return "employee";
	 }

	@RequestMapping(value = "/{employeeId}", method = RequestMethod.GET)
	public String getEmployee (@PathVariable("employeeId")int employeeId, ModelMap model){

		return "employeeList";
	} 

}
