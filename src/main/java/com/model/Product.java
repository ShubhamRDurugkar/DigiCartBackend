package com.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
@Component
@Entity
@Table(name = "products")
public class Product {
	@Id
	@GeneratedValue
	private int pid;
	private String pname;
	private String pDescription;
	private Float pPrice;
	private Integer pStock;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cid")
	private Category category;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "sid")
	private Supplier supplier;

	@Transient
	MultipartFile productImage;
	private String imgname;

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getpDescription() {
		return pDescription;
	}

	public void setpDescription(String pDescription) {
		this.pDescription = pDescription;
	}

	public Float getpPrice() {
		return pPrice;
	}

	public void setpPrice(Float pPrice) {
		this.pPrice = pPrice;
	}

	public Integer getpStock() {
		return pStock;
	}

	public void setpStock(Integer pStock) {
		this.pStock = pStock;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public MultipartFile getProductImage() {
		return productImage;
	}

	public void setProductImage(MultipartFile productImage) {
		this.productImage = productImage;
	}

	public String getImgname() {
		return imgname;
	}

	public void setImgname(String imgname) {
		this.imgname = imgname;
	}

	

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	
}
