package org.jsp.emp.ExceptionClasses;

import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
public class NoActiveEmployeeFoundException extends RuntimeException 
{
	private String message;
	
	public NoActiveEmployeeFoundException(String message)
	{
		this.message = message;
	}

	@Override
	public String getMessage() 
	{
		return this.message;
	}

}
