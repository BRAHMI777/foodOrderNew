package com.abc.simplehouse.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="ORDERITEM_TBL")
public class OrderItem {
	
	@Id
	private int id;
	
	private int quantity;
	
	@OneToOne
	private FoodItem foodItem;
	
	@ManyToOne
	private Order order;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
	public FoodItem getFoodItem() {
		return foodItem;
	}

	public void setFoodItem(FoodItem foodItem) {
		this.foodItem = foodItem;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
}

