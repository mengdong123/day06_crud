package com.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * mypaper 的自定义标签
 * 
 * @author 51019
 *
 */
public class MyPaper extends SimpleTagSupport {

	// 当前页数
	private int number;
	// 当前页有多少条
	private int size;
	//
	private String url;
	// 总条数
	private long totalElements;

	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out = this.getJspContext().getOut();
		// 往js页面中输出的字符串
		StringBuilder sb = new StringBuilder();
		// 拼出的访问地址
		StringBuilder comm = new StringBuilder(url);
		
		//加入栅格
		
		// 访问逻辑
		if (totalElements < 0) {
			sb.append("没有访问数据");
		} else {
			//计算总页数
			int totalpager = (int) ((totalElements + size - 1) / size);
			//sb.append("总共").append(totalElements).append("条数据，共").append(totalpager).append("页,当前是第").append(number).append("页，本页共").append(size).append("条数据");
			// 拼写访问地址
			// 判断url地址中是否包含‘？’，如果包含就用‘&’拼接，没有则用‘？’
			if (url.indexOf("?") == -1) {
				comm.append("?number=");
			} else {
				comm.append("&number=");
			}
            //判断number的值
			if(number<1) {
				number=1;
			}if(number>totalpager) {
				number=totalpager;
			}
			sb.append("<div align='right'><ul class='pager'>");
			if (number == 1) {
				sb.append("<li class='previous disabled'><a href='javascript:void(0)'>").append("首页").append("</a></li>");
				sb.append("<li class='previous disabled'><a href='javascript:void(0)'>").append("«上一页").append("</a></li>");
				}else {
				sb.append("<li class='previous'><a href='").append(comm).append("1").append("&size=").append(size).append("'>").append("首页").append("</a></li>");
				sb.append("<li><a href='").append(comm).append(number-1).append("&size=").append(size).append("'>").append("«上一页").append("</a></li>");
				}
			
			//定义页数
			for(int i=1;i<=totalpager;i++) {
				//当i=number的时候，number为选中状态
				if(i==number) {
					sb.append("<li class='active'>");
				}else {
					sb.append("<li>");
				}
				sb.append("<a href='").append(comm).append(i).append("&size=").append(size).append("'>").append(i).append("</a></li>");
			}
			if (number == totalpager) {
				sb.append("<li class='previous disabled'><a href='javascript:void(0)'>").append("下一页»").append("</a></li>");
				sb.append("<li class='previous disabled'><a href='javascript:void(0)'>").append("尾页").append("</a></li>");
			}else {
				sb.append("<li><a href='").append(comm).append(number+1).append("&size=").append(size).append("'>").append("下一页»").append("</a></li>");
				sb.append("<li class='next'><a href='").append(comm).append(totalpager).append("&size=").append(size).append("'>").append("尾页").append("</a></li>");
			}
			
			sb.append("</ul></div>");
			out.print(sb.toString());
		}
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public long getTotalElements() {
		return totalElements;
	}

	public void setTotalElements(long totalElements) {
		this.totalElements = totalElements;
	}

}
