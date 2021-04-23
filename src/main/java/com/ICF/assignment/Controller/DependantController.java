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

import com.ICF.assignment.DTO.DependantsDTO;
import com.ICF.assignment.Entity.Dependants;
import com.ICF.assignment.Services.DependantService;
import com.ICF.assignment.Services.EmployeeService;

@RestController
@RequestMapping("/api/dependant")
public class DependantController {

	private DependantService dependantService;
	private HttpServletRequest request;	
	private EmployeeService empService;
	
	Logger logger=LoggerFactory.getLogger(DependantController.class);
	
	@Autowired
	public DependantController(DependantService dependantService,EmployeeService empService, HttpServletRequest request) {
		this.dependantService=dependantService;
		this.empService=empService;
		this.request=request;
	}
	
	@PostMapping("/{id}")
	public ResponseEntity<Void> createDependant(@RequestBody DependantsDTO dependantDto,@PathVariable int id){
		
		Dependants depen=convertDtoToEntity(dependantDto);

		depen.setPersonnel(empService.get(id).get());
		dependantService.save(depen);
		loggingData();
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	

	@DeleteMapping("/{dpnId}")
	public ResponseEntity<Void> deleteDependant(@PathVariable int dpnId) {
		System.out.println("\n \n \n \n \n Delete dependant    \n \n ");
		
		dependantService.delete(dpnId);
		loggingData();
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DependantsDTO> getAllDependants(@PathVariable int id){
		Dependants dpd=dependantService.get(id).get();
		
		DependantsDTO dpnDto=convertEntityToDto(dpd);
		
		return ResponseEntity.status(HttpStatus.OK).body(dpnDto);
	}
	
	@PutMapping
	public ResponseEntity<Void> updateEmployee(@RequestBody DependantsDTO dpnDto){
		
		Dependants dpn=convertDtoToEntity(dpnDto);
		
		dpn.setId(dpnDto.getId());
		dependantService.save(dpn);
		loggingData();
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	void loggingData() {
		logger.info("IP Address is    -   "+request.getRemoteAddr());
		logger.info("Current Time is    -   "+LocalDateTime.now());
		logger.info("Client details are     -   "+request.getHeader("User-Agent"));
	}
	
	
	 Dependants convertDtoToEntity(DependantsDTO dto) {
		Dependants dpd=new Dependants();
		dpd.setFirst_name(dto.getFirst_name());
		dpd.setGender(dto.getGender());
		dpd.setLast_name(dto.getLast_name());
		dpd.setRelationship(dto.getRelationship());
		
		Date dob=dto.getDob();
		java.sql.Date sqlDob = new java.sql.Date(dob.getTime());
		dpd.setDob(sqlDob);
		
		
		return dpd;
	}
	 
	 
	 DependantsDTO convertEntityToDto(Dependants dt) {
		 DependantsDTO dto=new DependantsDTO();
		 
		 dto.setFirst_name(dt.getFirst_name());
		 dto.setGender(dt.getGender());
		 dto.setLast_name(dt.getLast_name());
		 dto.setRelationship(dt.getRelationship());
		 dto.setId(dt.getId());
		 
		 Date dob = new Date(dt.getDob().getTime());
			dto.setDob(dob);
		 
		 return dto;
	 }
}
