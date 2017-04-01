package com.haoyisheng.pay.alipay.data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class AlipayPlaceOrderReqData implements Serializable {
	
		
	    /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		
		//	String	必须	64	商户订单号,64个字符以内、只能包含字母、数字、下划线；需保证在商户端不重复	20150320010101001
		private String out_trade_no;
		//	String	可选	28	卖家支付宝用户ID。 如果该值为空，则默认为商户签约账号对应的支付宝用户ID	2088102146225135
		private String seller_id;
		//	Price	必须	11	订单总金额，单位为元，精确到小数点后两位，取值范围[0.01,100000000] 如果同时传入了【打折金额】，【不可打折金额】，【订单总金额】三者，则必须满足如下条件：【订单总金额】=【打折金额】+【不可打折金额】	88.88
		private BigDecimal total_amount;
		//  Price   可选	11	可打折金额. 参与优惠计算的金额，单位为元，精确到小数点后两位，取值范围[0.01,100000000] 如果该值未传入，但传入了【订单总金额】，【不可打折金额】则该值默认为【订单总金额】-【不可打折金额】	8.88
		private BigDecimal discountable_amount;		
		//	Price	可选	11	不可打折金额. 不参与优惠计算的金额，单位为元，精确到小数点后两位，取值范围[0.01,100000000] 如果该值未传入，但传入了【订单总金额】,【打折金额】，则该值默认为【订单总金额】-【打折金额】	80
		private BigDecimal undiscountable_amount;
		//	String	可选	100	买家支付宝账号	15901825620
		private String buyer_logon_id;
		//	String	必须	256	订单标题	Iphone6 16G
		private String subject;
		//	String	可选	128	对交易或商品的描述	Iphone6 16G
		private String body;
		//	GoodsDetail []	可选	-	订单包含的商品列表信息.Json格式. 其它说明详见：“商品明细说明”	
		private List<AlipayGoodsDetail> goods_detail;
		//	String	可选	28	商户操作员编号	yx_001
		private String operator_id;
		//  String	可选	32	商户门店编号	NJ_001
		private String store_id;
		//	String	可选	32	商户机具终端编号	NJ_T_001
		private String terminal_id;
		//	ExtendParams	可选	-	业务扩展参数
		private AlipayExtendParams extend_params;	
		//  String	可选	6	该笔订单允许的最晚付款时间，逾期将关闭交易。取值范围：1m～15d。m-分钟，h-小时，d-天，1c-当天（1c-当天的情况下，无论交易何时创建，都在0点关闭）。 该参数数值不接受小数点， 如 1.5h，可转换为 90m。	90m
		private String timeout_express;	
		//	RoyaltyInfo	可选	-	描述分账信息，json格式。
		private AlipayRoyaltyInfo royalty_info;	
		// 	SubMerchant	可选	-	二级商户信息,当前只对特殊银行机构特定场景下使用此字段	
		private AlipaySubMerchant sub_merchant;
		//	String	可选	32	支付宝店铺的门店ID	2016052600077000000015640104
		private String alipay_store_id;
		
		public String getOut_trade_no() {
			return out_trade_no;
		}
		public void setOut_trade_no(String out_trade_no) {
			this.out_trade_no = out_trade_no;
		}
		public String getSeller_id() {
			return seller_id;
		}
		public void setSeller_id(String seller_id) {
			this.seller_id = seller_id;
		}
		public BigDecimal getTotal_amount() {
			return total_amount;
		}
		public void setTotal_amount(BigDecimal total_amount) {
			this.total_amount = total_amount;
		}
		public BigDecimal getDiscountable_amount() {
			return discountable_amount;
		}
		public void setDiscountable_amount(BigDecimal discountable_amount) {
			this.discountable_amount = discountable_amount;
		}
		public BigDecimal getUndiscountable_amount() {
			return undiscountable_amount;
		}
		public void setUndiscountable_amount(BigDecimal undiscountable_amount) {
			this.undiscountable_amount = undiscountable_amount;
		}
		public String getBuyer_logon_id() {
			return buyer_logon_id;
		}
		public void setBuyer_logon_id(String buyer_logon_id) {
			this.buyer_logon_id = buyer_logon_id;
		}
		public String getSubject() {
			return subject;
		}
		public void setSubject(String subject) {
			this.subject = subject;
		}
		public String getBody() {
			return body;
		}
		public void setBody(String body) {
			this.body = body;
		}
		public List<AlipayGoodsDetail> getGoods_detail() {
			return goods_detail;
		}
		public void setGoods_detail(List<AlipayGoodsDetail> goods_detail) {
			this.goods_detail = goods_detail;
		}
		public String getOperator_id() {
			return operator_id;
		}
		public void setOperator_id(String operator_id) {
			this.operator_id = operator_id;
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
		public AlipayExtendParams getExtend_params() {
			return extend_params;
		}
		public void setExtend_params(AlipayExtendParams extend_params) {
			this.extend_params = extend_params;
		}
		public String getTimeout_express() {
			return timeout_express;
		}
		public void setTimeout_express(String timeout_express) {
			this.timeout_express = timeout_express;
		}
		public AlipayRoyaltyInfo getRoyalty_info() {
			return royalty_info;
		}
		public void setRoyalty_info(AlipayRoyaltyInfo royalty_info) {
			this.royalty_info = royalty_info;
		}
		public AlipaySubMerchant getSub_merchant() {
			return sub_merchant;
		}
		public void setSub_merchant(AlipaySubMerchant sub_merchant) {
			this.sub_merchant = sub_merchant;
		}
		public String getAlipay_store_id() {
			return alipay_store_id;
		}
		public void setAlipay_store_id(String alipay_store_id) {
			this.alipay_store_id = alipay_store_id;
		}
		
		
		
}
