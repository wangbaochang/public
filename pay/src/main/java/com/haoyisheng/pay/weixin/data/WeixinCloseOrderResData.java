package com.haoyisheng.pay.weixin.data;

import java.io.Serializable;

public class WeixinCloseOrderResData implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//返回结果
	//字段名	变量名	必填	类型	示例值	描述
	//返回状态码	是	String(16)	SUCCESS	SUCCESS/FAIL
	private String return_code;	
	//返回信息 否	String(128)	签名失败	返回信息，如非空，为错误原因 签名失败 参数格式校验错误 
	private String return_msg;	
	
	//以下字段在return_code为SUCCESS的时候有返回
	//公众账号ID		是	String(32)	wx8888888888888888	微信分配的公众账号ID
	private String appid;
	//商户号		是	String(32)	1900000109	微信支付分配的商户号
	private String mch_id;
	private String sub_mch_id;
	//随机字符串 	是	String(32)	5K8264ILTKCH16CQ2502SI8ZNMTM67VS	随机字符串，不长于32位	
	private String nonce_str;
	//签名	是	String(32)	C380BEC2BFD727A4B6845133519F3AD6	签名，验证签名算
	private String sign;	
	//业务结果	是	String(16)	SUCCESS	SUCCESS/FAIL
	private String result_code;	
	//业务结果描述	是	String(32)	OK	对于业务执行的详细描述
	private String result_msg;	
	//错误代码	否	String(32)	SYSTEMERROR	详细参见第6节错误列表
	private String err_code;	
	//错误代码描述	否	String(128)	系统错误	结果信息描述
	private String err_code_des;
	public String getReturn_code() {
		return return_code;
	}
	public void setReturn_code(String return_code) {
		this.return_code = return_code;
	}
	public String getReturn_msg() {
		return return_msg;
	}
	public void setReturn_msg(String return_msg) {
		this.return_msg = return_msg;
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
	public String getNonce_str() {
		return nonce_str;
	}
	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getResult_code() {
		return result_code;
	}
	public void setResult_code(String result_code) {
		this.result_code = result_code;
	}
	public String getResult_msg() {
		return result_msg;
	}
	public void setResult_msg(String result_msg) {
		this.result_msg = result_msg;
	}
	public String getErr_code() {
		return err_code;
	}
	public void setErr_code(String err_code) {
		this.err_code = err_code;
	}
	public String getErr_code_des() {
		return err_code_des;
	}
	public void setErr_code_des(String err_code_des) {
		this.err_code_des = err_code_des;
	}
	public String getSub_mch_id() {
		return sub_mch_id;
	}
	public void setSub_mch_id(String sub_mch_id) {
		this.sub_mch_id = sub_mch_id;
	}	
    
	
	
}
