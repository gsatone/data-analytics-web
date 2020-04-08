package main.java.rgf.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@RequestMapping(method=RequestMethod.GET)
	public String welcomeEmployee(ModelMap model) {
		System.out.println("EmployeeController Invoked");
		model.addAttribute("name", "Hello Employee!");
		model.addAttribute("greetings", "Welcome to Risk Assessment!!!");
		return "hello";

	}
}
