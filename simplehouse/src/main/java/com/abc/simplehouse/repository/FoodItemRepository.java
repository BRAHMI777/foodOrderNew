package com.abc.simplehouse.repository;





import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.abc.simplehouse.entity.FoodItem;

public interface FoodItemRepository extends JpaRepository<FoodItem,Integer> {
	
	@Query("SELECT c FROM FoodItem c WHERE itemName = ?1")
	public FoodItem findByItemName(String name);

}
