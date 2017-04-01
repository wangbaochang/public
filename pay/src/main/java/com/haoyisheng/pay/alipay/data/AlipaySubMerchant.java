package com.haoyisheng.pay.alipay.data;

import java.io.Serializable;

public class AlipaySubMerchant implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String merchant_id;// String 必填 11 二级商户的支付宝id 19023454

	public String getMerchant_id() {
		return merchant_id;
	}

	public void setMerchant_id(String merchant_id) {
		this.merchant_id = merchant_id;
	}
	
}
