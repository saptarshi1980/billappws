package in.net.dpl.dao;


import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;


public class AppModifyDAO {

	
private JdbcTemplate jdbcTemplate; 
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {  
	    this.jdbcTemplate = jdbcTemplate;  
	}  
	
	public void updateSS(String appNo,String ssName){
		
		String queryUpdate="insert into application_substation(application_no,substation_name) values('"+appNo+"','"+ssName+"')";
		String queryUpdate2="insert into application_activity (app_no,phase_id,time_stamp) values('"+appNo+"','2',NOW())";
		jdbcTemplate.update(queryUpdate);
		jdbcTemplate.update(queryUpdate2);
	}
}
