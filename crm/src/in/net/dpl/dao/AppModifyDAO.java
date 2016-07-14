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
		String query3="update application_master set phase_id='2' where app_no='"+appNo+"'";
		jdbcTemplate.update(queryUpdate);
		jdbcTemplate.update(queryUpdate2);
		jdbcTemplate.update(query3);
	}
	
	public void updatePrelSS(String appNo,String ssCode,String cablingMode,double length,String remarks){
		
		String query1="insert into substation_activity(substation_code,application_no,cabling_mode,cable_length,remarks,time_stamp) values('"+ssCode+"','"+appNo+"','"+cablingMode+"','"+length+"','"+remarks+"',NOW())";
		String query2="insert into application_activity (app_no,phase_id,time_stamp) values('"+appNo+"','3',NOW())";
		String query3="update application_master set phase_id='3' where app_no='"+appNo+"'";
		jdbcTemplate.update(query1);
		jdbcTemplate.update(query2);
		jdbcTemplate.update(query3);
		
		
	}
}
