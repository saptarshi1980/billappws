package in.net.dpl.utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.SecureRandom;
import java.util.Random;

public class OtpString {
	String mobile=null;
	

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	private final String USER_AGENT = "Mozilla/5.0";
	public static String randomString(char[] characterSet, int length) {
	    Random random = new SecureRandom();
	    char[] result = new char[length];
	    for (int i = 0; i < result.length; i++) {
	        // picks a random index out of character set > random character
	        int randomCharIndex = random.nextInt(characterSet.length);
	        result[i] = characterSet[randomCharIndex];
	    }
	    return new String(result);
	}
	
	public String getOtp(){
		char[] CHARSET_AZ_09 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
		return randomString(CHARSET_AZ_09, 7);
	}
	
	
	public void callSMSWs(String mobile){
		
		try{
					this.setMobile(mobile);
					
					String url = "http://192.168.30.9/WsSMS/smsws/sendotp?otp="+getOtp()+"&mobile="+mobile;
					System.out.println(url);
					String newurl=url.replaceAll(" ","%20");
					URL obj = new URL(newurl);
					HttpURLConnection con = (HttpURLConnection) obj.openConnection();
					con = (HttpURLConnection) obj.openConnection();
					con.setRequestMethod("GET");
					con.setRequestProperty("User-Agent", USER_AGENT);
					int responseCode = con.getResponseCode();
					System.out.println("\nSending 'GET' request to URL : " + url);
					System.out.println("Response Code : " + responseCode);

					BufferedReader in = new BufferedReader(
				        new InputStreamReader(con.getInputStream()));
					String inputLine;
					StringBuffer response = new StringBuffer();

						while ((inputLine = in.readLine()) != null) {
								response.append(inputLine);
								}
							in.close();

							System.out.println(response.toString());
				
					
				}catch(IOException ex){
					ex.printStackTrace();
				}
				catch(Exception ex){
					ex.printStackTrace();
				}		
	
	
	
	}
}
