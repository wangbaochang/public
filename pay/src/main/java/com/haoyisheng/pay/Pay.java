package com.haoyisheng.pay;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 支付接口
 * @author wangbaochang
 *
 */
public interface Pay {
	
	
	/**
	 * 下单返回支付二维码
	 * @return 二维码Url
	 */
	public String placeOrder(Order order);
	
	
	/**
	 * 查询定单
	 * @return
	 */
	public PayStatus queryOrder(String orderId);
	
	/**
	 * 取消定单
	 * @param orderId
	 * @return
	 */
	public Boolean canelOrder(String orderId);
	
	/**
	 * 关闭定单
	 * @param orderId
	 * @return
	 */
	public Boolean closeOrder(String orderId);
	
	/**
	 * 定单退款
	 * @param orderId
	 * @return
	 */
	public String refundOrder(String orderId);
	
	
	/**
	 * 定单退款查询
	 * @param orderId
	 * @return
	 */
	public String refundQuery(String orderId);
	
	
	/**
	 * 从回调中取得回调结果  如果交易成功返回定单信息，其返回null 
	 * @param request
	 * @param respose
	 * @return
	 */
	public Order GetCallbackOrderInfo(HttpServletRequest request);
	
	/**
	 * 响应回调结果  
	 * @param respose  
	 * @param status 
	 * @param order
	 */
	public void  writeResposeInfo(HttpServletResponse respose,Boolean status);
	
	

}
