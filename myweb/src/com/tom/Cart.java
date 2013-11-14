package com.tom;

import java.util.ArrayList;

public class Cart {
	String userid;
	int total = 0;
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
		total = 0;
		for (Item i : items){
			total+= i.getPrice()*i.getQty();
		}
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
