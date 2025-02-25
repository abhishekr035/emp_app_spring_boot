package org.jsp.emp.Entity;

import org.hibernate.annotations.ManyToAny;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Education
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String qualification;
    private String universityName;
    private double percentage;
    private int completionYear;
    private String hishestQualification;
    @ManyToOne
    private Employee employee;
     

}
