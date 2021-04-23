package com.ICF.assignment.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ICF.assignment.Entity.Employee;
import com.ICF.assignment.Repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository empRepo;
	
	public void save(Employee emp) {
		empRepo.save(emp);
	}
	
	public void delete(int id) {
		empRepo.deleteById(id);
	}
	
	public Optional<Employee> get(int id) {
		return empRepo.findById(id);
	}
	
}
