package org.jsp.emp.Service;

import java.util.List;
import java.util.Optional;

import org.jsp.emp.Dao.EducationDao;
import org.jsp.emp.Entity.Education;
import org.jsp.emp.Entity.Employee;
import org.jsp.emp.ExceptionClasses.InvalidEducationIdException;
import org.jsp.emp.ExceptionClasses.InvalidEmployeeIdException;
import org.jsp.emp.ExceptionClasses.NoEducationFoundException;
import org.jsp.emp.ResponseStructure.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class EducationService 
{
	@Autowired
	private EducationDao dao;

	public ResponseEntity<?> saveEducation(Education education) 
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(ResponseStructure.builder().status(HttpStatus.CREATED.value()).message("Education Details saved Successfully.....!").body(dao.saveEducation(education)).build());
	}

	public ResponseEntity<?> updateEducation(Education education) {
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("Education Details Updated Successfully............").body(dao.updateEducation(education)).build());
	}

	public ResponseEntity<?> findAllEducation() 
	{
		List<Education> education = dao.findAllEducation();	
		if(education.isEmpty())
		{
			throw NoEducationFoundException.builder().message("No Education Details Present in the Database..!").build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("All Education Details Found..........").body(education).build());
	}

	public ResponseEntity<?> findEducationById(int id) 
	{
		Optional<Employee> optional = dao.findEducationById(id);
		if(optional.isEmpty())
		{
			throw InvalidEducationIdException.builder().message("Invalid Education Id...,Unable to find..!").build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("Education Id verifies Successfully............").body(optional.get()).build());
	}
	
//	public ResponseEntity<?> findEmployeeById(int id) {
//		Optional<Employee> optional = dao.findEmployeeById(id);
////		ResponseStructure<Employee> structure = new ResponseStructure<Employee>();
//		if (optional.isEmpty()) {
////			structure.setStatus(HttpStatus.NOT_FOUND.value());
////			structure.setMessage("Invalid id........ Unable to find Employeee");
////			structure.setBody(null);
////			return structure;
//			throw InvalidEmployeeIdException.builder().message("Invalid Employee Id...,Unable to find..!").build();
//		}
//		Employee employee = optional.get();
////		structure.setStatus(HttpStatus.OK.value());
////		structure.setMessage();
////		structure.setBody(employee);
//		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("Employee Id verifies Successfully............").body(employee).build());
//	}
//		

}
