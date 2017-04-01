package com.haoyisheng.pay.alipay.data;

import java.io.Serializable;

public class AlipayOrderResData implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	private AlipayQueryOrderResData alipay_trade_query_response;
	
	private AlipayPlaceOrderResData alipay_trade_precreate_response;
	
	private AlipayCloseOrderResData alipay_trade_close_response;
	
	private AlipayPlaceOrderResData alipay_trade_pay_response;
	
	private String sign;

	public AlipayQueryOrderResData getAlipay_trade_query_response() {
		return alipay_trade_query_response;
	}

	public void setAlipay_trade_query_response(AlipayQueryOrderResData alipay_trade_query_response) {
		this.alipay_trade_query_response = alipay_trade_query_response;
	}

	public AlipayPlaceOrderResData getAlipay_trade_precreate_response() {
		return alipay_trade_precreate_response;
	}

	public void setAlipay_trade_precreate_response(AlipayPlaceOrderResData alipay_trade_precreate_response) {
		this.alipay_trade_precreate_response = alipay_trade_precreate_response;
	}

	public AlipayCloseOrderResData getAlipay_trade_close_response() {
		return alipay_trade_close_response;
	}

	public void setAlipay_trade_close_response(AlipayCloseOrderResData alipay_trade_close_response) {
		this.alipay_trade_close_response = alipay_trade_close_response;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public AlipayPlaceOrderResData getAlipay_trade_pay_response() {
		return alipay_trade_pay_response;
	}

	public void setAlipay_trade_pay_response(AlipayPlaceOrderResData alipay_trade_pay_response) {
		this.alipay_trade_pay_response = alipay_trade_pay_response;
	}	
	
	
}
