package com.haoyisheng.pay.alipay.data;

import java.io.Serializable;

public class AlipayPlaceOrderResData implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String code;//	String	是	-	网关返回码,详见文档	40004
	
	private String msg;//	String	是	-	网关返回码描述,详见文档	Business Failed
	
	private String sub_code;//	String	否	-	业务返回码,详见文档	ACQ.TRADE_HAS_SUCCESS
	
	private String sub_msg;//	String	否	-	业务返回码描述,详见文档	交易已被支付
	
	private String sign;//	String	是	-	签名,详见文档	DZXh8eeTuAHoYE3w1J+POiPhfDxOYBfUNn1lkeT/V7P4zJdyojWEa6IZs6Hz0yDW5Cp/viufUb5I0/V5WENS3OYR8zRedqo6D+fUTdLHdc+EFyCkiQhBxIzgngPdPdfp1PIS7BdhhzrsZHbRqb7o4k3Dxc+AAnFauu4V6Zdwczo=
	
	private String out_trade_no;//	String	必填	64	商户的订单号	6823789339978248
	
	private String qr_code;//	String	必填	1024	当前预下单请求生成的二维码码串，可以用二维码生成工具根据该码串值生成对应的二维码	https://qr.alipay.com/bavh4wjlxf12tper3a

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getSub_code() {
		return sub_code;
	}

	public void setSub_code(String sub_code) {
		this.sub_code = sub_code;
	}

	public String getSub_msg() {
		return sub_msg;
	}

	public void setSub_msg(String sub_msg) {
		this.sub_msg = sub_msg;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getOut_trade_no() {
		return out_trade_no;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	public String getQr_code() {
		return qr_code;
	}

	public void setQr_code(String qr_code) {
		this.qr_code = qr_code;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
