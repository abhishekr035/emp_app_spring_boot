package org.jsp.emp.Controller;

import org.jsp.emp.Entity.Education;
import org.jsp.emp.Service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/education")
public class EducationController 
{
	@Autowired
	private EducationService service;

	@PostMapping
	public ResponseEntity<?> saveEducation(@RequestBody Education education) 
	{
		return service.saveEducation(education);
	}
	
	@PutMapping
	public ResponseEntity<?> updateEmployee(@RequestBody Education education) 
	{
		return service.updateEducation(education);
	}
	
	@GetMapping
	public ResponseEntity<?> findAllEducation() 
	{
		return service.findAllEducation();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findEducationById(@PathVariable int id)
	{

		return service.findEducationById(id);
	}

}
