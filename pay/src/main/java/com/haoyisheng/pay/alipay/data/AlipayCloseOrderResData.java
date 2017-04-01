package com.haoyisheng.pay.alipay.data;

import java.io.Serializable;

public class AlipayCloseOrderResData implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * String	是	-	网关返回码,详见文档	40004
	 */
	private String code;	
	
	/**
	 * String	是	-	网关返回码描述,详见文档	Business Failed
	 */
	private String msg;
	
	/**
	 * String	否	-	业务返回码,详见文档	ACQ.TRADE_HAS_SUCCESS
	 */
	private String sub_code;
	
	/**
	 * String	否	-	业务返回码描述,详见文档	交易已被支付
	 */
	private String sub_msg;	
	
	/**
	 * 	String	是	-	签名,详见文档	DZXh8eeTuAHoYE3w1J+POiPhfDxOYBfUNn1lkeT/V7P4zJdyojWEa6IZs6Hz0yDW5Cp/viufUb5I0/V5WENS3OYR8zRedqo6D+fUTdLHdc+EFyCkiQhBxIzgngPdPdfp1PIS7BdhhzrsZHbRqb7o4k3Dxc+AAnFauu4V6Zdwczo=
	 */
	private String sign;
	
	/**
	 * String	选填	64	支付宝交易号	2013112111001004500000675971
	 */
	private String trade_no;	
	
	/**
	 * String	选填	64	创建交易传入的商户订单号	YX_001
	 */
	private String out_trade_no;

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

	public String getTrade_no() {
		return trade_no;
	}

	public void setTrade_no(String trade_no) {
		this.trade_no = trade_no;
	}

	public String getOut_trade_no() {
		return out_trade_no;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}
	
	
}
