package in.net.dpl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/pp")
public class PowerPlantPage{
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView index(){
 
		ModelAndView model = new ModelAndView("ppDPL"); 
		return model;
	}
}
