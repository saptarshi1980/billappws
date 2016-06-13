package in.net.dpl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class NavigationController{
	@RequestMapping(value="/index.dpl",method = RequestMethod.GET)
	public ModelAndView index(){
 
		ModelAndView model = new ModelAndView("index"); 
		return model;
	}
}
