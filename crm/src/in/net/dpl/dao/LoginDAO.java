package in.net.dpl.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import in.net.dpl.domain.Application;
import in.net.dpl.domain.LoginSS;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class LoginDAO {

	
	
private JdbcTemplate jdbcTemplate; 
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {  
	    this.jdbcTemplate = jdbcTemplate;  
	}  
	
	public List<LoginSS> loginSS(String uid,String pass){
		
		String query="SELECT * FROM substation_master WHERE user_id='"+uid+"' AND PASSWORD='"+pass+"'";
		List<LoginSS> list = new ArrayList<LoginSS>();
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(query);
		for (Map<String, Object> row:rows){
	    	   LoginSS ss =new LoginSS();
	    	   ss.setSsCode((String)row.get("ss_code"));
	    	   ss.setSsName((String)row.get("SS_Name"));
	    	   //System.out.println("Inside Login SS DAO-"+(String)row.get("SS_Name"));
	    	   list.add(ss);
	      	   
	       }
	       //System.out.println("List-"+list.size());
	       return list;
		
	}
	
	
}
