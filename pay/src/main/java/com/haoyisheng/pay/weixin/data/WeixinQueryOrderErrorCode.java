package com.haoyisheng.pay.weixin.data;

public enum WeixinQueryOrderErrorCode {
	
	
	ORDERNOTEXIST("交易订单号不存在	查询系统中不存在此交易订单号	该API只能查提交支付交易返回成功的订单，请商户检查需要查询的订单号是否正确","ORDERNOTEXIST"),
	SYSTEMERROR("系统错误	后台系统返回错误	系统异常，请再调用发起查询","SYSTEMERROR");
	
    private String explanation;
	
	private String code;
	
	WeixinQueryOrderErrorCode(String explanation,String code){
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
