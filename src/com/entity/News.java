package com.entity;

import java.util.Date;

import com.lzx.entity.common.Entity;

public class News extends Entity{

	//新闻标题
	private String title;
	//主配图片
	private String thumbnail;
	//新闻内容
	private String content;
	//点击量
	private Integer hits;
	//是否轮播图
	private Integer top;
	//发布时间
	private Date pub_time;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getHits() {
		return hits;
	}
	public void setHits(Integer hits) {
		this.hits = hits;
	}
	public Integer getTop() {
		return top;
	}
	public void setTop(Integer top) {
		this.top = top;
	}
	public Date getPub_time() {
		return pub_time;
	}
	public void setPub_time(Date pub_time) {
		this.pub_time = pub_time;
	}
	@Override
	public String toString() {
		return "News [title=" + title + ", thumbnail=" + thumbnail + ", content=" + content + ", hits=" + hits
				+ ", top=" + top + ", pub_time=" + pub_time + ", getId()=" + getId() + "]";
	}
	
	
}
