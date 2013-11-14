package com.tom;

import java.util.ArrayList;

public class Cart {
	String userid;
	int total;
	ArrayList<Item> items = new ArrayList<Item>();
	
	public Cart(){
		
	}
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public ArrayList<Item> getItems() {
		return items;
	}
	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}
	
	
}
