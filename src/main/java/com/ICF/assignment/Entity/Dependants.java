package com.ICF.assignment.Entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Dependants {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@NotBlank(message = "First Name is mandatory")
	private String first_name;
	
	@NotBlank(message = "First Name is mandatory")
	private String last_name;
	private String gender;
	private String relationship;
	
	private Date dob;
	
	 @ManyToOne()
		@JoinColumn(name="employee_emp_id")
		private Employee personnel; 
}
