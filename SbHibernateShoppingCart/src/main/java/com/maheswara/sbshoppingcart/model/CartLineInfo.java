package com.maheswara.sbshoppingcart.model;

public class CartLineInfo {

	private ProductInfo productInfo;
	private int quntity;
	
	public CartLineInfo() {
		this.quntity = 0;
	}

	public ProductInfo getProductInfo() {
		return productInfo;
	}

	public void setProductInfo(ProductInfo productInfo) {
		this.productInfo = productInfo;
	}

	public int getQuntity() {
		return quntity;
	}

	public void setQuntity(int quntity) {
		this.quntity = quntity;
	}
	
	//
	public double getAmount(){
		return this.productInfo.getPrice()*this.quntity;
				
	}
	
}
