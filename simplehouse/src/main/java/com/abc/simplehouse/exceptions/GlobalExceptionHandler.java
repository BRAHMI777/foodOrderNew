package com.abc.simplehouse.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	/**
	 * This method handles ItemAlreadyExistingException.
	 * @param e
	 * @return ResponseEntity
	 * 04-Jul-2021
	 */
	@ExceptionHandler(ItemAlreadyExistingException.class)
	public ResponseEntity<?> handleProductAlredyExistingException(Exception e) {
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	/**
	 * This method handles ItemNotFoundException.
	 * @param e
	 * @return ResponseEntity
	 * 04-Jul-2021
	 */
	@ExceptionHandler(ItemNotFoundException.class)
	public ResponseEntity<?> ItemNotFoundException(Exception e)
	{
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	/**
	 * This method handles OrderAlreadyExistingException.
	 * @param e
	 * @return ResponseEntity
	 * 06-Jul-2021
	 */
	@ExceptionHandler(OrderAlreadyExistingException.class)
	public ResponseEntity<?> OrderAlreadyExistingException(Exception e)
	{
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	/**
	 * This method handles OrderNotFoundException.
	 * @param e
	 * @return ResponseEntity
	 * 06-Jul-2021
	 */
	@ExceptionHandler(OrderNotFoundException.class)
	public ResponseEntity<?> OrderNotFoundException(Exception e)
	{
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	
	/**
	 * This method handles NoOrderItemsFoundException.
	 * @param e
	 * @return ResponseEntity
	 * 06-Jul-2021
	 */
	@ExceptionHandler(NoOrderItemFoundException.class)
	public ResponseEntity<?> NoOrderItemsFoundException(Exception e)
	{
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}

}
