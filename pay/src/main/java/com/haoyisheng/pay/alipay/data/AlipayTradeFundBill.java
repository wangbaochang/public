package com.haoyisheng.pay.alipay.data;

import java.io.Serializable;
import java.math.BigDecimal;

public class AlipayTradeFundBill implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String fund_channel;// String; 必填 32 交易使用的资金渠道，详见 支付渠道列表 ALIPAYACCOUNT
	
	private BigDecimal amount;// Price 选填 - 该支付工具类型所使用的金额 10
	
	private BigDecimal real_amount;// Price 选填 11 渠道实际付款金额 11.21

	public String getFund_channel() {
		return fund_channel;
	}

	public void setFund_channel(String fund_channel) {
		this.fund_channel = fund_channel;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getReal_amount() {
		return real_amount;
	}

	public void setReal_amount(BigDecimal real_amount) {
		this.real_amount = real_amount;
	}
	
	
	
}
