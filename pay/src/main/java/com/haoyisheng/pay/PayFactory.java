package com.haoyisheng.pay;


import java.math.BigDecimal;
import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;

import com.haoyisheng.pay.alipay.AlipayPay;
import com.haoyisheng.pay.alipay.data.AlipayOrderResData;
import com.haoyisheng.pay.common.BeanUtil;
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
		AlipayOrderResData r=BeanUtil.jsonToBen("{\"alipay_trade_query_response\":{\"code\":\"10000\",\"msg\":\"Success\",\"buyer_logon_id\":\"185****1816\",\"buyer_pay_amount\":\"0.01\",\"buyer_user_id\":\"2088702689403135\",\"fund_bill_list\":[{\"amount\":\"0.01\",\"fund_channel\":\"ALIPAYACCOUNT\"}],\"invoice_amount\":\"0.01\",\"open_id\":\"20881045655496582446829251317813\",\"out_trade_no\":\"HB325110O1932CC10108762\",\"point_amount\":\"0.00\",\"receipt_amount\":\"0.01\",\"send_pay_date\":\"2017-04-01 13:37:55\",\"total_amount\":\"0.01\",\"trade_no\":\"2017040121001004130248835006\",\"trade_status\":\"TRADE_SUCCESS\"},\"sign\":\"jgFs0QkJKWC/MHrJ6lUDxXncgMnVOFPWtOIYRhm1aTvWTRJv6VPy8630Q6fU32PykAgqzcqxuiazciWSZ0xM2fXGHfrB+qPER1mmvUyoXjJSJY2SahcLfWs+3B2VweMnkfSnqRT9FTAUI3lvEvR3uLP+DKdkVnTMdtoJp6z1YtnO+sZYxEifTfwc2hJsPoA7uC7A20Tn+zGOafw+YBKfYEb1G0iLBRsukaTEIIwddWLfz+sv4uSyGFU5lrOJJB6lJvdV/lKqeY5ZyeTOhbMYc4WvN1ZblCQ7r9KB5WuR4EXIjHqjNp5zbUqTNhncqd9W4fF0CdWIuYTrbxblcTqdNQ==\"}", 
				AlipayOrderResData.class,new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
		
		Order order=new Order(WeixinUtil.getRandomStringByLength(10),"测试定单",new BigDecimal(0.01),"127.0.0.1");
		Pay pay=PayFactory.getPay(PayType.alipay);
		//Pay pay=PayFactory.getPay(PayType.weixin);
		String s=pay.placeOrder(order);
        logger.debug("支付二维码Base64String:"+QRCodeUtil.getQRCodeImageBase64String(s));
        logger.debug("订单状态:"+pay.queryOrder(order.getOrderNumber()).getExplanation());
        //logger.debug("关闭订单："+pay.closeOrder(order.getOrderNumber()));
		
        
		
	}
}
