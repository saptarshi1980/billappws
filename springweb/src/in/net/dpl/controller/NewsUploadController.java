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

import in.net.dpl.model.TenderModel;
import in.net.dpl.utility.TodayAsString;
import org.springframework.context.support.ClassPathXmlApplicationContext;


 
/**
 * Handles requests for the application file upload requests
 */
@Controller
public class NewsUploadController {
 
    
    @RequestMapping(value = "/newsshow.htm", method = RequestMethod.POST)
	public String displayForm(@RequestParam("title") String title,@RequestParam("description") String description,HttpServletRequest request) {
		request.setAttribute("title", title);
		request.setAttribute("description", description);
    	return "news_upload_form";
	}
    

	@RequestMapping(value = "/uploadMultipleNewsFile.htm", method = RequestMethod.POST)
	public String savePdf(@ModelAttribute("uploadForm") FileUploadForm uploadForm,
                    Model map,HttpServletRequest request,@RequestParam("title") String title,@RequestParam("description") String description) throws IllegalStateException, IOException {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		String saveDirectory = "C:/uploads/pdf/";
        List<MultipartFile> files = uploadForm.getFiles();
        System.out.println("Size-"+files.size());
        
        List<String> fileNames = new ArrayList<String>();
        String id=new TodayAsString().todayWithTimeAsString();
        NewsDAO newsdao=(NewsDAO) ctx.getBean("newsdao");
        int status=newsdao.saveNews(title,description,id);
         
        if(null != files && files.size() > 0) {
            for (MultipartFile multipartFile : files) {
 
                String fileName = new TodayAsString().todayWithTimeAsString()+"_"+multipartFile.getOriginalFilename();
                System.out.println("File Name-"+fileName);
                fileNames.add(fileName);
                //Handle file content - multipartFile.getInputStream()
                
                multipartFile.transferTo(new File(saveDirectory + fileName)); 
                //Here I Added
                
                int statusfile=newsdao.saveNewsFile(id,fileName);
                
                System.out.println(status);
            }
        }
         
        //map.addAttribute("files", fileNames);
        return "file_upload_success";
    }
	
	
}