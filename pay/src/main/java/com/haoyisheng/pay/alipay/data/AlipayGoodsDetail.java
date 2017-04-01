package com.haoyisheng.pay.alipay.data;

import java.io.Serializable;
import java.math.BigDecimal;

public class AlipayGoodsDetail  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String goods_id;// String 必填 32 商品的编号 apple-01
	
	private String alipay_goods_id;// String 可选 32 支付宝定义的统一商品编号 20010001
	
	private String goods_name;// String 必填 256 商品名称 ipad
	
	private Long quantity;// Number 必填 10 商品数量 1
	
	private BigDecimal price;// Price 必填 9 商品单价，单位为元 2000
	
	private String goods_category;// String 可选 24 商品类目 34543238
	
	private String body;// String 可选 1000 商品描述信息 特价手机
	
	private String  show_url;// String 可选 400 商品的展示地址 http://www.alipay.com/xxx.jpg

	public String getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(String goods_id) {
		this.goods_id = goods_id;
	}

	public String getAlipay_goods_id() {
		return alipay_goods_id;
	}

	public void setAlipay_goods_id(String alipay_goods_id) {
		this.alipay_goods_id = alipay_goods_id;
	}

	public String getGoods_name() {
		return goods_name;
	}

	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getGoods_category() {
		return goods_category;
	}

	public void setGoods_category(String goods_category) {
		this.goods_category = goods_category;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getShow_url() {
		return show_url;
	}

	public void setShow_url(String show_url) {
		this.show_url = show_url;
	}
	
	
}
