package org.jsp.emp.ExceptionClasses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
public class InvalidEmployeeIdException extends RuntimeException 
{
	private String message;
	
	public InvalidEmployeeIdException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return this.message;
	}
}
