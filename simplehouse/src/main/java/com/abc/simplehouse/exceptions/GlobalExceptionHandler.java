package com.abc.simplehouse.exceptions;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.*;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	

	//private ErrorResponse errorResponse;
	
	/**
	 * This method handles ItemAlreadyExistingException.
	 * @param e
	 * @return ResponseEntity
	 * 04-Jul-2021
	 */
	@ExceptionHandler(ItemAlreadyExistingException.class)
	public ResponseEntity<?> ProductAlredyExistingException(Exception e) {
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

	
	/**
	 * This method handles CustomerAlreadyExistsException.
	 * @param e
	 * @return ResponseEntity
	 * 06-Jul-2021
	 */
	@ExceptionHandler(CustomerAlreadyExistsException.class)
	public ResponseEntity<?> CustomerAlreadyExistsException(Exception e)
	{
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	
	/**
	 * This method handles CustomerNotFoundException.
	 * @param e
	 * @return ResponseEntity
	 * 06-Jul-2021
	 */
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<?> CustomerNotFoundException(Exception e)
	{
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	
	/**
	 * This method handles PaymentAlreadyExistsException.
	 * @param e
	 * @return ResponseEntity
	 * 06-Jul-2021
	 */
	@ExceptionHandler(PaymentDetailsNotFoundException.class)
	public ResponseEntity<?> PaymentDetailsNotFoundException(Exception e)
	{
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	/**
	 * This method handles PaymentAlreadyExistsException.
	 * @param e
	 * @return ResponseEntity
	 * 06-Jul-2021
	 */
	@ExceptionHandler(PaymentAlreadyExistsException.class)
	public ResponseEntity<?> PaymentAlreadyExistsException(Exception e)
	{
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	/**
	 * This method handles CartItemNotFoundException.
	 * @param e
	 * @return ResponseEntity
	 * 06-Jul-2021
	 */
	@ExceptionHandler(CartItemNotFoundException.class)
	public ResponseEntity<?> CartItemNotFoundException(Exception e)
	{
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}

	
	/**
	 * This method handles CartAlreadyExistingException.
	 * @param e
	 * @return ResponseEntity
	 * 06-Jul-2021
	 */
	@ExceptionHandler(CartAlreadyExistingException.class)
	public ResponseEntity<?> CartAlreadyExistingException(Exception e)
	{
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	/**
	 * This method handles CartNotFoundException.
	 * @param e
	 * @return ResponseEntity
	 * 06-Jul-2021
	 */
	@ExceptionHandler(CartNotFoundException.class)
	public ResponseEntity<?> CartNotFoundException(Exception e)
	{
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	
	/**
	 * This method handles InvalidCustomerException.
	 * @param e
	 * @return ResponseEntity
	 * 06-Jul-2021
	 */
	@ExceptionHandler(InvalidCustomerException.class)
	public ResponseEntity<?> InvalidCustomerException(Exception e)
	{
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
	

	/**
	 * This method handles CredentialsNotValidException.
	 * @param e
	 * @return ResponseEntity
	 * 06-Jul-2021
	 */
	@ExceptionHandler(CredentialsNotValidException.class)
	public ResponseEntity<?> CredentialsNotValidException(Exception e)
	{
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	/**
	 * This method handles PasswordMismatchException.
	 * @param e
	 * @return ResponseEntity
	 * 06-Jul-2021
	 */
	@ExceptionHandler(PasswordMismatchException.class)
	public ResponseEntity<?> PasswordMismatchException(Exception e)
	{
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@Override
	public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		Map<String, Object> body = new LinkedHashMap<>();
	body.put("status", status.value());
	List<String> errors = ex.getBindingResult().getFieldErrors().stream().map(x -> x.getDefaultMessage())
			.collect(Collectors.toList());
	body.put("errors", errors);
	return new ResponseEntity<>(body,headers,status);		
	}
	
}
