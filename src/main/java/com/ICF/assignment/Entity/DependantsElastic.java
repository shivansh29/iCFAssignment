package com.ICF.assignment.Entity;

import java.sql.Date;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@org.springframework.data.elasticsearch.annotations.Document(indexName="shivansh")
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class DependantsElastic {

	@org.springframework.data.annotation.Id
	@javax.persistence.Transient
	private int elasticId;
	
	@NotBlank(message = "First Name is mandatory")
	private String first_name;
	
	@NotBlank(message = "First Name is mandatory")
	private String last_name;
	private String gender;
	private String relationship;
	
	private Date dob;
	
	 @ManyToOne()
		@JoinColumn(name="employee_elastic_emp_id")
		private EmployeeElastic personnel; 
}
