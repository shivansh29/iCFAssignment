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

import com.ICF.assignment.DTO.EducationDTO;
import com.ICF.assignment.Entity.Education;
import com.ICF.assignment.Services.EducationService;

@RestController
@RequestMapping("/api/education")
public class EducationController {

	private EducationService edService;
	private HttpServletRequest request;
	
	Logger logger=LoggerFactory.getLogger(EducationController.class);
	
	@Autowired
	public EducationController(EducationService edService,HttpServletRequest request) {
		this.edService=edService;
		this.request=request;
	}
	
	@PostMapping("/{id}")
	public ResponseEntity<Void> createEducation(@RequestBody EducationDTO eduDto,@PathVariable int id){
		
		Education edu=convertDtoToEntity(eduDto);

		edService.save(edu);
		loggingData();
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	
	@DeleteMapping("/{eduId}")
	public ResponseEntity<Void> deleteEducation(@PathVariable int eduId) {
		
		edService.delete(eduId);
		loggingData();
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EducationDTO> getAllDependants(@PathVariable int id){
		Education edu=edService.get(id).get();
		
		EducationDTO dpnDto=convertEntityToDto(edu);
		
		return ResponseEntity.status(HttpStatus.OK).body(dpnDto);
	}
	
	
	
	@PutMapping
	public ResponseEntity<Void> updateEmployee(@RequestBody EducationDTO eduDto){
		
		Education edu=convertDtoToEntity(eduDto);
		
		edu.setId(eduDto.getId());
		edService.save(edu);
		loggingData();
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	void loggingData() {
		logger.info("IP Address is    -   "+request.getRemoteAddr());
		logger.info("Current Time is    -   "+LocalDateTime.now());
		logger.info("Client details are     -   "+request.getHeader("User-Agent"));
	}
	
	Education convertDtoToEntity(EducationDTO eduDto) {
		Education edu = new Education();
		edu.setAddress(eduDto.getAddress());
		edu.setInstitution(eduDto.getInstitution());
		edu.setPercentage(eduDto.getPercentage());
		edu.setType(eduDto.getType());
		
		Date startDate=eduDto.getStart_date();
		java.sql.Date startSql = new java.sql.Date(startDate.getTime());
		edu.setStart_date(startSql);
		
		Date endDate=eduDto.getEnd_date();
		java.sql.Date endSql = new java.sql.Date(endDate.getTime());
		edu.setEnd_date(endSql);
		
		return edu;
	}
	
	EducationDTO convertEntityToDto(Education edu) {
		EducationDTO eduDto = new EducationDTO();
		
		eduDto.setAddress(edu.getAddress());
		eduDto.setId(edu.getId());
		eduDto.setInstitution(edu.getInstitution());
		eduDto.setPercentage(edu.getPercentage());
		eduDto.setType(edu.getType());
		
		Date startDate = new Date(edu.getStart_date().getTime());
		eduDto.setStart_date(startDate);
		
		Date endDate= new Date(edu.getEnd_date().getTime());
		eduDto.setEnd_date(endDate);
		
		return eduDto;
	}
}
