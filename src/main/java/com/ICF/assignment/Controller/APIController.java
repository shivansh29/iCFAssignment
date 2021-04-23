package com.ICF.assignment.Controller;

import java.time.LocalDateTime;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ICF.assignment.DTO.EmployeeDTO;
import com.ICF.assignment.Entity.Employee;
import com.ICF.assignment.Services.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class APIController {

	
	private EmployeeService empService;
	private HttpServletRequest request;
	
	@Autowired
	public APIController(EmployeeService empService, HttpServletRequest request) {
		this.empService=empService;
		this.request=request;
	}
	
	Logger logger=LoggerFactory.getLogger(APIController.class);
	
	@PostMapping
	public ResponseEntity<Void> createEmployee(@RequestBody EmployeeDTO empDto) {
		System.out.println("\n \n \n \n \n Register Employee    \n \n ");
		
		Employee emp=convertDtotoEntity(empDto);
		
		empService.save(emp);
		
		loggingData();
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{empId}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable int empId) {
		System.out.println("\n \n \n \n \n Delete Employee    \n \n ");
		
		empService.delete(empId);
		loggingData();
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EmployeeDTO> getEmployees(@PathVariable int id){
		Employee emp=empService.get(id).get();
		
		EmployeeDTO empDto=convertEntityToDto(emp);
		
		return ResponseEntity.status(HttpStatus.OK).body(empDto);
	}
	
	@PutMapping
	public ResponseEntity<Void> updateEmployee(@RequestBody EmployeeDTO empDto){
		
		Employee emp=convertDtotoEntity(empDto);
		
		emp.setId(empDto.getId());
		empService.save(emp);
		
		loggingData();
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	void loggingData() {
		logger.info("IP Address is    -   "+request.getRemoteAddr());
		logger.info("Current Time is    -   "+LocalDateTime.now());
		logger.info("Client details are     -   "+request.getHeader("User-Agent"));
	}
	
	
	public EmployeeDTO convertEntityToDto(Employee emp) {

		EmployeeDTO empDto=new EmployeeDTO();
		
		empDto.setAddress(emp.getAddress());
		empDto.setBlood_group(emp.getBlood_group());
		empDto.setDepartment(emp.getDepartment());
		empDto.setDesignation(emp.getDesignation());
		empDto.setFirst_name(emp.getFirst_name());
		empDto.setGender(emp.getGender());
		empDto.setLast_name(emp.getLast_name());
		empDto.setReporting_manager(emp.getReporting_manager());
		empDto.setStatus(emp.getStatus());
		
		Date dob = new Date(emp.getDob().getTime());
		empDto.setDob(dob);
		Date startDate = new Date(emp.getStart_date().getTime());
		empDto.setStart_date(startDate);
		Date endDate = new Date(emp.getEnd_date().getTime());
		empDto.setEnd_date(endDate);
		
		
		return empDto;
	}
	
	
	public Employee convertDtotoEntity(EmployeeDTO empDto) {
		Employee emp=new Employee();
		emp.setAddress(empDto.getAddress());
		emp.setBlood_group(empDto.getBlood_group());
		emp.setDepartment(empDto.getDepartment());
		emp.setDesignation(empDto.getDesignation());
		Date dt=empDto.getDob();
		java.sql.Date sqlDate = new java.sql.Date(dt.getTime());
		emp.setDob(sqlDate);
		
		Date startDt=empDto.getStart_date();
		java.sql.Date startSqlDate = new java.sql.Date(startDt.getTime());
		emp.setStart_date(startSqlDate);
		
		
		Date endDt=empDto.getEnd_date();
		java.sql.Date endSqlDate = new java.sql.Date(endDt.getTime());
		emp.setEnd_date(endSqlDate);
		
		emp.setFirst_name(empDto.getFirst_name());
		emp.setGender(empDto.getGender());
		emp.setLast_name(empDto.getLast_name());
		emp.setReporting_manager(empDto.getReporting_manager());
		emp.setStatus(empDto.getStatus());
		return emp;
	}
}
