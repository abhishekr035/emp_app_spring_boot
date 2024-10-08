package org.jsp.emp.ExceptionClasses;

import lombok.Builder;
import lombok.NoArgsConstructor;
@Builder
@NoArgsConstructor
public class NoEducationFoundException extends RuntimeException 
{
		private String message;
		
		public NoEducationFoundException(String message) 
		{
			this.message=message;
		}
		
		@Override
		public String getMessage() 
		{
			return this.message;
		}
}
