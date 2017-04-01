package com.haoyisheng.pay.alipay.data;

import java.math.BigDecimal;

public class AlipayRoyaltyDetailInfos {
	
	// Number 可选 9 分账序列号，表示分账执行的顺序，必须为正整数 1
	private Long serial_no;
	
	// String 可选 24 接受分账金额的账户类型： 	
	//userId：支付宝账号对应的支付宝唯一用户号。  
	//bankIndex：分账到银行账户的银行编号。目前暂时只支持分账到一个银行编号。 
	//storeId：分账到门店对应的银行卡编号。 默认值为userId。 userId
	private String trans_in_type;
	
	
	private String batch_no;// String 必填 32 分账批次号 分账批次号。 目前需要和转入账号类型为bankIndex配合使用。 123
	
	private String out_relation_id;// String 可选 64 商户分账的外部关联号，用于关联到每一笔分账信息，商户需保证其唯一性。 如果为空，该值则默认为“商户网站唯一订单号+分账序列号” 20131124001
	
	private String trans_out_type;// String 必填 24 要分账的账户类型。 目前只支持userId：支付宝账号对应的支付宝唯一用户号。 默认值为userId。 userId
	
	private String trans_out;// String 必填 16 如果转出账号类型为userId，本参数为要分账的支付宝账号对应的支付宝唯一用户号。以2088开头的纯16位数字。 2088101126765726
	
	private String trans_in;// String 必填 28 如果转入账号类型为userId，本参数为接受分账金额的支付宝账号对应的支付宝唯一用户号。以2088开头的纯16位数字。 	如果转入账号类型为bankIndex，本参数为28位的银行编号（商户和支付宝签约时确定）。 如果转入账号类型为storeId，本参数为商户的门店ID。 2088101126708402
	
	private BigDecimal amount;// Number 必填 9 分账的金额，单位为元 0.1
	
	private String desc;// String 可选 1000 分账描述信息 分账测试1
	
	private String amount_percentage;// String 可选 3 分账的比例，值为20代表按20%的比例分账 100

	public Long getSerial_no() {
		return serial_no;
	}

	public void setSerial_no(Long serial_no) {
		this.serial_no = serial_no;
	}

	public String getTrans_in_type() {
		return trans_in_type;
	}

	public void setTrans_in_type(String trans_in_type) {
		this.trans_in_type = trans_in_type;
	}

	public String getBatch_no() {
		return batch_no;
	}

	public void setBatch_no(String batch_no) {
		this.batch_no = batch_no;
	}

	public String getOut_relation_id() {
		return out_relation_id;
	}

	public void setOut_relation_id(String out_relation_id) {
		this.out_relation_id = out_relation_id;
	}

	public String getTrans_out_type() {
		return trans_out_type;
	}

	public void setTrans_out_type(String trans_out_type) {
		this.trans_out_type = trans_out_type;
	}

	public String getTrans_out() {
		return trans_out;
	}

	public void setTrans_out(String trans_out) {
		this.trans_out = trans_out;
	}

	public String getTrans_in() {
		return trans_in;
	}

	public void setTrans_in(String trans_in) {
		this.trans_in = trans_in;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getAmount_percentage() {
		return amount_percentage;
	}

	public void setAmount_percentage(String amount_percentage) {
		this.amount_percentage = amount_percentage;
	}
	
	
}
