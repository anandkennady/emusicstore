package com.niit.shop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class Supplier {
	
	
	 @Id
	    @GeneratedValue
	private int supplierid;
	private String suppliername;
	private String suppliernumber;
	private String supplierproduct;
	private String supplieraddress;
	private int pincode;
	private MultipartFile supplierImage;
	public MultipartFile getSupplierImage() {
		return supplierImage;
	}
	public void setSupplierImage(MultipartFile supplierImage) {
		this.supplierImage = supplierImage;
	}
	public int getSupplierid() {
		return supplierid;
	}
	public void setSupplierid(int supplierid) {
		this.supplierid = supplierid;
	}
	public String getSuppliername() {
		return suppliername;
	}
	public void setSuppliername(String suppliername) {
		this.suppliername = suppliername;
	}
	public String getSuppliernumber() {
		return suppliernumber;
	}
	public void setSuppliernumber(String suppliernumber) {
		this.suppliernumber = suppliernumber;
	}
	public String getSupplierproduct() {
		return supplierproduct;
	}
	public void setSupplierproduct(String supplierproduct) {
		this.supplierproduct = supplierproduct;
	}
	public String getSupplieraddress() {
		return supplieraddress;
	}
	public void setSupplieraddress(String supplieraddress) {
		this.supplieraddress = supplieraddress;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
}
