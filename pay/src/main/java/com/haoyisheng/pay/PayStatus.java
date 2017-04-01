package com.haoyisheng.pay;

/**
 * 支付状态
 * @author wangbaochang
 *
 */
public enum PayStatus {

	NULL("无效状态","NULL"),
	NOTPAY("未支付","NOTPAY"),
	USERPAYING("用户支付中","USERPAYING"),
	SUCCESS("支付成功","SUCCESS"),
	PAYERROR("支付失败","PAYERROR"),
	REFUND("转入退款","REFUND"),
	REVOKED("已撤销（刷卡支付）","REVOKED"),
	CLOSED("已关闭","CLOSED");
	
	private String explanation;
	
	private String code;
	
	PayStatus(String explanation, String code){
		this.explanation=explanation;
		this.code=code;
	}

	public String getExplanation() {
		return explanation;
	}


	public String getCode() {
		return code;
	}

	
	
}
