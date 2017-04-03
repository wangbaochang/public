package com.haoyisheng.pay;


import java.math.BigDecimal;

import org.apache.log4j.Logger;

import com.haoyisheng.pay.alipay.AlipayPay;
import com.haoyisheng.pay.common.QRCodeUtil;
import com.haoyisheng.pay.weixin.WeixinPay;
import com.haoyisheng.pay.weixin.common.WeixinUtil;

/**
 * 
 * @author wangbaochang
 *
 */
public class PayFactory {
	
	static Logger logger = Logger.getLogger(AlipayPay.class);
	
	private static Pay wiexinPay;
	
	private static Pay alipayPay;
	
	public static Pay getPay(PayType type){
		if( type == PayType.weixin){
			if( wiexinPay == null ){
				wiexinPay=new WeixinPay();
			}
			return wiexinPay;
		}
		else if( type == PayType.alipay ){
			if(alipayPay==null){
				alipayPay=new AlipayPay();
			}
			return alipayPay;
		}
		else{
			return null;
		}
	}
	
	public static void main(String[] args){
		Order order=new Order(WeixinUtil.getRandomStringByLength(10),"测试定单",new BigDecimal(0.01),"127.0.0.1");
		Pay pay=PayFactory.getPay(PayType.alipay);
		//Pay pay=PayFactory.getPay(PayType.weixin);
		String s=pay.placeOrder(order);
        logger.debug("支付二维码Base64String:"+QRCodeUtil.getQRCodeImageBase64String(s));
        logger.debug("订单状态:"+pay.queryOrder(order.getOrderNumber()).getExplanation());
        //logger.debug("关闭订单："+pay.closeOrder(order.getOrderNumber()));
	}
}
