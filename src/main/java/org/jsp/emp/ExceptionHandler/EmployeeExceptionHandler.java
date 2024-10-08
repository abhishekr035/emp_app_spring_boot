package org.jsp.emp.ExceptionHandler;

import java.sql.SQLIntegrityConstraintViolationException;

import org.jsp.emp.ExceptionClasses.InvalidCredentialException;
import org.jsp.emp.ExceptionClasses.InvalidEducationIdException;
import org.jsp.emp.ExceptionClasses.InvalidEmployeeIdException;
import org.jsp.emp.ExceptionClasses.NoActiveEmployeeFoundException;
import org.jsp.emp.ExceptionClasses.NoEducationFoundException;
import org.jsp.emp.ExceptionClasses.NoEmployeeFoundException;
import org.jsp.emp.ResponseStructure.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EmployeeExceptionHandler 
{
	@ExceptionHandler(NoActiveEmployeeFoundException.class)
	public ResponseEntity<ResponseStructure<String>> noActiveEmployeeFoundExceptionHandler(NoActiveEmployeeFoundException e)
	{
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setMessage("No Active Employee Found..!");
		structure.setBody(e.getMessage());
		return new ResponseEntity(structure, HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(InvalidEmployeeIdException.class)
	public ResponseEntity<ResponseStructure<String>> invalidEmployeeIdExceptionHandler(InvalidEmployeeIdException e)
	{
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setMessage("Invalid Employee Id..");
		structure.setBody(e.getMessage());
		return new ResponseEntity(structure, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InvalidCredentialException.class)
	public ResponseEntity<ResponseStructure<String>> invalidCredentialExceptionHandler(InvalidCredentialException e)
	{
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setMessage("Invalid Email_Id or Password..,Please check it...!");
		structure.setBody(e.getMessage());
		return new ResponseEntity(structure, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NoEmployeeFoundException.class)
	public ResponseEntity<ResponseStructure<String>>  noEmployeeFoundExceptionExceptionHandler(NoEmployeeFoundException e)
	{
	    ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setMessage("Requested Name Not Found..,Please check it...!");
		structure.setBody(e.getMessage());
		return new ResponseEntity(structure, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	public ResponseEntity<ResponseStructure<String>>  sQLIntegrityConstraintViolationExceptionHandler(SQLIntegrityConstraintViolationException e)
	{
	    ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setStatus(HttpStatus.BAD_REQUEST.value());
		structure.setMessage("Invalid Email or Phone Number...!");
		structure.setBody(e.getMessage());
		return new ResponseEntity(structure, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NoEducationFoundException.class)
	public ResponseEntity<ResponseStructure<String>>  noEducationFoundExceptionHandler(NoEducationFoundException e)
	{
	    ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setMessage("No Education Details Found...!");
		structure.setBody(e.getMessage());
		return new ResponseEntity(structure, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InvalidEducationIdException.class)
	public ResponseEntity<ResponseStructure<String>> invalidEducationIdExceptionHandler(InvalidEducationIdException e)
	{
	    ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setMessage("Invalid Education Id..!");
		structure.setBody(e.getMessage());
		return new ResponseEntity(structure, HttpStatus.NOT_FOUND);
	}
}
