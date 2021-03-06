package in.net.dpl.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import in.net.dpl.dao.TempConDAO;




@Controller

public class UploadFormController implements HandlerExceptionResolver{

	
	@RequestMapping(value="/UploadForm.dpl",method=RequestMethod.POST)
    public String showForm(ModelMap model,@RequestParam("load") String load,@RequestParam("phase") String phase,@RequestParam("address1") String address1,@RequestParam("address1") String address2,@RequestParam("pin_code") String pin_code,@RequestParam("landmark") String landmark,@RequestParam("landline") String landline,@RequestParam("name") String name,@RequestParam("mobile") String mobile,HttpServletRequest request){
		request.setAttribute("name", name.toUpperCase());
		request.setAttribute("mobile", mobile);
		request.setAttribute("load", load);
		request.setAttribute("phase", phase);
		request.setAttribute("address1", address1.toUpperCase());
		request.setAttribute("address2", address2.toUpperCase());
		request.setAttribute("pin_code", pin_code);
		request.setAttribute("landmark", landmark.toUpperCase());
		request.setAttribute("landline", landline);
		UploadForm form = new UploadForm();
        model.addAttribute("FORM", form);
        return "FileUploadForm";
    }

    
    @RequestMapping(value="/FileUploadForm.dpl",method=RequestMethod.POST)
    public String processForm(@ModelAttribute(value="FORM") UploadForm form,BindingResult result,@RequestParam("load") String load,@RequestParam("phase") String phase,@RequestParam("address1") String address1,@RequestParam("address1") String address2,@RequestParam("pin_code") String pin_code,@RequestParam("landmark") String landmark,@RequestParam("landline") String landline,@RequestParam("name") String name,@RequestParam("mobile") String mobile,HttpServletRequest request){
        
    	String applicationDate=getDate();
    	if(!result.hasErrors()){
            
        	//System.out.println(load);
        	FileOutputStream outputStream = null;
            
            
            try {
            	String year =String.valueOf(Calendar.getInstance().get(Calendar.YEAR)-2000);
            	ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
            	TempConDAO tdao=(TempConDAO) ctx.getBean("tdao");
            	int rowcount=tdao.findRef(year);
            	System.setProperty("java.io.tmpdir", "d:/uploadcrm");
                String path=System.getProperty("java.io.tmpdir")+"/"+applicationDate+"/"+rowcount;
                File f = new File(path);
                f.mkdirs();
                String filePath = path+"/"+form.getFile().getOriginalFilename();
            	outputStream = new FileOutputStream(new File(filePath));
                outputStream.write(form.getFile().getFileItem().get());
                outputStream.close();
                System.out.println(filePath);
                String appNo=year+String.format("%04d",rowcount);
            	request.setAttribute("appNo", appNo);
 	         	tdao.saveApplication(appNo, load, phase, address1, address2, pin_code, landmark, landline, name, mobile, applicationDate,filePath);
            	
            	
                
                
                
            } catch (Exception e) {
                //System.out.println("Error while saving file");
                e.printStackTrace();
                return "FileUploadForm";
            }
            return "success";
        }else{
            return "FileUploadForm";
        }
    }

    @Override
    public ModelAndView resolveException(HttpServletRequest arg0,
    HttpServletResponse arg1, Object arg2, Exception exception) {
        Map<Object, Object> model = new HashMap<Object, Object>();
        if (exception instanceof MaxUploadSizeExceededException){
            model.put("errors", "File size should be less then "+
            ((MaxUploadSizeExceededException)exception).getMaxUploadSize()+" byte.");
        } else{
            model.put("errors", "Unexpected error: " + exception.getMessage());
        }
        model.put("FORM", new UploadForm());
        return new ModelAndView("FileUploadForm", (Map) model);
    }
    public String getDate(){
		
    	Calendar cal = Calendar.getInstance();
    	SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
    	String formatted = format1.format(cal.getTime());
    	return formatted; 
	}
}