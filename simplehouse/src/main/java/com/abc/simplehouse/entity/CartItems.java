package com.abc.simplehouse.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name="CARTITEMS_TBL")
public class CartItems {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private int quantity;
	
	@OneToOne
	private FoodItem foodItem;
	
	@ManyToOne
	@JoinColumn(name="cartId")
	@JsonBackReference
	private FoodCart foodCart;

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

	public FoodCart getFoodCart() {
		return foodCart;
	}

	public void setFoodCart(FoodCart foodCart) {
		this.foodCart = foodCart;
	}
	
}

