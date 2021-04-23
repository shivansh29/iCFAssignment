package com.ICF.assignment.Entity;


import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	
	private transient int emp_id;
	
	@NotBlank(message = "First Name is mandatory")
	@Size(min=3)
	private String first_name;
	
	@NotBlank(message = "Last Name is mandatory")
	@Size(min=3)
	private String last_name;
	private Date start_date;
	private Date end_date;
	private String status;
	
	//@Past
	private Date dob;
	private String address;
	private String gender;
	private Designation designation;
	private Department department;
	private String reporting_manager;
	private String blood_group;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="emp",cascade= CascadeType.ALL)
	private List<Education> educations;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="personnel",cascade= CascadeType.ALL)
	private List<Dependants> dependants;
	
}
