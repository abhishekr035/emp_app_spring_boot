package org.jsp.emp.Dao;

import java.util.List;
import java.util.Optional;

import org.jsp.emp.Entity.Education;
import org.jsp.emp.Entity.Employee;
import org.jsp.emp.repository.EducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EducationDao 
{

	@Autowired
	private EducationRepository repository;
	
	public Education saveEducation(Education education) 
	{
		return repository.save(education);
	}

	public Education updateEducation(Education education) 
	{
		return repository.save(education);
	}

	public List<Education> findAllEducation() {
		return repository.findAllEducation();
	}

	public Optional<Employee> findEducationById(int id) 
	{
		return repository.findEducationById(id);
	}

}
