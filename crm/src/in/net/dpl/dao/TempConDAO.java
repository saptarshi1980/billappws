package in.net.dpl.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCountCallbackHandler;





public class TempConDAO {

	
private JdbcTemplate jdbcTemplate; 
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {  
	    this.jdbcTemplate = jdbcTemplate;  
	}  
	
	public int findRef(String year){  
		String sql = "SELECT * FROM application_master WHERE date_format(application_date,'%Y')='"+year+"'";
		 System.out.println("SQL-"+sql);
		//int total = jdbcTemplate.queryForInt(sql);
		RowCountCallbackHandler countCallback = new RowCountCallbackHandler();
		jdbcTemplate.query(sql, countCallback);
		int rowCount = countCallback.getRowCount();
		System.out.println("Row count-"+rowCount);			
		//return total;
		return rowCount+1;
	}
	
	public int saveApplication(String conNo,String load,String phase,String address1,String address2,String pin_code,String landmark,String landline,String name,String mobile,String application_date){  
	    
		String query="insert into application_master(temp_con_no,name,con_load,phase,address1,address2,pin,landmark,landline,mobile,application_date,time_stamp) values('"+conNo+"','"+name+"','"+load+"','"+phase+"','"+address1+"','"+address2+"','"+pin_code+"','"+landmark+"','"+landline+"','"+mobile+"','"+application_date+"',NOW())";  
	    return jdbcTemplate.update(query);  
	}  
}
