package in.net.dpl.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCountCallbackHandler;
import in.net.dpl.utility.*;


public class OtpDAO {

	private JdbcTemplate jdbcTemplate; 
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {  
	    this.jdbcTemplate = jdbcTemplate;  
	}  
	
	public void sendSMS(String mobile){  
	    
		new   OtpString().callSMSWs(mobile);
	      
	} 
	
	public String verifyOtp(String mobile,String otp){
		
		
		String query="SELECT * FROM otp WHERE mobile='"+mobile+"' AND otp='"+otp+"' AND TIMESTAMPDIFF(MINUTE,TIME_STAMP,NOW())<16 ORDER BY time_stamp DESC LIMIT 1";
		RowCountCallbackHandler countCallback = new RowCountCallbackHandler();
		jdbcTemplate.query(query, countCallback);
		int rowCount = 0;
		rowCount=countCallback.getRowCount();
		
		if(rowCount>0){
			return "Y";
		}
		
		else return "F";
		
		
		
		
		
	}
	
	
	
	
}