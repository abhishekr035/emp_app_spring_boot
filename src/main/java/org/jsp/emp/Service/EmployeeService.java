package org.jsp.emp.Service;

import java.util.List; 
import java.util.Optional;
import org.jsp.emp.Dao.EmployeeDao;
import org.jsp.emp.Entity.Employee;
import org.jsp.emp.ExceptionClasses.InvalidCredentialException;
import org.jsp.emp.ExceptionClasses.InvalidEmployeeIdException;
import org.jsp.emp.ExceptionClasses.NoActiveEmployeeFoundException;
import org.jsp.emp.ExceptionClasses.NoEmployeeFoundException;
import org.jsp.emp.ResponseStructure.ResponseStructure;
import org.jsp.emp.util.EmployeeStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class EmployeeService {
	@Autowired
	private EmployeeDao dao;

	public ResponseEntity<?> saveEmployee(Employee employee) 
	{
		employee.setStatus(EmployeeStatus.IN_ACTIVE);
//		employee = dao.saveEmployee(employee);
//		ResponseStructure<Employee> structure = new ResponseStructure<>();		
//		structure.setStatus(HttpStatus.CREATED.value());
//		structure.setMessage("Employee Details saved Successfully............");
//		structure.setBody(employee);
		return ResponseEntity.status(HttpStatus.CREATED).body(ResponseStructure.builder().status(HttpStatus.CREATED.value()).message("Employee Details saved Successfully.....!").body(dao.saveEmployee(employee)).build());
	}

	public ResponseEntity<?> updateEmployee(Employee employee) {
//		employee = dao.updateEmployee(employee);
//		ResponseStructure<Employee> structure = new ResponseStructure<>();
//		structure.setStatus(HttpStatus.OK.value());
//		structure.setMessage("Employee Details Updated Successfully............");
//		structure.setBody(employee);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("Employee Details Updated Successfully............").body(dao.updateEmployee(employee)).build());	
	}

	public ResponseEntity<?> findEmployeeById(int id) {
		Optional<Employee> optional = dao.findEmployeeById(id);
//		ResponseStructure<Employee> structure = new ResponseStructure<Employee>();
		if (optional.isEmpty()) {
//			structure.setStatus(HttpStatus.NOT_FOUND.value());
//			structure.setMessage("Invalid id........ Unable to find Employeee");
//			structure.setBody(null);
//			return structure;
			throw InvalidEmployeeIdException.builder().message("Invalid Employee Id...,Unable to find..!").build();
		}
		Employee employee = optional.get();
//		structure.setStatus(HttpStatus.OK.value());
//		structure.setMessage();
//		structure.setBody(employee);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("Employee Id verifies Successfully............").body(employee).build());
	}
	
	public ResponseEntity<?> findAllActiveEmployee() {
		List<Employee> employees = dao.findAllActiveEmployee();
//		ResponseStructure<List<Employee>> structure = new ResponseStructure<>();

		if (employees.isEmpty()) 
		{
//			structure.setStatus(HttpStatus.NOT_FOUND.value());
//			structure.setMessage("No employee found in the database..........");
//			structure.setBody(employees);
//			return structure;
			
			throw NoActiveEmployeeFoundException.builder().message("No Active Employee Present in the Database..!").build();			
		} 
		
//		ArrayList<Employee> activeEmployees = new ArrayList<>();
//		for(Employee e : employees)
//		{
//			if(e.getStatus()==EmployeeStatus.ACTIVE)
//				activeEmployees.add(e);
//		}
		
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("All Active Employee Found..........").body(employees).build());		
			}

	public ResponseEntity<?> deleteEmployeeById(int id) 
	{
		Optional<Employee> optional = dao.findEmployeeById(id);
		if (optional.isEmpty()) 
		{
			throw InvalidEmployeeIdException.builder().message("Invalid Employee Id...,Unable to Delete..!").build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("Employee Deleted successfully..........").body("Empoyee deleted.........").build());
	}

	public ResponseEntity<?> findEmployeeByEmailAndPassword(String email, String password) {
		Optional<Employee> optional = dao.findEmploeeByEmailAndPassword(email, password);

		if (optional.isEmpty()) {
			throw InvalidCredentialException.builder().message("Invalid Credentials..!").build();
		}
		Employee employee = optional.get();
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("Verification Successfull.....................").body(employee).build());

	}

	public ResponseEntity<?> findEmployeeByname(String name) {
		List<Employee> employee = dao.findEmployeeByName(name);
//		ResponseStructure<List<Employee>> structure = new ResponseStructure<>();
		if (employee.isEmpty()) 
		{
//			throw new InvalidNameException("No Matching Employees Found for the Name Requested..!");
			throw NoEmployeeFoundException.builder().message("No Matching Employees Found for the Name Requested..!").build();  
		}
//		structure.setStatus(HttpStatus.OK.value());
//		structure.setMessage();
//		structure.setBody(employee);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("Employee found...............").body(employee).build());
	}

	public ResponseEntity<?> setEmployeeStatusToActive(int id) 
	{
		Optional<Employee> optional = dao.findEmployeeById(id);
		if(optional.isEmpty())
		{
//			structure.setStatus(HttpStatus.BAD_REQUEST.value());
//			structure.setMessage("Invalid Employee Id ..., Unable to make ACTIVE!");
//			structure.setBody(null);
//			return structure;
			
			throw InvalidEmployeeIdException.builder().message("Invalid Employee Id ..., Unable to make ACTIVE!").build();
		}
		Employee employee = optional.get();
		employee.setStatus(EmployeeStatus.ACTIVE);
		employee = dao.updateEmployee(employee);
		
//		structure.setStatus(HttpStatus.OK.value());
//		structure.setMessage();
//		structure.setBody(employee);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("Employee Status Updated to ACTIVE Successfully...!").body(employee).build());
	}

	public ResponseEntity<?> setEmployeeStatusToInactive(int id) {
		
		Optional<Employee> optional = dao.findEmployeeById(id);
		if(optional.isEmpty())
		{
			throw InvalidEmployeeIdException.builder().message("Invalid Employee Id ..., Unable to make INACTIVE!").build();
		}
		Employee employee = optional.get();
		employee.setStatus(EmployeeStatus.IN_ACTIVE);
		employee = dao.updateEmployee(employee);
		
//		structure.setStatus(HttpStatus.OK.value());
//		structure.setMessage("Employee Status Updated to INACTIVE Successfully...!");
//		structure.setBody(employee);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("Employee Status Updated to INACTIVE Successfully...!").body(employee).build());
	}

}
