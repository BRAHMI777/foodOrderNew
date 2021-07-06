package com.abc.simplehouse.repository;



import org.springframework.data.jpa.repository.JpaRepository;


import com.abc.simplehouse.entity.FoodItem;

public interface FoodItemRepository extends JpaRepository<FoodItem,Integer> {
	
	
	//public Optional<FoodItem> findFoodItemByName(String name);

}
