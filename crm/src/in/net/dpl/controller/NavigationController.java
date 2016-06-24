package in.net.dpl.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.net.dpl.dao.AppDisplayDAO;
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
	
	@RequestMapping(value="/swHome.dpl",method = RequestMethod.GET)
	public ModelAndView subStationHome(){
 
		ModelAndView model = new ModelAndView("selectMonth"); 
		return model;
	}
	
	@RequestMapping(value="/ApplicationList.dpl",method = RequestMethod.POST)
	public ModelAndView appList(@RequestParam("monthpicker") String monthpicker,HttpServletRequest request){
 
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
    	AppDisplayDAO appdao=(AppDisplayDAO) ctx.getBean("aDisplay");
    	//appdao.viewApplication(monthpicker);
		ModelAndView model = new ModelAndView("appList"); 
		model.addObject("list",appdao.viewApplication(monthpicker));
		return model;
	}
	
	@RequestMapping(value="/viewApp.dpl",method = RequestMethod.GET)
	public ModelAndView appDetail(HttpServletRequest request){
 
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
    	AppDisplayDAO appdao=(AppDisplayDAO) ctx.getBean("aDisplay");
    	//appdao.viewDetail(request.getParameter("app_no"));
		ModelAndView model = new ModelAndView("appDetails"); 
		model.addObject("list",appdao.viewDetail(request.getParameter("app_no")));
		model.addObject("ssList",appdao.ssList());
		
		return model;
	}
	
	@RequestMapping("/downloadFile.dpl")
    public void doDownload(HttpServletRequest request,HttpServletResponse response) {
	      
	try {
        
		String filePathToBeServed = request.getParameter("file_path");
        File fileToDownload = new File(filePathToBeServed);
        InputStream inputStream = new FileInputStream(fileToDownload);
        response.setContentType("application/force-download");
        response.setHeader("Content-Disposition", "attachment; filename="+request.getParameter("app_no")+".pdf"); 
        IOUtils.copy(inputStream, response.getOutputStream());
        response.flushBuffer();
        inputStream.close();
    }catch (IOException e){
        
        e.printStackTrace();
    } 
	catch (Exception e){
        
        e.printStackTrace();
    }
	
	}
}
