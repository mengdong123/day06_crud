package com.entity;

import com.lzx.entity.common.Entity;

public class Category extends Entity{
	//手机号，唯一
	private String mobile;
	//密码
	private String pwd;
	//真实姓名
	private String real_name;
	//昵称
	private String nick_name;
	//邮箱
	private String email;
	//性别
	private Integer gender;
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getReal_name() {
		return real_name;
	}
	public void setReal_name(String real_name) {
		this.real_name = real_name;
	}
	public String getNick_name() {
		return nick_name;
	}
	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "Category [mobile=" + mobile + ", pwd=" + pwd + ", real_name=" + real_name + ", nick_name=" + nick_name
				+ ", email=" + email + ", gender=" + gender + ", getId()=" + getId() + "]";
	}
	
	

}
