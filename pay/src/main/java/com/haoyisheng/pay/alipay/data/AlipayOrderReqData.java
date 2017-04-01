package com.haoyisheng.pay.alipay.data;

import java.io.Serializable;

public class AlipayOrderReqData implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//  String	是	32	支付宝分配给开发者的应用ID	2014072300007148
	private String app_id;	
	//  String	是	128	接口名称	alipay.trade.precreate
	private String method;
	//	String	否	40	仅支持JSON	JSON
	private String format;
	//	String	是	10	请求使用的编码格式，如utf-8,gbk,gb2312等	utf-8
	private String charset;
	//	String	是	10	商户生成签名字符串所使用的签名算法类型，目前支持RSA2和RSA，推荐使用RSA2	RSA2
	private String sign_type;
	//	String	是	256	商户请求参数的签名串，详见签名	详见示例
	private String sign;
	//	String	是	19	发送请求的时间，格式"yyyy-MM-dd HH:mm:ss"	2014-07-24 03:07:50
	private String timestamp;
	//  String	是	3	调用的接口版本，固定为：1.0	1.0
	private String version;	
	//  String	否	256	支付宝服务器主动通知商户服务器里指定的页面http/https路径。	http://api.test.alipay.net/atinterface/receive_notify.htm
	private String notify_url;	
	//	String	否	40	详见应用授权概述	
	private String app_auth_token;
	//	String	是	-	请求参数的集合，最大长度不限，除公共参数外所有请求参数都必须放在这个参数中传递，具体参照各产品快速接入文档
	private String biz_content;
	
	public String getApp_id() {
		return app_id;
	}
	public void setApp_id(String app_id) {
		this.app_id = app_id;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public String getCharset() {
		return charset;
	}
	public void setCharset(String charset) {
		this.charset = charset;
	}
	public String getSign_type() {
		return sign_type;
	}
	public void setSign_type(String sign_type) {
		this.sign_type = sign_type;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getNotify_url() {
		return notify_url;
	}
	public void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
	}
	public String getApp_auth_token() {
		return app_auth_token;
	}
	public void setApp_auth_token(String app_auth_token) {
		this.app_auth_token = app_auth_token;
	}
	public String getBiz_content() {
		return biz_content;
	}
	public void setBiz_content(String biz_content) {
		this.biz_content = biz_content;
	}	
	
		
}
