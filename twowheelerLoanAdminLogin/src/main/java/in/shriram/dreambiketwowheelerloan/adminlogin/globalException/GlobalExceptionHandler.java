package in.shriram.dreambiketwowheelerloan.adminlogin.globalException;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import in.shriram.dreambiketwowheelerloan.adminlogin.dto.CustomerResponse;
import in.shriram.dreambiketwowheelerloan.adminlogin.exceptions.InvalidAgeException;
import in.shriram.dreambiketwowheelerloan.adminlogin.exceptions.InvalidEmailException;
import in.shriram.dreambiketwowheelerloan.adminlogin.exceptions.InvalidEmpId;
import in.shriram.dreambiketwowheelerloan.adminlogin.exceptions.InvalidFileTypeException;
import in.shriram.dreambiketwowheelerloan.adminlogin.exceptions.InvalidPhotoTypeException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(InvalidAgeException.class)
	public ResponseEntity<CustomerResponse> handleInvalidAgeException(InvalidAgeException ae)
	{
		String message = ae.getMessage();
		
		CustomerResponse cr = new CustomerResponse(message, new Date());
		
		return new ResponseEntity<CustomerResponse>(cr, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(InvalidEmailException.class)
	public ResponseEntity<CustomerResponse> handleInvalidEmailException(InvalidEmailException ae)
	{
		String message = ae.getMessage();
		
		CustomerResponse cr = new CustomerResponse(message, new Date());
		
		return new ResponseEntity<CustomerResponse>(cr, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(InvalidFileTypeException.class)
	public ResponseEntity<CustomerResponse> handleInvalidFileTypeException(InvalidFileTypeException ae)
	{
		String message = ae.getMessage();
		
		CustomerResponse cr = new CustomerResponse(message, new Date());
		
		return new ResponseEntity<CustomerResponse>(cr, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(InvalidPhotoTypeException.class)
	public ResponseEntity<CustomerResponse> handleInvalidPhotoTypeException(InvalidPhotoTypeException ae)
	{
		String message = ae.getMessage();
		
		CustomerResponse cr = new CustomerResponse(message, new Date());
		
		return new ResponseEntity<CustomerResponse>(cr, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(InvalidEmpId.class)
	public ResponseEntity<CustomerResponse> handleInvalidEmpId(InvalidEmpId ae)
	{
		String message = ae.getMessage();
		
		CustomerResponse cr = new CustomerResponse(message, new Date());
		
		return new ResponseEntity<CustomerResponse>(cr, HttpStatus.BAD_REQUEST);
	}
}
