package com.haoyisheng.pay.alipay.data;

import java.io.Serializable;
import java.math.BigDecimal;

public class AlipayVoucherDetail implements Serializable {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    
	private String id;// String 必填 32 券id 2015102600073002039000002D5O
	
	private String name;// String 必填 64 券名称 XX超市5折优惠
	
	private String type;// String 必填 32 当前有三种类型： ALIPAY_FIX_VOUCHER - 全场代金券 ALIPAY_DISCOUNT_VOUCHER - 折扣券 ALIPAY_ITEM_VOUCHER - 单品优惠 注：不排除将来新增其他类型的可能，商家接入时注意兼容性避免硬编码 ALIPAY_FIX_VOUCHER
	
	private BigDecimal amount;// Price 必填 8 优惠券面额，它应该会等于商家出资加上其他出资方出资 10.00
	
	private BigDecimal merchant_contribute;// Price 选填 8 商家出资（特指发起交易的商家出资金额） 9.00
	
	private BigDecimal other_contribute;// Price 选填 8 其他出资方出资金额，可能是支付宝，可能是品牌商，或者其他方，也可能是他们的一起出资 1.00
	
	private String memo;// String 选填 256 优惠券备注信息 学生专用优惠

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getMerchant_contribute() {
		return merchant_contribute;
	}

	public void setMerchant_contribute(BigDecimal merchant_contribute) {
		this.merchant_contribute = merchant_contribute;
	}

	public BigDecimal getOther_contribute() {
		return other_contribute;
	}

	public void setOther_contribute(BigDecimal other_contribute) {
		this.other_contribute = other_contribute;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}
	
	
}
