package com.tom;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Driver;

public class Product {
	int id;
	String name;
	String desc;
	int price;
	int stock;
	String pic;
	ArrayList<Product> products = new ArrayList<Product>();

	public Product(int id, String name, String desc, int price, int stock,
			String pic) {
		super();
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.price = price;
		this.stock = stock;
		this.pic = pic;
	}

	public Product() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		System.out.println("setId called:" + id);
		if (products.size() == 0)
			products = getProducts();
		for (Product p : products) {
			if (p.id == id) {
				this.name = p.name;
				this.desc = p.desc;
				this.price = p.price;
				this.stock = p.stock;
				this.pic = p.pic;
				break;
			}
		}
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public ArrayList<Product> getProducts() {
		products.clear();
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			DriverManager.registerDriver(new Driver());
			// Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://j.snpy.org/j102",
					"jstu", "abc123");
			String sql = "select * from products";
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String desc = rs.getString("desc");
				int price = rs.getInt("price");
				int stock = rs.getInt("stock");
				String pic = rs.getString("pic");
				Product p = new Product(id, name, desc, price, stock, pic);
				products.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (conn != null && pstmt != null) {
					pstmt.close();
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return products;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}

}
