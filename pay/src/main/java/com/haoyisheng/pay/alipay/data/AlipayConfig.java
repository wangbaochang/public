package com.haoyisheng.pay.alipay.data;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AlipayConfig {
	
	private String orderUrl;
	
	private String appid;
	
	private String appPrivateKey;
	
	private String alipayPublicKey;
	
	private String notify_url;
	
	
	public  AlipayConfig(){
			Properties prop =  new  Properties();
			InputStream in=null; 
			try  {
				in=this.getClass().getResourceAsStream( "/alipay.properties" );
	            prop.load(in);
	            this.setOrderUrl(prop.getProperty("orderUrl" ).trim());
	            this.setAppid(prop.getProperty( "appid" ).trim());
	            this.setAppPrivateKey(prop.getProperty( "appPrivateKey" ).trim());
	            this.setAlipayPublicKey(prop.getProperty( "alipayPublicKey" ).trim());
	            this.setNotify_url(prop.getProperty( "notify_url" ).trim());
			}  catch  (IOException e) {    
	            e.printStackTrace();    
	        }  
			finally {
				if(in!=null){
					try{
						in.close();
					}
					catch(Exception e){
						
					}
				}
			}  
	}

	public String getOrderUrl() {
		return orderUrl;
	}

	public void setOrderUrl(String orderUrl) {
		this.orderUrl = orderUrl;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getAppPrivateKey() {
		return appPrivateKey;
	}

	public void setAppPrivateKey(String appPrivateKey) {
		this.appPrivateKey = appPrivateKey;
	}

	public String getAlipayPublicKey() {
		return alipayPublicKey;
	}

	public void setAlipayPublicKey(String alipayPublicKey) {
		this.alipayPublicKey = alipayPublicKey;
	}

	public String getNotify_url() {
		return notify_url;
	}

	public void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
	}
}
