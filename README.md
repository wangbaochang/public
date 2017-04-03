# 支付宝，微信扫码付<br> 
## 使用方法：<br> 
//配置 alipay.properties  weixin.properties
//创建订单  参数 订单编号 订单名称 订单金额  下单IP<br>
Order order=new Order("1111111111","测试定单",new BigDecimal(0.01),"127.0.0.1");<br> 
//支付宝支付<br>
Pay pay=PayFactory.getPay(PayType.alipay);<br> 
//微信支付<br>
Pay pay=PayFactory.getPay(PayType.weixin);<br>
//取得支付url<br> 
String url=pay.placeOrder(order);<br>
//打印支付url二维码图片Base64String。<br> 
logger.debug("支付二维码Base64String:"+QRCodeUtil.getQRCodeImageBase64String(url));<br>
logger.debug("订单状态:"+pay.queryOrder(order.getOrderNumber()).getExplanation());<br> 
logger.debug("关闭订单："+pay.closeOrder(order.getOrderNumber()));<br> 
