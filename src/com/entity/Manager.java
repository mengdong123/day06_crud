package com.entity;

import java.util.Date;

import com.lzx.entity.common.Entity;
/*
 * ����managerʵ����
 */
public class Manager extends Entity{
    //��¼��
	private String lname;
	//����
	private String pwd;
	//��ʵ����
	private String real_name;
	//������ֵ
	private String salt;
	//����
	private String email;
	//Ա����ְ����
	private Date joined_date;
	//״̬
	private Integer status;
	//ͷ��
	private String avatar;
	//��ϵ�绰
	private String tel;
	//��ע
	private String memo;
	//����ʱ��
	private Date create_time;
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
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
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getJoined_date() {
		return joined_date;
	}
	public void setJoined_date(Date joined_date) {
		this.joined_date = joined_date;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	@Override
	public String toString() {
		return "Manager [lname=" + lname + ", pwd=" + pwd + ", real_name=" + real_name + ", salt=" + salt + ", email="
				+ email + ", joined_date=" + joined_date + ", status=" + status + ", avatar=" + avatar + ", tel=" + tel
				+ ", memo=" + memo + ", create_time=" + create_time + ", getId()=" + getId() + "]";
	}

	
}
