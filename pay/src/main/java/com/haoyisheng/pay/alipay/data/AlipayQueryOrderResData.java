package com.haoyisheng.pay.alipay.data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class AlipayQueryOrderResData implements Serializable {
	
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String code;//	String	是	-	网关返回码,详见文档	40004
	
	private String msg;//	String	是	-	网关返回码描述,详见文档	Business Failed
	
	private String sub_code;//	String	否	-	业务返回码,详见文档	ACQ.TRADE_HAS_SUCCESS
	
	private String sub_msg;//	String	否	-	业务返回码描述,详见文档	交易已被支付
	
	private String sign;//	String	是	-	签名,详见文档	DZXh8eeTuAHoYE3w1J+POiPhfDxOYBfUNn1lkeT/V7P4zJdyojWEa6IZs6Hz0yDW5Cp/viufUb5I0/V5WENS3OYR8zRedqo6D+fUTdLHdc+EFyCkiQhBxIzgngPdPdfp1PIS7BdhhzrsZHbRqb7o4k3Dxc+AAnFauu4V6Zdwczo=
	
	
	private String trade_no;//	String	必填	64	支付宝交易号	2013112011001004330000121536
	
	private String out_trade_no;//	String	必填	64	商家订单号	6823789339978248
	
	private String open_id;//	String	选填	32	买家支付宝用户号，该字段将废弃，不要使用	2088102122524333
	
	private String buyer_logon_id;//	String	必填	100	买家支付宝账号	159****5620
	
	private String trade_status;//	String	必填	32	交易状态：WAIT_BUYER_PAY（交易创建，等待买家付款）、TRADE_CLOSED（未付款交易超时关闭，或支付完成后全额退款）、TRADE_SUCCESS（交易支付成功）、TRADE_FINISHED（交易结束，不可退款）	TRADE_CLOSED
	
	private BigDecimal total_amount;//	Price	必填	11	交易的订单金额，单位为元，两位小数。该参数的值为支付时传入的total_amount	88.88
	
	private String receipt_amount;//	String	必填	11	实收金额，单位为元，两位小数。该金额为本笔交易，商户账户能够实际收到的金额	15.25
	
	private BigDecimal buyer_pay_amount;//	Price	选填	11	买家实付金额，单位为元，两位小数。该金额代表该笔交易买家实际支付的金额，不包含商户折扣等金额	8.88
	
	private BigDecimal point_amount;//	Price	选填	11	积分支付的金额，单位为元，两位小数。该金额代表该笔交易中用户使用积分支付的金额，比如集分宝或者支付宝实时优惠等	10
	
	private BigDecimal invoice_amount;//	Price	选填	11	交易中用户支付的可开具发票的金额，单位为元，两位小数。该金额代表该笔交易中可以给用户开具发票的金额	12.11
	
	private Date send_pay_date;//	Date	必填	32	本次交易打款给卖家的时间	2014-11-27 15:45:57
	
	private String alipay_store_id;//	String	选填	64	支付宝店铺编号	2015040900077001000100001232
	
	private String store_id;//	String	选填	32	商户门店编号	NJ_S_001
	
	private String terminal_id;//	String	选填	32	商户机具终端编号	NJ_T_001
	
	private List<AlipayTradeFundBill> fund_bill_list;//	TradeFundBill []	必填	-	交易支付使用的资金渠道	
	
	private String store_name;//	String	选填	512	请求交易支付中的商户店铺的名称	证大五道口店
	
	private String buyer_user_id;//	String	必填	16	买家在支付宝的用户id	2088101117955611
	
	private String discount_goods_detail;//	String	必填	-	本次交易支付所使用的单品券优惠的商品优惠信息	[{"goods_id":"STANDARD1026181538","goods_name":"雪碧","discount_amount":"100.00","voucher_id":"2015102600073002039000002D5O"}]
	
	private String industry_sepc_detail;//	String	选填	4096	行业特殊信息（例如在医保卡支付业务中，向用户返回医疗信息）。	{"registration_order_pay":{"brlx":"1","cblx":"1"}}
	
	private AlipayVoucherDetail voucher_detail_list;//	VoucherDetail []	选填	-	本交易支付时使用的所有优惠券信息

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

	public String getOpen_id() {
		return open_id;
	}

	public void setOpen_id(String open_id) {
		this.open_id = open_id;
	}

	public String getBuyer_logon_id() {
		return buyer_logon_id;
	}

	public void setBuyer_logon_id(String buyer_logon_id) {
		this.buyer_logon_id = buyer_logon_id;
	}

	public String getTrade_status() {
		return trade_status;
	}

	public void setTrade_status(String trade_status) {
		this.trade_status = trade_status;
	}

	public BigDecimal getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(BigDecimal total_amount) {
		this.total_amount = total_amount;
	}

	public String getReceipt_amount() {
		return receipt_amount;
	}

	public void setReceipt_amount(String receipt_amount) {
		this.receipt_amount = receipt_amount;
	}

	public BigDecimal getBuyer_pay_amount() {
		return buyer_pay_amount;
	}

	public void setBuyer_pay_amount(BigDecimal buyer_pay_amount) {
		this.buyer_pay_amount = buyer_pay_amount;
	}

	public BigDecimal getPoint_amount() {
		return point_amount;
	}

	public void setPoint_amount(BigDecimal point_amount) {
		this.point_amount = point_amount;
	}

	public BigDecimal getInvoice_amount() {
		return invoice_amount;
	}

	public void setInvoice_amount(BigDecimal invoice_amount) {
		this.invoice_amount = invoice_amount;
	}

	public Date getSend_pay_date() {
		return send_pay_date;
	}

	public void setSend_pay_date(Date send_pay_date) {
		this.send_pay_date = send_pay_date;
	}

	public String getAlipay_store_id() {
		return alipay_store_id;
	}

	public void setAlipay_store_id(String alipay_store_id) {
		this.alipay_store_id = alipay_store_id;
	}

	public String getStore_id() {
		return store_id;
	}

	public void setStore_id(String store_id) {
		this.store_id = store_id;
	}

	public String getTerminal_id() {
		return terminal_id;
	}

	public void setTerminal_id(String terminal_id) {
		this.terminal_id = terminal_id;
	}

	public List<AlipayTradeFundBill> getFund_bill_list() {
		return fund_bill_list;
	}

	public void setFund_bill_list(List<AlipayTradeFundBill> fund_bill_list) {
		this.fund_bill_list = fund_bill_list;
	}

	public String getStore_name() {
		return store_name;
	}

	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}

	public String getBuyer_user_id() {
		return buyer_user_id;
	}

	public void setBuyer_user_id(String buyer_user_id) {
		this.buyer_user_id = buyer_user_id;
	}

	public String getDiscount_goods_detail() {
		return discount_goods_detail;
	}

	public void setDiscount_goods_detail(String discount_goods_detail) {
		this.discount_goods_detail = discount_goods_detail;
	}

	public String getIndustry_sepc_detail() {
		return industry_sepc_detail;
	}

	public void setIndustry_sepc_detail(String industry_sepc_detail) {
		this.industry_sepc_detail = industry_sepc_detail;
	}

	public AlipayVoucherDetail getVoucher_detail_list() {
		return voucher_detail_list;
	}

	public void setVoucher_detail_list(AlipayVoucherDetail voucher_detail_list) {
		this.voucher_detail_list = voucher_detail_list;
	}
	
	
}
