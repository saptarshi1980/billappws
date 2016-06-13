package in.net.dpl.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import in.net.dpl.dao.NewsDAO;


import in.net.dpl.utility.TodayAsString;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Controller
public class NewsLoginAuth {
	
	@RequestMapping(value = "/newsLoginAuth.htm", method = RequestMethod.POST)
	public String displayForm(@RequestParam("user_id") String user_id,@RequestParam("password") String password,HttpServletRequest request) {
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
    	NewsDAO newsdao=(NewsDAO) ctx.getBean("newsdao");
    	String data=newsdao.newsLoginAuth(user_id, password);
    	
    	if(!data.matches("UNAUTHORIZED"))
    	{
    		return "newsDetailsEntry";
    	}else{
    		return "news_upload_login";
    	}
	}
	
	

}
