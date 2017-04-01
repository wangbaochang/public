package com.haoyisheng.pay.alipay.data;

import java.io.Serializable;

public class AlipayQueryOrderReqData implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * String	特殊可选	64	订单支付时传入的商户订单号,和支付宝交易号不能同时为空。 trade_no,out_trade_no如果同时存在优先取trade_no	20150320010101001
	 */
	private String out_trade_no;	
	
	/**
	 *String	特殊可选	64	支付宝交易号，和商户订单号不能同时为空	2014112611001004680 073956707 
	 */
	private String trade_no;

	public String getOut_trade_no() {
		return out_trade_no;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	public String getTrade_no() {
		return trade_no;
	}

	public void setTrade_no(String trade_no) {
		this.trade_no = trade_no;
	}	
	
	
}
