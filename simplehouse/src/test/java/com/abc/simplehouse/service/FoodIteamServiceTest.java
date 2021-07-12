package com.abc.simplehouse.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.abc.simplehouse.entity.FoodItem;
import com.abc.simplehouse.exceptions.ItemNotFoundException;
import com.abc.simplehouse.repository.FoodItemRepository;
import com.abc.simplehouse.serviceimpl.FoodItemsServiceImpl;

@SpringBootTest
class FoodIteamServiceTest {
	@Mock
	private FoodItemRepository foodItemRepository;
	
	 @InjectMocks
     private FoodItemsServiceImpl foodServiceImpl;

//	@InjectMocks
//	private FoodItemsService foodItemsService;

		@Test
		public void testSave() {
			FoodItem foodItems = new FoodItem();
			foodItems.setItemId(4);
			foodItems.setItemName("Noodles");
			foodItems.setItemPrice(100);
			foodItems.setItemType("FastFood");
			foodServiceImpl.save(foodItems);

		}

		@Test
		public void testGetById() {

			FoodItem foodItems = new FoodItem();
			foodItems.setItemId(4);
			foodItems.setItemName("Noodles");
			foodItems.setItemPrice(100);
			foodItems.setItemType("FastFood");
			Optional<FoodItem> optionalFoodItems = Optional.of(foodItems);
			when(foodItemRepository.findById(3)).thenReturn(optionalFoodItems);
			assertEquals("Noodles",foodItems.getItemName());
		}

		@Test
		public void testDeleteItems() {

			FoodItem foodItems = new FoodItem();
			foodItems.setItemId(4);
			foodItems.setItemName("Noodles");
			foodItems.setItemPrice(100);
			foodItems.setItemType("FastFood");
			Optional<FoodItem> optionalFoodItems = Optional.of(foodItems);
			when(foodItemRepository.findById(4)).thenReturn(optionalFoodItems);
			foodServiceImpl.deleteItem(foodItems.getItemId());

		}


    @Test
    public void testUpdateFoodItems() {

 

  
        FoodItem foodItems = new FoodItem();
		foodItems.setItemId(4);
		foodItems.setItemName("Noodles");
		foodItems.setItemPrice(100);
		foodItems.setItemType("FastFood");
        Optional<FoodItem> optionalFoodItems = Optional.of(foodItems);
        when(foodItemRepository.findById(4)).thenReturn(optionalFoodItems);
        foodServiceImpl.updateItem(4);

 

    }

		@Test
		public void testFoodItemNotFoundException() {
			when(foodItemRepository.findById(20)).thenThrow(ItemNotFoundException.class);

			assertThrows(ItemNotFoundException.class, () -> foodServiceImpl.getById(20));
		}
}