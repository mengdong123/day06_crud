package com.entity;

import com.lzx.entity.common.Entity;

public class Menu extends Entity{
 
	//�˵�����
	private String name;
	//�˵�ͼ������
	private String icon;
	//�˵�url
	private String url;
	//Ȩ��
	private Integer weight;
	//�����˵�id
	private Integer P_id;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	public Integer getP_id() {
		return P_id;
	}
	public void setP_id(Integer p_id) {
		P_id = p_id;
	}
	@Override
	public String toString() {
		return "Menu [name=" + name + ", icon=" + icon + ", url=" + url + ", weight=" + weight + ", P_id=" + P_id
				+ ", getId()=" + getId() + "]";
	}
	
	
	
	
}
