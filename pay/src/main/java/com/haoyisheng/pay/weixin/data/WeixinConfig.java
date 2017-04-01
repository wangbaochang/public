package com.haoyisheng.pay.weixin.data;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class WeixinConfig {
	
	private String placeOrderUrl;
	
	private String queryOrderUrl;
	
	private String closeOrderUrl;
	
	private String appid;
	
	private String mch_id;
	
	private String key;
	
	private String notify_url;
	
	
	
	public  WeixinConfig (){
			Properties prop =  new  Properties();
			InputStream in=null; 
			try  {
				in=this.getClass().getResourceAsStream( "/weixin.properties" );
	            prop.load(in);
	            this.setPlaceOrderUrl(prop.getProperty( "placeOrderUrl" ).trim());
	            this.setQueryOrderUrl(prop.getProperty( "queryOrderUrl" ).trim());
	            this.setCloseOrderUrl(prop.getProperty( "closeOrderUrl" ).trim());
	            this.setAppid(prop.getProperty( "appid" ).trim());
	            this.setMch_id(prop.getProperty( "mch_id" ).trim());
	            this.setKey(prop.getProperty( "key" ).trim());
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
	
	

	public String getPlaceOrderUrl() {
		return placeOrderUrl;
	}

	public void setPlaceOrderUrl(String placeOrderUrl) {
		this.placeOrderUrl = placeOrderUrl;
	}

	public String getQueryOrderUrl() {
		return queryOrderUrl;
	}

	public void setQueryOrderUrl(String queryOrderUrl) {
		this.queryOrderUrl = queryOrderUrl;
	}

	public String getCloseOrderUrl() {
		return closeOrderUrl;
	}

	public void setCloseOrderUrl(String closeOrderUrl) {
		this.closeOrderUrl = closeOrderUrl;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getMch_id() {
		return mch_id;
	}

	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}

	public String getNotify_url() {
		return notify_url;
	}

	public void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
	}



	public String getKey() {
		return key;
	}



	public void setKey(String key) {
		this.key = key;
	}
	
	

}
