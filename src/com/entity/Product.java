package com.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.lzx.entity.common.Entity;

public class Product extends Entity{
	//��Ʒ����
	private String name;
	//����ͼƬ
	private String thumbnail;
	//���
	private Integer inventory;
	//������
	private Integer sales_volume;
	//�۸�
	private BigDecimal price;
	//�ۼ�
	private BigDecimal sale_price;
	//���鸻�ı�����
	private String detail_description;
	//���㸻�ı����� 
	private String selling_description;
	//���ʱ��
	private Date create_time;
	//����ʱ��
	private Date sale_time;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public Integer getInventory() {
		return inventory;
	}
	public void setInventory(Integer inventory) {
		this.inventory = inventory;
	}
	public Integer getSales_volume() {
		return sales_volume;
	}
	public void setSales_volume(Integer sales_volume) {
		this.sales_volume = sales_volume;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public BigDecimal getSale_price() {
		return sale_price;
	}
	public void setSale_price(BigDecimal sale_price) {
		this.sale_price = sale_price;
	}
	public String getDetail_description() {
		return detail_description;
	}
	public void setDetail_description(String detail_description) {
		this.detail_description = detail_description;
	}
	public String getSelling_description() {
		return selling_description;
	}
	public void setSelling_description(String selling_description) {
		this.selling_description = selling_description;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public Date getSale_time() {
		return sale_time;
	}
	public void setSale_time(Date sale_time) {
		this.sale_time = sale_time;
	}
	@Override
	public String toString() {
		return "Product [name=" + name + ",  thumbnail=" + thumbnail + ", inventory=" + inventory
				+ ", sales_volume=" + sales_volume + ", price=" + price + ", sale_price=" + sale_price
				+ ", detail_description=" + detail_description + ", selling_description=" + selling_description
				+ ", create_time=" + create_time + ", sale_time=" + sale_time + "]";
	}
	

}
