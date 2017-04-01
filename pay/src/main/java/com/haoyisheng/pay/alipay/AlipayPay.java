package com.haoyisheng.pay.alipay;


import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradeCloseRequest;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.response.AlipayTradeCloseResponse;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.haoyisheng.pay.Order;
import com.haoyisheng.pay.Pay;
import com.haoyisheng.pay.PayStatus;
import com.haoyisheng.pay.alipay.data.AlipayCloseOrderReqData;
import com.haoyisheng.pay.alipay.data.AlipayConfig;
import com.haoyisheng.pay.alipay.data.AlipayOrderResData;
import com.haoyisheng.pay.alipay.data.AlipayPlaceOrderReqData;
import com.haoyisheng.pay.alipay.data.AlipayQueryOrderReqData;
import com.haoyisheng.pay.common.BeanUtil;
import com.haoyisheng.pay.common.MD5;
import com.haoyisheng.pay.common.RSACryption;

/**
 * 
 * @author wangbaochang
 *
 */
public class AlipayPay implements Pay{
	
	static Logger logger = Logger.getLogger(AlipayPay.class);
	

	AlipayConfig config=new AlipayConfig();

	public String placeOrder(Order order) {
		String url="";
		AlipayPlaceOrderReqData apord=new AlipayPlaceOrderReqData();
		//设置商户订单号,64个字符以内、只能包含字母、数字、下划线；需保证在商户端不重复	20150320010101001
		apord.setOut_trade_no(order.getOrderNumber());
		//设置卖家支付宝用户ID。 如果该值为空，则默认为商户签约账号对应的支付宝用户ID	2088102146225135
		//apord.setSeller_id("");
		//设置订单总金额，单位为元，精确到小数点后两位，取值范围[0.01,100000000] 如果同时传入了【打折金额】，【不可打折金额】，【订单总金额】三者，则必须满足如下条件：【订单总金额】=【打折金额】+【不可打折金额】	88.88
		apord.setTotal_amount(order.getOrderFee());
		//设置可打折金额. 参与优惠计算的金额，单位为元，精确到小数点后两位，取值范围[0.01,100000000] 如果该值未传入，但传入了【订单总金额】，【不可打折金额】则该值默认为【订单总金额】-【不可打折金额】	8.88
		//apord.setDiscountable_amount("");
		//设置不可打折金额. 不参与优惠计算的金额，单位为元，精确到小数点后两位，取值范围[0.01,100000000] 如果该值未传入，但传入了【订单总金额】,【打折金额】，则该值默认为【订单总金额】-【打折金额】	80
		//apord.setUndiscountable_amount("");
		//设置买家支付宝账号	15901825620
		//apord.setBuyer_logon_id("");
		//设置订单标题	Iphone6 16G
		apord.setSubject(order.getOrderDescription());
		//设置对交易或商品的描述	Iphone6 16G
		//apord.setBody("");
		//设置订单包含的商品列表信息.Json格式. 其它说明详见：“商品明细说明”	
		//apord.setGoods_detail(null);
		//设置商户操作员编号	yx_001
		//apord.setOperator_id(null);
		//设置商户门店编号	NJ_001
		//apord.setStore_id(null);
		//设置商户机具终端编号	NJ_T_001
		//apord.setTerminal_id(null);
		//设置业务扩展参数
		//apord.setExtend_params(null);
		//设置该笔订单允许的最晚付款时间，逾期将关闭交易。取值范围：1m～15d。m-分钟，h-小时，d-天，1c-当天（1c-当天的情况下，无论交易何时创建，都在0点关闭）。 该参数数值不接受小数点， 如 1.5h，可转换为 90m。	90m
		//apord.setTimeout_express(null);
		//设置描述分账信息，json格式。
		//apord.setRoyalty_info(null);
		//设置二级商户信息,当前只对特殊银行机构特定场景下使用此字段	
		//apord.setSub_merchant(null);
		//设置支付宝店铺的门店ID	2016052600077000000015640104
		//apord.setAlipay_store_id(null);
		
		String biz_content=BeanUtil.beanToJson(apord);
		
		AlipayClient alipayClient = new DefaultAlipayClient(config.getOrderUrl(),
				 config.getAppid(), config.getAppPrivateKey(), "json", "utf-8", config.getAlipayPublicKey(), "RSA2"); //获得初始化的AlipayClient
		AlipayTradePrecreateRequest request = new AlipayTradePrecreateRequest(); 
		request.setBizContent(biz_content); //设置业务参数
		try{
			AlipayTradePrecreateResponse  response = alipayClient.execute(request); 
			AlipayOrderResData rs=BeanUtil.jsonToBen(response.getBody(), AlipayOrderResData.class);
			if(rs.getAlipay_trade_precreate_response().getCode().equals("10000")){
				url=rs.getAlipay_trade_precreate_response().getQr_code();
				//order.setPayOrderNumber(rs.getAlipay_trade_precreate_response().get);
			}
			else{
				logger.debug(rs.getAlipay_trade_precreate_response().getSub_msg());
			}
		}
		catch(AlipayApiException e){
			e.printStackTrace();
		}
		
		// 根据response中的结果继续业务逻辑处理
		return url;
	}

	public PayStatus queryOrder(String orderId) {
		PayStatus status=PayStatus.NULL;
		AlipayQueryOrderReqData aqord=new AlipayQueryOrderReqData();
		//设置商户订单号,64个字符以内、只能包含字母、数字、下划线；需保证在商户端不重复	20150320010101001
		aqord.setOut_trade_no(orderId);
		
		String biz_content=BeanUtil.beanToJson(aqord);
		
		AlipayClient alipayClient = new DefaultAlipayClient(config.getOrderUrl(),
				 config.getAppid(), config.getAppPrivateKey(), "json", "utf-8", config.getAlipayPublicKey(), "RSA2"); //获得初始化的AlipayClient
		AlipayTradeQueryRequest request = new AlipayTradeQueryRequest(); 
		request.setBizContent(biz_content); //设置业务参数
		try{
			AlipayTradeQueryResponse  response = alipayClient.execute(request); 
			AlipayOrderResData rs=BeanUtil.jsonToBen(response.getBody(), AlipayOrderResData.class,new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
			if(rs.getAlipay_trade_query_response()!=null && rs.getAlipay_trade_query_response().getCode().equals("10000")){
				String tradeStatus=rs.getAlipay_trade_query_response().getTrade_status();
				if(tradeStatus.equals("WAIT_BUYER_PAY")){
					status=PayStatus.NOTPAY;
				}
				else if(tradeStatus.equals("TRADE_CLOSED")){
					status=PayStatus.NOTPAY;
				}
				else if(tradeStatus.equals("TRADE_SUCCESS")){
					status=PayStatus.SUCCESS;
				}
				else if(tradeStatus.equals("TRADE_FINISHED")){
					status=PayStatus.SUCCESS;
				}
				else{
					status=PayStatus.NULL;
				}
				
			}
			else{
				logger.debug(rs.getAlipay_trade_query_response().getSub_msg());
			}
		}
		catch(AlipayApiException e){
			e.printStackTrace();
		}
		
		// 根据response中的结果继续业务逻辑处理
		return status;
	}

	public Boolean canelOrder(String orderId) {
		return null;
	}

	public Boolean closeOrder(String orderId) {
		Boolean b=false;
		AlipayCloseOrderReqData acord=new AlipayCloseOrderReqData();
		//设置商户订单号,64个字符以内、只能包含字母、数字、下划线；需保证在商户端不重复	20150320010101001
		acord.setOut_trade_no(orderId);
		
		String biz_content=BeanUtil.beanToJson(acord);
		
		AlipayClient alipayClient = new DefaultAlipayClient(config.getOrderUrl(),
				 config.getAppid(), config.getAppPrivateKey(), "json", "utf-8", config.getAlipayPublicKey(), "RSA2"); //获得初始化的AlipayClient
		AlipayTradeCloseRequest request = new AlipayTradeCloseRequest(); 
		request.setBizContent(biz_content); //设置业务参数
		try{
			AlipayTradeCloseResponse  response = alipayClient.execute(request); 
			AlipayOrderResData rs=BeanUtil.jsonToBen(response.getBody(), AlipayOrderResData.class);
			if(rs.getAlipay_trade_close_response()!=null && rs.getAlipay_trade_close_response().getCode().equals("10000")){
				b=true;
			}
			else{
				System.out.println(rs.getAlipay_trade_close_response().getSub_msg());
			}
		}
		catch(AlipayApiException e){
			e.printStackTrace();
		}
		
		// 根据response中的结果继续业务逻辑处理
		return b;
	}

	public String refundOrder(String orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	public String refundQuery(String orderId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	//https://api.xx.com/receive_notify.htm?gmt_payment=2015-06-11 22:33:59&notify_id=42af7baacd1d3746cf7b56752b91edcj34&seller_email=testyufabu07@alipay.com&notify_type=trade_status_sync&sign=kPbQIjX+xQc8F0/A6/AocELIjhhZnGbcBN6G4MM/HmfWL4ZiHM6fWl5NQhzXJusaklZ1LFuMo+lHQUELAYeugH8LYFvxnNajOvZhuxNFbN2LhF0l/KL8ANtj8oyPM4NN7Qft2kWJTDJUpQOzCzNnV9hDxh5AaT9FPqRS6ZKxnzM=&trade_no=2015061121001004400068549373&out_trade_no=21repl2ac2eOutTradeNo322&gmt_create=2015-06-11 22:33:46&seller_id=2088211521646673&notify_time=2015-06-11 22:34:03&subject=FACE_TO_FACE_PAYMENT_PRECREATE中文&trade_status=TRADE_SUCCESS&sign_type=RSA2
		//
	public Order GetCallbackOrderInfo(HttpServletRequest request) {
			// TODO Auto-generated method stub
			Map<String,Object> map=new HashMap<String,Object>();
			map.put("notify_time", request.getParameter("notify_time"));//	通知时间	Date	是	通知的发送时间。格式为yyyy-MM-dd HH:mm:ss	2015-14-27 15:45:58
			map.put("notify_type", request.getParameter("notify_type"));//	通知类型	String(64)	是	通知的类型	trade_status_sync
			map.put("notify_id", request.getParameter("notify_id"));//	通知校验ID	String(128)	是	通知校验ID	ac05099524730693a8b330c5ecf72da9786
			
			map.put("trade_no", request.getParameter("trade_no"));//	支付宝交易号	String(64)	是	支付宝交易凭证号	2013112011001004330000121536
			map.put("app_id", request.getParameter("app_id"));//	开发者的app_id	String(32)	是	支付宝分配给开发者的应用Id	2014072300007148
			map.put("out_trade_no", request.getParameter("out_trade_no"));//	商户订单号	String(64)	是	原支付请求的商户订单号	6823789339978248
			map.put("out_biz_no", request.getParameter("out_biz_no"));//	商户业务号	String(64)	否	商户业务ID，主要是退款通知中返回退款申请的流水号	HZRF001
			map.put("buyer_id", request.getParameter("buyer_id"));//	买家支付宝用户号	String(16)	否	买家支付宝账号对应的支付宝唯一用户号。以2088开头的纯16位数字	2088102122524333
			map.put("buyer_logon_id", request.getParameter("buyer_logon_id"));//	买家支付宝账号	String(100)	否	买家支付宝账号	15901825620
			map.put("seller_id", request.getParameter("seller_id"));//	卖家支付宝用户号	String(30)	否	卖家支付宝用户号	2088101106499364
			map.put("seller_email", request.getParameter("seller_email"));//	卖家支付宝账号	String(100)	否	卖家支付宝账号	zhuzhanghu@alitest.com
			map.put("trade_status", request.getParameter("trade_status"));//	交易状态	String(32)	否	交易目前所处的状态	TRADE_CLOSED
			map.put("total_amount", request.getParameter("total_amount"));//	订单金额	Number(9,2)	否	本次交易支付的订单金额，单位为人民币（元）	20
			map.put("receipt_amount", request.getParameter("receipt_amount"));//	实收金额	Number(9,2)	否	商家在交易中实际收到的款项，单位为元	15
			map.put("invoice_amount", request.getParameter("invoice_amount"));//	开票金额	Number(9,2)	否	用户在交易中支付的可开发票的金额	10.00
			map.put("buyer_pay_amount", request.getParameter("buyer_pay_amount"));//	付款金额	Number(9,2)	否	用户在交易中支付的金额	13.88
			map.put("point_amount", request.getParameter("point_amount"));//	集分宝金额	Number(9,2)	否	使用集分宝支付的金额	12.00
			map.put("refund_fee", request.getParameter("refund_fee"));//	总退款金额	Number(9,2)	否	退款通知中，返回总退款金额，单位为元，支持两位小数	2.58
			map.put("send_back_fee", request.getParameter("send_back_fee"));//	实际退款金额	Number(9,2)	否	商户实际退款给用户的金额，单位为元，支持两位小数	2.08
			map.put("subject", request.getParameter("subject"));//	订单标题	String(256)	否	商品的标题/交易标题/订单标题/订单关键字等，是请求时对应的参数，原样通知回来	当面付交易
			map.put("body", request.getParameter("body"));//	商品描述	String(400)	否	该订单的备注、描述、明细等。对应请求时的body参数，原样通知回来	当面付交易内容
			map.put("gmt_create", request.getParameter("gmt_create"));//	交易创建时间	Date	否	该笔交易创建的时间。格式为yyyy-MM-dd HH:mm:ss	2015-04-27 15:45:57
			map.put("gmt_payment", request.getParameter("gmt_payment"));//	交易付款时间	Date	否	该笔交易的买家付款时间。格式为yyyy-MM-dd HH:mm:ss	2015-04-27 15:45:57
			map.put("gmt_refund", request.getParameter("gmt_refund"));//	交易退款时间	Date	否	该笔交易的退款时间。格式为yyyy-MM-dd HH:mm:ss.S	2015-04-28 15:45:57.320
			map.put("gmt_close", request.getParameter("gmt_close"));//	交易结束时间	Date	否	该笔交易结束时间。格式为yyyy-MM-dd HH:mm:ss	2015-04-29 15:45:57
			map.put("fund_bill_list", request.getParameter("fund_bill_list"));//	支付金额信息	String(512)	否	支付成功的各个渠道金额信息，详见资金明细信息说明	[{“amount”:“15.00”,“fundChannel”:“ALIPAYACCOUNT”}]
			ArrayList<String> list = new ArrayList<String>();
	        for(Map.Entry<String,Object> entry:map.entrySet()){
	            if(entry.getValue()!=null && entry.getValue()!=""){
	                list.add(entry.getKey() + "=" + entry.getValue() + "&");
	            }
	        }
	        int size = list.size();
	        String [] arrayToSort = list.toArray(new String[size]);
	        Arrays.sort(arrayToSort, String.CASE_INSENSITIVE_ORDER);
	        StringBuilder sb = new StringBuilder();
	        for(int i = 0; i < size; i ++) {
	            sb.append(arrayToSort[i]);
	        }
	        String result = sb.toString();
	        result = MD5.MD5Encode(result).toUpperCase();
	        //String sign_type=request.getParameter("sign_type");//	签名类型	String(10)	是	商户生成签名字符串所使用的签名算法类型，目前支持RSA2和RSA，推荐使用RSA2	RSA2
	        String sign=request.getParameter("sign");//	签名	String(256)	是	请参考异步返回结果的验签	601510b7970e52cc63db0f44997cf70e
	        RSACryption rc=new RSACryption();
	        Boolean b=false;
	        Order order = null;
	        try{
		        rc.loadPrivateKey(config.getAlipayPublicKey());
		        b=rc.verifyBase64(rc.getPublicKey(), result, MD5.MD5Encode(sign).toUpperCase());
	        }
	        catch(Exception e){
	        	
	        }
	        if(b){
	        	order=new Order(map.get("out_trade_no")!=null ?map.get("out_trade_no").toString():"",
	        			        map.get("subject")!=null ?map.get("subject").toString():"",
	        			        map.get("total_amount")!=null && !map.get("total_amount").toString().isEmpty() ? new BigDecimal(map.get("total_amount").toString()): new BigDecimal(0),
	        			        null);
	        	String tradeStatus=map.get("trade_status")!=null ? map.get("trade_status").toString() : "" ;
	        	if(tradeStatus.equals("WAIT_BUYER_PAY")){
	        		order.setStatus(PayStatus.NOTPAY);
				}
				else if(tradeStatus.equals("TRADE_CLOSED")){
					order.setStatus(PayStatus.NOTPAY);
				}
				else if(tradeStatus.equals("TRADE_SUCCESS")){
					order.setStatus(PayStatus.SUCCESS);
				}
				else if(tradeStatus.equals("TRADE_FINISHED")){
					order.setStatus(PayStatus.SUCCESS);
				}
				else{
					order.setStatus(PayStatus.NULL);
				}
	        }
			return order;
		}

		public void writeResposeInfo(HttpServletResponse respose,Boolean status) {
			if(status){
				try{
					respose.getOutputStream().write("success".getBytes("utf-8"));;
				}
				catch(Exception e){
					
				}
			}
		}

	

}
