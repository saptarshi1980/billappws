package in.net.dpl.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import in.net.dpl.dao.AppDisplayDAO;
import in.net.dpl.dao.AppModifyDAO;
import in.net.dpl.dao.LoginDAO;
import in.net.dpl.dao.OtpDAO;
import in.net.dpl.dao.TempConDAO;
import in.net.dpl.domain.LoginSS;
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
	public ModelAndView swHome(){
 
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
	
	@RequestMapping("/allocateSS.dpl")
    public ModelAndView allocateSS(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView model = new ModelAndView("appModifySuccess"); 
	try {
     
		String ssName=request.getParameter("ss");
		String appNo=request.getParameter("app_no");
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
    	AppModifyDAO appmodifypdao=(AppModifyDAO) ctx.getBean("modifydao");
    	appmodifypdao.updateSS(appNo, ssName);
    	model.addObject("msg","Application no "+appNo+" has been forwarded to Sub-Station "+ssName);
    	
    		
		
    }
	catch (Exception e){
        
        e.printStackTrace();
    }
	return model;
	
	}
	
	@RequestMapping(value="/ssHome.dpl",method = RequestMethod.GET)
	public ModelAndView subStationHome(HttpServletRequest request,RedirectAttributes redirectAttributes,@RequestParam("ssName") String ssName,@RequestParam("ssCode") String ssCode){
 
		
		request.getSession().setAttribute("ssCode", ssCode);
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
    	AppDisplayDAO appdao=(AppDisplayDAO) ctx.getBean("aDisplayss");
    	ModelAndView model = new ModelAndView("appListSS"); 
		model.addObject("list",appdao.viewApplicationSS(ssName));
		return model;
		
	}
	
	@RequestMapping(value="/viewAppSS.dpl",method = RequestMethod.GET)
	public ModelAndView appDetailSS(HttpServletRequest request){
 
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
    	AppDisplayDAO appdao=(AppDisplayDAO) ctx.getBean("aDisplay");
    	//appdao.viewDetail(request.getParameter("app_no"));
		ModelAndView model = new ModelAndView("appDetailsSS"); 
		model.addObject("list",appdao.viewDetail(request.getParameter("app_no")));
		model.addObject("ssList",appdao.ssList());
		
		return model;
	}
	
	@RequestMapping(value="/loginSS.dpl",method = RequestMethod.GET)
	public ModelAndView loginSS(){
 
		ModelAndView model = new ModelAndView("loginSS"); 
		return model;
	}
	
	
	@RequestMapping(value="/authSS.dpl",method = RequestMethod.POST)
	public String authSS(@RequestParam("uid") String uid,@RequestParam("pass") String pass,HttpServletRequest request,RedirectAttributes redirectAttributes){
		request.setAttribute("uid", uid);
		request.setAttribute("pass", pass);
		String ssName=null;
		String ssCode=null;
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
    	LoginDAO logindao=(LoginDAO) ctx.getBean("logindao");
    	
    	List<LoginSS> list = new ArrayList<LoginSS>();
    	list=logindao.loginSS(uid, pass);
    	
    	if(list.size()>0){
    		for (LoginSS ss:list){
    			ssName=ss.getSsName();
  		      	ssCode=ss.getSsCode();
    		}
    		   		
    		 
    		 redirectAttributes.addAttribute("ssName", ssName);
    		 redirectAttributes.addAttribute("ssCode", ssCode);
    		    		 
    		 return "redirect:/ssHome.dpl";
    	}
    	else{
    		return "redirect:/loginSS.dpl";
    	}
}
	
	@RequestMapping("/updatePrelSS.dpl")
    public ModelAndView updatePrelSS(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView model = new ModelAndView("appModifySuccess"); 
	try {
     
		String appNo=request.getParameter("app_no");
		String ssCode=request.getParameter("ss_code");
		System.out.println("SS Code-"+ssCode);
		String cablingMode=request.getParameter("cb");
		double length=Double.parseDouble(request.getParameter("length"));
		String remarks=request.getParameter("remarks");
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
    	AppModifyDAO appmodifypdao=(AppModifyDAO) ctx.getBean("modifydao");
    	appmodifypdao.updatePrelSS(appNo, ssCode, cablingMode, length, remarks);
    	model.addObject("msg","Application no "+appNo+" has been updated");
    	
    		
		
    }
	catch (Exception e){
        
        e.printStackTrace();
    }
	return model;
	
	}
	
	
	
	
	
}
