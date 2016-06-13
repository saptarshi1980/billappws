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
	@RequestMapping(value="/otp.dpl",method = RequestMethod.POST)
	public ModelAndView otp(){
 
		ModelAndView model = new ModelAndView("otp"); 
		return model;
	}
	@RequestMapping(value="/otpValidator.dpl",method = RequestMethod.POST)
	public ModelAndView otpValidator(){
 
		ModelAndView model = new ModelAndView("newConn"); 
		return model;
	}
}
