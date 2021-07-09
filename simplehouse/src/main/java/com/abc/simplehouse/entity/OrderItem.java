package com.abc.simplehouse.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="ORDERITEM_TBL")
public class OrderItem {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private int quantity;
	
	@ManyToOne
	@JsonBackReference
	private Order order;

    @OneToOne
	private FoodItem foodItem;

	/**
	 * This method is to get Id.
	 * @return
	 * 09-Jul-2021
	 */
	public int getId() {
		return id;
	}

	/**
	 * This method is to set Id.
	 * @param id
	 * 09-Jul-2021
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * This method is to get quantity.
	 * @return
	 * 09-Jul-2021
	 */
	public int getQuantity() {
		return quantity;
	}

	
	/**
	 * This method is to set quality.
	 * @param quantity
	 * 09-Jul-2021
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
	public FoodItem getFoodItem() {
		return foodItem;
	}

	public void setFoodItem(FoodItem foodItem) {
		this.foodItem = foodItem;
	}

	
	/**
	 * This method is to get order.
	 * @return
	 * 09-Jul-2021
	 */
	public Order getOrder() {
		return order;
	}



	/**
	 * This method is to set order.
	 * @param order
	 * 09-Jul-2021
	 */
	public void setOrder(Order order) {
		this.order = order;
	}
	
}

