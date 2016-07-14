package in.net.dpl.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCountCallbackHandler;





public class TempConDAO {

	
private static JdbcTemplate jdbcTemplate; 
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {  
	    this.jdbcTemplate = jdbcTemplate;  
	}  
	
	public static synchronized int findRef(String year){  
		String sql = "SELECT * FROM application_master WHERE date_format(application_date,'%y')='"+year+"'";
		 //System.out.println("SQL-"+sql);
		//int total = jdbcTemplate.queryForInt(sql);
		RowCountCallbackHandler countCallback = new RowCountCallbackHandler();
		jdbcTemplate.query(sql, countCallback);
		int rowCount = countCallback.getRowCount();
		//System.out.println("Row count-"+rowCount);			
		//return total;
		return rowCount+1;
	}
	
	public void saveApplication(String appNo,String load,String phase,String address1,String address2,String pin_code,String landmark,String landline,String name,String mobile,String application_date,String filepath){  
		double loadDb=Double.parseDouble(load);
		double phaseDb=Double.parseDouble(phase);
		
		String query="insert into application_master(app_no,name,con_load,phase,address1,address2,pin,landmark,landline,mobile,application_date,time_stamp,file_path,phase_id) values('"+appNo+"','"+name+"','"+Math.round(loadDb)+"','"+Math.round(phaseDb)+"','"+address1+"','"+address2+"','"+pin_code+"','"+landmark+"','"+landline+"','"+mobile+"','"+application_date+"',NOW(),'"+filepath+"','1')";  
	    jdbcTemplate.update(query);
	    String updatePhase="insert into application_activity (app_no,phase_id,time_stamp) values('"+appNo+"','1',NOW())";
	    jdbcTemplate.update(updatePhase);
	}  
}
