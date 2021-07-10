package com.abc.simplehouse.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.abc.simplehouse.entity.Customer;
import com.abc.simplehouse.entity.Order;
import com.abc.simplehouse.entity.OrderItem;
import com.abc.simplehouse.entity.Payment;
import com.abc.simplehouse.repository.OrderRepository;
import com.abc.simplehouse.serviceimpl.OrderServiceImpl;


/**
 * @author lavan
 *
 */
@SpringBootTest
public class OrderServiceTestCases {
	
	        @Mock
	        private OrderRepository OrderRepository;

	        @InjectMocks
	        private OrderServiceImpl OrderServiceImpl;
	        
	        @InjectMocks
	        private OrderService orderService;

           @Test
            public void testCreateOrder() {
                
                Customer customer = new Customer();
                customer.setCustomerId(111);
                customer.setCustomerName("dfkj"); 
                //set other fields

                Payment payment = new Payment();
                payment.setPaymentId(10);
                //set other fields

                OrderItem item1 = new OrderItem();
                item1.setId(1);
                //set other fields
                
            OrderItem item2 = new OrderItem();
                item2.setId(2);
                //set other fields


                 List<OrderItem> list=new ArrayList<>();
                 list.add(item1);
                 list.add(item2);

            Order order=new Order();
            order.setId(1001);
                order.setTotalCost(5000);
                order.setOrderDate(LocalDate.now());
                order.setCustomer(customer);
                Optional<Order> optionalOrder = Optional.of(order);    
                
                when(OrderRepository.save(order)).thenReturn(optionalOrder.get());

                   // OrderPayload orderPayload = new OrderPayload();
                   //set all the values
                   
                  
                   //orderService.createOrder(orderPayload);    
                   
               assertEquals(customer,optionalOrder.get().getCustomer());


           }
	        
	        @Test
	        public void testfetchAllOrders(){
	        	    Order order=new Order();
	        	    order.setId(150);
	        	    order.setTotalCost(120);

	        	     Order order1=new Order();
	        	    order1.setId(160);
	        	    order1.setTotalCost(200);

	        	             
	        	    Order order2=new Order();
	        	    order2.setId(170);
	        	    order2.setTotalCost(100);

	        	       

	        	               List<Order> orders = new ArrayList<Order>();

	        	               orders.add(order);

	        	               orders.add(order1);

	        	               orders.add(order2);

	        	     

	        	          when(OrderRepository.findAll()).thenReturn(orders);
	        	               List<Order> productList = OrderServiceImpl.fetchAllOrders();
                                assertEquals(3,orders.size());
    	
	        	
	        }
	        
	        @Test
	        public void testfingById(){
	        	Order order=new Order();
	        	order.setId(150);
	        	//payment.setPaymentDate(2021-07-08);
	        	order.setTotalCost(120);
	        	Optional<Order> optionalOrder = Optional.of(order);
	        	when(OrderRepository.findById(150)).thenReturn(optionalOrder);
	        	assertEquals(120,order.getTotalCost());
	        }

	        

//	        @Test
//	        public Order testupdateOrderById(){
//	        	Order order=new Order();
//	        	order.setId(4);
//	        	order.setTotalCost(250);
//	        	//OrderServiceImpl.updateOrderById(Order);
//	            OrderRepository.findById(4);
//	            order.setId(4);
//	            return OrderRepository.save(order);
//	        	
	       // }
	}