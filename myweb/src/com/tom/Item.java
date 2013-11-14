package com.tom;

public class Item {
	int id;
	int price;
	int qty;
	
	public Item(int id, int price, int qty) {
		super();
		this.id = id;
		this.price = price;
		this.qty = qty;
	}

	public Item(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}
	
}
