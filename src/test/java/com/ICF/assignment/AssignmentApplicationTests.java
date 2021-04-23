package com.ICF.assignment;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.ICF.assignment.Entity.Dependants;
import com.ICF.assignment.Entity.Employee;

@SpringBootTest
class AssignmentApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Test
	public void testcreateEmployee() throws URISyntaxException {
		
		RestTemplate restTemplate = new RestTemplate();
		
		final String baseUrl = "http://localhost:8559/api/employee";
	    URI uri = new URI(baseUrl);
	    
	    Employee emp=new Employee();
	    emp.setFirst_name("Shivansh");
	    emp.setLast_name("Bajpai");
	    HttpEntity<Employee> requestEntity = new HttpEntity<>(emp);
	    
	    ResponseEntity<String> result = restTemplate.postForEntity(uri,requestEntity, String.class);
	    
	    assertEquals(201, result.getStatusCodeValue());
	}
	
	@Test
	public void testcreateDependant() throws URISyntaxException {
		
		RestTemplate restTemplate = new RestTemplate();
		
		final String baseUrl = "http://localhost:8559/api/dependant";
	    URI uri = new URI(baseUrl);
	    
	    Dependants depen=new Dependants();
	    depen.setFirst_name("Shivansh");
	    depen.setLast_name("Bajpai");
	    HttpEntity<Dependants> requestEntity = new HttpEntity<>(depen);
	    
	    ResponseEntity<String> result = restTemplate.postForEntity(uri,requestEntity, String.class);
	    
	    assertEquals(201, result.getStatusCodeValue());
	}
	
	
	@Test
	public void testgetEmployees() throws URISyntaxException {
		
		RestTemplate restTemplate = new RestTemplate();
		
		final String baseUrl = "http://localhost:8559/api/employee/{id}";
	    URI uri = new URI(baseUrl);
	    
	    Employee emp=new Employee();
	    emp.setFirst_name("Shivansh");
	    emp.setLast_name("Bajpai");
	    HttpEntity<Employee> requestEntity = new HttpEntity<>(emp);
	    
	    ResponseEntity<Employee> result = restTemplate.getForEntity(uri, Employee.class);
	    
	    assertEquals(200, result.getStatusCodeValue());
	}
	
	

}
