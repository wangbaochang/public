package com.haoyisheng.pay.weixin;


import java.math.BigDecimal;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.haoyisheng.pay.Order;
import com.haoyisheng.pay.Pay;
import com.haoyisheng.pay.PayStatus;
import com.haoyisheng.pay.alipay.AlipayPay;
import com.haoyisheng.pay.common.BeanUtil;
import com.haoyisheng.pay.common.HttpUtils;
import com.haoyisheng.pay.weixin.common.WeixinUtil;
import com.haoyisheng.pay.weixin.data.WeixinCallBackData;
import com.haoyisheng.pay.weixin.data.WeixinCloseOrderReqData;
import com.haoyisheng.pay.weixin.data.WeixinCloseOrderResData;
import com.haoyisheng.pay.weixin.data.WeixinConfig;
import com.haoyisheng.pay.weixin.data.WeixinPlaceOrderReqData;
import com.haoyisheng.pay.weixin.data.WeixinPlaceOrderResData;
import com.haoyisheng.pay.weixin.data.WeixinQueryOrderReqData;
import com.haoyisheng.pay.weixin.data.WeixinQueryOrderResData;

/**
 * 微信支付实现
 * @author wangbaochang
 *
 */
public class WeixinPay implements Pay {
	
	static Logger logger = Logger.getLogger(AlipayPay.class);
	WeixinConfig config =new WeixinConfig();

	public String placeOrder(Order order) {

		
		WeixinPlaceOrderReqData wpop=new WeixinPlaceOrderReqData();
		//设置 公众账号ID
		wpop.setAppid(config.getAppid());
		//设置商户号
		wpop.setMch_id(config.getMch_id());
		//设置设备号	
		wpop.setDevice_info("WEB");
		//设置随机字符串
		wpop.setNonce_str(WeixinUtil.getRandomStringByLength(20));
		//设置签名类型 不设置默认MD5
		//wpop.setSign_type("MD5");
		//设置品描述
		wpop.setBody(order.getOrderDescription());
		//设置商品详情
		//wpop.setDetail("");
		//设置附加数据
		//wpop.setAttach("");
		//设置商户订单号
		wpop.setOut_trade_no(order.getOrderNumber());
		//设置标价币种
		//wpop.setFee_type("");
		//设置标价金额
		wpop.setTotal_fee(order.getOrderFeeOfCent());
		//设置终端IP
		wpop.setSpbill_create_ip(order .getSpbillCreateIP());
		//设置交易起始时间
		//wpop.setTime_start(time_start);
		//设置交易结束时间
		//wpop.setTime_expire(time_expire);
		//设置商品标记
		//wpop.setGoods_tag(goods_tag);
		//设置通知地址
		wpop.setNotify_url(config.getNotify_url());
		//设置交易类型
		wpop.setTrade_type("NATIVE");
		//设置商品ID
		//wpop.setProduct_id(product_id);
		//设置指定支付方式
		//wpop.setLimit_pay(limit_pay);
		//设置用户标识
		//wpop.setOpenid(openid);

		//设置签名
		try{
			wpop.setSign(WeixinUtil.getSign(wpop,config.getKey()));
		}
		catch(Exception e){
			return "";
		}
		
		String req=BeanUtil.beanToXml(wpop);
		String res=HttpUtils.sendPostRequest(config.getPlaceOrderUrl(), req);
		WeixinPlaceOrderResData resData=null;
		try{
			 resData= (WeixinPlaceOrderResData)BeanUtil.xmlToBean(res, WeixinPlaceOrderResData.class);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return resData!=null ? resData.getCode_url():"";
	}

	public PayStatus queryOrder(String orderId) {
		WeixinQueryOrderReqData wqop=new WeixinQueryOrderReqData();
		//设置 公众账号ID
		wqop.setAppid(config.getAppid());
		//设置商户号
		wqop.setMch_id(config.getMch_id());
		//设置微信订单号
		//wqop.setTransaction_id("");
		//设置商户订单号
		wqop.setOut_trade_no(orderId);
		//设置随机字符串
		wqop.setNonce_str(WeixinUtil.getRandomStringByLength(20));
		//设置签名类型 不设置默认MD5
		//wpop.setSign_type("MD5");
		//设置签名
		try{
			wqop.setSign(WeixinUtil.getSign(wqop,config.getKey()));

		}
		catch(Exception e){
			return PayStatus.NULL;
		}
		
		String req=BeanUtil.beanToXml(wqop);
		String res=HttpUtils.sendPostRequest(config.getQueryOrderUrl(), req);
		WeixinQueryOrderResData resData=null;
		try{
			resData= (WeixinQueryOrderResData)BeanUtil.xmlToBean(res, WeixinQueryOrderResData.class);

		}
		catch(Exception e){
			e.printStackTrace();
		}
		if(resData!=null && resData.getReturn_code().equals("SUCCESS") && resData.getResult_code().equals("SUCCESS")){
			if(resData.getTrade_state().equals("SUCCESS")){
				return PayStatus.SUCCESS;
			}
			else if(resData.getTrade_state().equals("REFUND")){
				return PayStatus.REFUND;
			}
			else if(resData.getTrade_state().equals("NOTPAY")){
				return PayStatus.NOTPAY;
			}
			else if(resData.getTrade_state().equals("CLOSED")){
				return PayStatus.CLOSED;
			}
			else if(resData.getTrade_state().equals("REVOKED")){
				return PayStatus.REVOKED;
			}
			else if(resData.getTrade_state().equals("USERPAYING")){
				return PayStatus.USERPAYING;
			}
			else if(resData.getTrade_state().equals("PAYERROR")){
				return PayStatus.PAYERROR;
			}
			else{
				return PayStatus.NULL;
			}
		}
		else{
			return PayStatus.NULL;
		}
	}

	public Boolean canelOrder(String orderId) {
		return null;
	}

	public Boolean closeOrder(String orderId) {
		WeixinCloseOrderReqData wcop=new WeixinCloseOrderReqData();
		//设置 公众账号ID
		wcop.setAppid(config.getAppid());
		//设置商户号
		wcop.setMch_id(config.getMch_id());
		//设置商户订单号
		wcop.setOut_trade_no(orderId);
		//设置随机字符串
		wcop.setNonce_str(WeixinUtil.getRandomStringByLength(20));
		//设置签名类型 不设置默认MD5
		//wcop.setSign_type("MD5");
		//设置签名
		try{
			wcop.setSign(WeixinUtil.getSign(wcop,config.getKey()));

		}
		catch(Exception e){
			return false;
		}
		
		String req=BeanUtil.beanToXml(wcop);
		String res=HttpUtils.sendPostRequest(config.getCloseOrderUrl(), req);
		WeixinCloseOrderResData resData=null;
		try{
			 resData= (WeixinCloseOrderResData)BeanUtil.xmlToBean(res, WeixinCloseOrderResData.class);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		if(resData!=null && resData.getReturn_code().equals("SUCCESS") && resData.getResult_code().equals("SUCCESS")){
			return true;
		}
		else{
			return false;
		}
	}

	public String refundOrder(String orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	public String refundQuery(String orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	public Order GetCallbackOrderInfo(HttpServletRequest request) {
		String resString = "";
		try {
			while ((resString = request.getReader().readLine()) != null) {
				resString += resString;
			}
			request.getReader().close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		WeixinCallBackData cbData=null;
		try{
			cbData= (WeixinCallBackData)BeanUtil.xmlToBean(resString, WeixinCallBackData.class);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		Order order=null;
		try{
			if(WeixinUtil.checkIsSignValidFromResponseString(resString,config.getKey())){
				if(cbData!=null && cbData.getReturn_code().equals("SUCCESS")){
					order=new Order(cbData.getOut_trade_no(),null,new BigDecimal(cbData.getTotal_fee()!=null ?cbData.getTotal_fee():"0"),null);
					if(cbData.getTrade_type().equals("SUCCESS")){
						order.setStatus(PayStatus.SUCCESS);
					}
					else{
						order.setStatus(PayStatus.PAYERROR);
					}
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return order;
	}

	public void writeResposeInfo(HttpServletResponse respose, Boolean status) {
		String res="";
		if(status){
			res="<xml><return_code>SUCCESS</return_code></xml>";
		}
		else{
			res="<xml><return_code>FAIL</return_code><return_msg>OK</return_msg></xml>";
		}
		ServletOutputStream out=null;
		try{
			out=respose.getOutputStream();
			out.write(res.getBytes("utf-8"));

		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			if(out!=null){
				try{
					out.close();
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		}
	}

}
