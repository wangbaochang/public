package com.haoyisheng.pay;

import java.io.Serializable;
import java.math.BigDecimal;

public class Order implements Serializable{
	
	
	public Order(String orderNumber,String orderDescription,BigDecimal orderFee,String spbillCreateIP){
		this.orderNumber=orderNumber;
		this.orderDescription=orderDescription;
		this.orderFee=orderFee;
		this.spbillCreateIP=spbillCreateIP;
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 定单编号
	 */
	private String orderNumber;
	
	/**
	 * 外部平台生成的定单编号
	 */
	private String payOrderNumber;
	
	/**
	 * 定单描述
	 */
	private String orderDescription;
	
	/**
	 *  定单总金额
	 */
	private BigDecimal orderFee;
	
	/**
	 * 终端IP
	 */
	private String spbillCreateIP;
	
	
	/**
	 * 定单状态
	 */
	private PayStatus status; 

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getOrderDescription() {
		return orderDescription;
	}

	public void setOrderDescription(String orderDescription) {
		this.orderDescription = orderDescription;
	}

	public BigDecimal getOrderFee() {
		BigDecimal d=orderFee.setScale(2, BigDecimal.ROUND_HALF_UP); 
		return d;
	}
	
	public String getOrderFeeOfCent(){
		BigDecimal d=orderFee.multiply(new BigDecimal(100));
		d=d.setScale(0, BigDecimal.ROUND_HALF_UP); 
		return d.toString();
	}

	public void setOrderFee(BigDecimal orderFee) {
		this.orderFee = orderFee;
	}

	public String getSpbillCreateIP() {
		return spbillCreateIP;
	}

	public void setSpbillCreateIP(String spbillCreateIP) {
		this.spbillCreateIP = spbillCreateIP;
	}

	public String getPayOrderNumber() {
		return payOrderNumber;
	}

	public void setPayOrderNumber(String payOrderNumber) {
		this.payOrderNumber = payOrderNumber;
	}

	public PayStatus getStatus() {
		return status;
	}

	public void setStatus(PayStatus status) {
		this.status = status;
	}
	
	
	
}
