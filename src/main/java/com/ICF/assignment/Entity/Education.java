package com.ICF.assignment.Entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
public class Education {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String type;
	private Date start_date;
	private Date end_date;
	
	@NotBlank(message = "Institution Name is mandatory")
	private String institution;
	
	@Size(min=5)
	@NotBlank(message = "Address is mandatory")
	private String address;
	private double percentage;
	
	 @ManyToOne()
		@JoinColumn(name="employee_emp_id")
		private Employee emp; 
}
