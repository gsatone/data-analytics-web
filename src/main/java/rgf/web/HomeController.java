package main.java.rgf.web;

import static org.springframework.web.bind.annotation.RequestMethod.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/home","/"})
public class HomeController {
	
	@RequestMapping(method=GET)
	public String home(ModelMap model) {
		System.out.println("Home Controler Invoked");
		model.addAttribute("name", "Hello Employee!");
		model.addAttribute("greetings", "Welcome to Risk Assessment!!!");
		return "home"; 

	}
	
}
