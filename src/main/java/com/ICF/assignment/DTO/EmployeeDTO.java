package com.ICF.assignment.DTO;

import java.util.Date;
import java.util.List;


import com.ICF.assignment.Entity.Department;
import com.ICF.assignment.Entity.Designation;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class EmployeeDTO {

	private int id;
	
	private String first_name;
	private String last_name;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	private Date start_date;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	private Date end_date;
	private String status;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	private Date dob;
	private String address;
	private String gender;
	private Designation designation;
	private Department department;
	private String reporting_manager;
	private String blood_group;
	
	private List<EducationDTO> educations;
	
	private List<DependantsDTO> dependants;
}
