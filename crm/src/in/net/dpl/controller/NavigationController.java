package in.net.dpl.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.net.dpl.dao.OtpDAO;
import in.net.dpl.dao.TempConDAO;
import in.net.dpl.utility.OtpString;

@Controller

public class NavigationController{
	@RequestMapping(value="/index.dpl",method = RequestMethod.GET)
	public ModelAndView index(){
 
		ModelAndView model = new ModelAndView("index"); 
		return model;
	}
	@RequestMapping(value="/otp.dpl",method = RequestMethod.POST)
	public ModelAndView otp(@RequestParam("name") String name,@RequestParam("mobile") String mobile,HttpServletRequest request){
		request.setAttribute("name", name);
		request.setAttribute("mobile", mobile);
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
    	OtpString otpString=(OtpString) ctx.getBean("otpString");
    	otpString.callSMSWs(mobile);
		ModelAndView model = new ModelAndView("otp"); 
		return model;
	}
	@RequestMapping(value="/otpValidator.dpl",method = RequestMethod.POST)
	public ModelAndView otpValidator(@RequestParam("name") String name,@RequestParam("mobile") String mobile,@RequestParam("otp") String otp,HttpServletRequest request){
		request.setAttribute("name", name.toUpperCase());
		request.setAttribute("mobile", mobile);
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
    	OtpDAO otpdao=(OtpDAO) ctx.getBean("otpdao");
    	if(otpdao.verifyOtp(mobile, otp.toUpperCase()).matches("Y")){
		ModelAndView model = new ModelAndView("newConn"); 
		return model;
    	}
    	else{
    		ModelAndView model = new ModelAndView("otp"); 
    		return model;
    	}
	}
}
