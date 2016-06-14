package in.net.dpl.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;



@Controller

public class UploadFormController implements HandlerExceptionResolver{

	
	@RequestMapping(value="/UploadForm.dpl",method=RequestMethod.POST)
    public String showForm(ModelMap model){
        UploadForm form = new UploadForm();
        model.addAttribute("FORM", form);
        return "FileUploadForm";
    }

    
    @RequestMapping(value="/FileUploadForm.dpl",method=RequestMethod.POST)
    public String processForm(@ModelAttribute(value="FORM") UploadForm form,BindingResult result){
        if(!result.hasErrors()){
            FileOutputStream outputStream = null;
            System.setProperty("java.io.tmpdir", "d:/uploadcrm");
            String filePath = System.getProperty("java.io.tmpdir") + "/" + form.getFile().getOriginalFilename();
            try {
                outputStream = new FileOutputStream(new File(filePath));
                outputStream.write(form.getFile().getFileItem().get());
                outputStream.close();
                System.out.println(filePath);
            } catch (Exception e) {
                System.out.println("Error while saving file");
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
}