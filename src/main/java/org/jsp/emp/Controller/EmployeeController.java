package org.jsp.emp.Controller;

import java.util.List;

import org.jsp.emp.Entity.Employee;
import org.jsp.emp.ResponseStructure.ResponseStructure;
import org.jsp.emp.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController 
{
	@Autowired
	private EmployeeService service;

	@PostMapping
	public ResponseEntity<?> saveEmployee(@RequestBody Employee employee) 
	{
		return service.saveEmployee(employee);
	}

	@PutMapping
	public ResponseEntity<?> updateEmployee(@RequestBody Employee employee) 
	{
		return service.updateEmployee(employee);
	}
	
	@GetMapping
	public ResponseEntity<?> findAllActiveEmployee() 
	{
		return service.findAllActiveEmployee();
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findEmployeeById(@PathVariable int id)
	{

		return service.findEmployeeById(id);
	}

	@GetMapping("/name/{name}")
	public ResponseEntity<?> findEmployeeByname(@PathVariable String name) 
	{

		return service.findEmployeeByname(name);
	}

	@GetMapping("/{email}/{password}")
	public ResponseEntity<?> findEmployeeByEmailAndPassword(@PathVariable String email,
			@PathVariable String password) 
	{
		return service.findEmployeeByEmailAndPassword(email, password);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> DeleteEmployeeByid(@PathVariable int id) 
	{
		return service.deleteEmployeeById(id);
	}
	
	@PatchMapping("/active/{id}")
	public ResponseEntity<?> setEmployeeStatusToActive(@PathVariable int id)
	{
		return service.setEmployeeStatusToActive(id);
	}
	
	@PatchMapping("/inactive/{id}")
	public ResponseEntity<?> setEmployeeStatusToInactive(@PathVariable int id)
	{
		return service.setEmployeeStatusToInactive(id);
	}

}
