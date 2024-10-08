package org.jsp.emp.ExceptionClasses;

import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
public class InvalidEducationIdException extends RuntimeException
{
	private String message;
	
	public InvalidEducationIdException(String message) 
	{
		this.message=message;
	}
	
	@Override
	public String getMessage() 
	{
		return this.message;
	}
}
