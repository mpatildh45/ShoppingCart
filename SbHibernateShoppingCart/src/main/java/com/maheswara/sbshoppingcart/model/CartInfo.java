package com.maheswara.sbshoppingcart.model;

import java.util.ArrayList;
import java.util.List;

public class CartInfo {

	private int orderNum;
	private CustomerInfo customerInfo;
	private final List<CartLineInfo> cartLines = new ArrayList<CartLineInfo>();
	
	public CartInfo() {
		
	}

	public int getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}

	public CustomerInfo getCustomerInfo() {
		return customerInfo;
	}

	public void setCustomerInfo(CustomerInfo customerInfo) {
		this.customerInfo = customerInfo;
	}

	public List<CartLineInfo> getCartLines() {
		return this.cartLines;
	}
	
	private CartLineInfo findLineByCode(String code) {
		
		for (CartLineInfo line : this.cartLines) {
			if(line.getProductInfo().getCode().equals(code)) {
				return line;
			}
		}
		return null;
	}
	
	public void addProduct(ProductInfo productInfo, int quantity) {
		
		CartLineInfo line = this.findLineByCode(productInfo.getCode());
		
		if(line==null) {
			line = new CartLineInfo();
			line.setQuntity(0);
			line.setProductInfo(productInfo);
			this.cartLines.add(line);
		}
		int newQuantity = line.getQuntity()+ quantity;
		if(newQuantity <= 0) {
			this.cartLines.remove(line);
		}else {
			line.setQuntity(newQuantity);
		}
	}
	
	public void validate() {
		
	}
	
	public void updateProduct(String code, int quantity) {
		
		CartLineInfo line = this.findLineByCode(code);
		
		if(line != null) {
			if(quantity <= 0) {
				this.cartLines.remove(line);
			}else {
				line.setQuntity(quantity);
			}
		}
	}
	
	public boolean isEmpty(){
		return this.cartLines.isEmpty();
	}
	
	public boolean isValidCustomer() {
		return this.customerInfo != null && this.customerInfo.isValid();
	}
	
	public int getQuantityTotal(){
		int quantity = 0;
		for (CartLineInfo line : this.cartLines) {
			quantity += line.getQuntity();
		}
		return quantity;
	}
	
	public double getAmountTotal(){
		double total = 0;
		for (CartLineInfo line : this.cartLines) {
			total += line.getAmount();
		}
		return total;
	}
	
	public void updateQuantity(CartInfo cartForm) {
		
		if(cartForm != null) {
	     	List<CartLineInfo> lines = cartForm.getCartLines();
			
			for (CartLineInfo line : lines) {
				this.updateProduct(line.getProductInfo().getCode(), line.getQuntity());
			}		
		}
	}
}
