package in.net.dpl.dao;

import in.net.dpl.domain.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;


public class AppDisplayDAO {
	
	Connection connection;
    Statement stmt;
    private int noOfRecords;
    private static JdbcTemplate jdbcTemplate; 
    
    public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {  
	    this.jdbcTemplate = jdbcTemplate;  
	}  

	
	public List<Application> viewApplication(String applicationMonth){
		
	   String query = "SELECT app_no,DATE_FORMAT(application_date,'%d-%m-%Y') AS application_date,name,round(con_load) AS con_load,concat(address1,' ',address2,' ',pin,' ',landmark) AS address,mobile,phase,file_path from application_master where date_format(application_date,'%m/%Y')='"+applicationMonth+"' order by time_stamp ";
       List<Application> list = new ArrayList<Application>();
       List<Map<String, Object>> rows = getJdbcTemplate().queryForList(query);
       
       for (Map<String, Object> row:rows){
    	   Application application =new Application();
    	   application.setApplicationNumber((String)row.get("app_no"));
    	   application.setAddress((String)row.get("address"));
    	   application.setApplicationDate((String)row.get("application_date"));
    	   application.setApplicatantName((String)row.get("name"));
    	   application.setConnectionLoad((Double)row.get("con_load"));
    	   application.setPhase((Double)row.get("phase"));
    	   application.setMobile((String)row.get("mobile"));
    	   application.setFilePath((String)row.get("file_path"));
    	   list.add(application);
      	   
       }
       System.out.println("List-"+list.size());
       return list;
       
	}
	
	public List<Application> viewDetail(String appNo){
		
		   String query = "SELECT app_no,DATE_FORMAT(application_date,'%d-%m-%Y') AS application_date,name,round(con_load) AS con_load,concat(address1,' ',address2,' ',pin,' ',landmark) AS address,mobile,phase,file_path from application_master where app_no='"+appNo+"' order by time_stamp ";
	       List<Application> list = new ArrayList<Application>();
	       List<Map<String, Object>> rows = getJdbcTemplate().queryForList(query);
	       
	       for (Map<String, Object> row:rows){
	    	   Application application =new Application();
	    	   application.setApplicationNumber((String)row.get("app_no"));
	    	   application.setAddress((String)row.get("address"));
	    	   application.setApplicationDate((String)row.get("application_date"));
	    	   application.setApplicatantName((String)row.get("name"));
	    	   application.setConnectionLoad((Double)row.get("con_load"));
	    	   application.setPhase((Double)row.get("phase"));
	    	   application.setMobile((String)row.get("mobile"));
	    	   application.setFilePath((String)row.get("file_path"));
	    	   list.add(application);
	      	   
	       }
	       System.out.println("List-"+list.size());
	       return list;
	       
		}
	
	public List<String> ssList(){
		
		   String query = "select ss_name from substation_master";
	       List<String> list = new ArrayList<String>();
	       List<Map<String, Object>> rows = getJdbcTemplate().queryForList(query);
	       
	       for (Map<String, Object> row:rows){
	    	   	   list.add((String)row.get("ss_name"));
	      	   
	       }
	       System.out.println("List-"+list.size());
	       return list;
	       
		}
}
