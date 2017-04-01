package com.haoyisheng.pay.alipay.data;

import java.io.Serializable;
import java.util.List;

public class AlipayRoyaltyInfo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String royalty_type;// String 可选 150 分账类型 卖家的分账类型，目前只支持传入ROYALTY（普通分账类型）。
	
	private List<AlipayRoyaltyDetailInfos> royalty_detail_infos;//RoyaltyDetailInfos [] 必填 2500 分账明细的信息，可以描述多条分账指令，json数组。

	public String getRoyalty_type() {
		return royalty_type;
	}

	public void setRoyalty_type(String royalty_type) {
		this.royalty_type = royalty_type;
	}

	public List<AlipayRoyaltyDetailInfos> getRoyalty_detail_infos() {
		return royalty_detail_infos;
	}

	public void setRoyalty_detail_infos(List<AlipayRoyaltyDetailInfos> royalty_detail_infos) {
		this.royalty_detail_infos = royalty_detail_infos;
	}
	
}
