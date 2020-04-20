package com.entity;

import java.util.ArrayList;
import java.util.List;

public class Page<T> {
	//��ǰ�ڼ�ҳ
	private int number;
	//��ǰҳ������
	private int size;
	//������
	private double totalcount;
	//��ҳ��
	private double totalpage;
	
	List<T> items = new ArrayList<T>();

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

	public double getTotalcount() {
		return totalcount;
	}

	public void setTotalcount(double totalcount) {
		this.totalcount = totalcount;
	}

	public double getTotalpage() {
		return totalpage;
	}

	public void setTotalpage(double totalpage) {
		this.totalpage = totalpage;
	}

	public List<T> getItems() {
		return items;
	}

	public void setItems(List<T> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Page [number=" + number + ", size=" + size + ", totalcount=" + totalcount + ", totalpage=" + totalpage
				+ ", items=" + items + "]";
	}
	
	

}
