package org.jsp.emp.repository;

import java.util.List;
import java.util.Optional;

import org.jsp.emp.Entity.Education;
import org.jsp.emp.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EducationRepository extends JpaRepository<Education, Integer> 
{
    @Query("select e from Education e")
	List<Education> findAllEducation();

	Optional<Employee> findEducationById(int id);


}
