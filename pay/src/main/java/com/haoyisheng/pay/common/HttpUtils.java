package com.haoyisheng.pay.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class HttpUtils {
	
	
	public static String sendPostRequest(String postUrl ,String content){

		OutputStream write = null;
	    BufferedReader reader = null;
	    String resultString="";
		try{
			
	        URL url = new URL(postUrl); 
	        HttpURLConnection connection =(HttpURLConnection) url.openConnection();
	        connection.setRequestMethod("POST");
	        //connection.setRequestProperty("accept", "*/*");
	        //connection.setRequestProperty("connection", "Keep-Alive");
	        //connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
	        // conn.setConnectTimeout(10000);//连接超时 单位毫秒
	        // conn.setReadTimeout(2000);//读取超时 单位毫秒
	        connection.setDoOutput(true);
	        connection.setDoInput(true);
	        write=connection.getOutputStream();
	        write.write(content.getBytes("UTF-8"));
		   	reader =new BufferedReader(new InputStreamReader(connection.getInputStream(),"utf-8"));
		   	String lines;
		   	while((lines= reader.readLine())!=null){
		   		resultString += lines;  
		   	}
		   	reader.close();
		   	connection.disconnect(); 
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			try{
                if(write!=null){
                	write.close();
                }
                if(reader!=null){
                	reader.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
		}
		return resultString;
		
	}
	
	
	
}
