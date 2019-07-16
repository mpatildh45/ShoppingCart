package com.maheswara.sbshoppingcart.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Products")
public class Product implements Serializable {

	private static final long serialVersionUID = -7772485037905445919L;

	@Id
	@Column(name="Code", length=20, nullable=false)
	private String code;
	
	@Column(name="Name", length=255, nullable=false)
	private String name;
	
	@Column(name="Price", nullable=false)
	private double price;
	
	@Column(name="Image", length=Integer.MAX_VALUE, nullable=false)
	private byte[] image;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="Create_Date", nullable=false)
	private Date createDate;
	
	public Product() {
		
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	
}
