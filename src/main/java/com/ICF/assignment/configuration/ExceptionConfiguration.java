package com.ICF.assignment.configuration;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionConfiguration {

	 @ExceptionHandler(Exception.class)
	    protected ResponseEntity handleException(Exception ex) {
	       
		 return ResponseEntity
		            .badRequest()
		            .body("Exception occured inside API "+ex.getMessage());
	    }
}
