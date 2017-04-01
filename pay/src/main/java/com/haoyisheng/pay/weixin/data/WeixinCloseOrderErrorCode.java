package com.haoyisheng.pay.weixin.data;

public enum WeixinCloseOrderErrorCode {
	
	ORDERPAID("订单已支付	订单已支付，不能发起关单	订单已支付，不能发起关单，请当作已支付的正常交易","ORDERPAID"),
	SYSTEMERROR("系统错误	系统错误	系统异常，请重新调用该API","SYSTEMERROR"),
	ORDERCLOSED("订单已关闭	订单已关闭，无法重复关闭	订单已关闭，无需继续调用","ORDERCLOSED"),
	SIGNERROR("签名错误	参数签名结果不正确	请检查签名参数和方法是否都符合签名算法要求","SIGNERROR"),
	REQUIRE_POST_METHOD("请使用post方法	未使用post传递参数 	请检查请求参数是否通过post方法提交","REQUIRE_POST_METHOD"),
	XML_FORMAT_ERROR("XML格式错误	XML格式错误	请检查XML参数格式是否正确","XML_FORMAT_ERROR");
	
    private String explanation;
	
	private String code;
	
	WeixinCloseOrderErrorCode(String explanation,String code){
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
