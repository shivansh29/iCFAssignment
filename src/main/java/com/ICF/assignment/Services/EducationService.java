package com.ICF.assignment.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ICF.assignment.Entity.Education;
import com.ICF.assignment.Repository.EducationRepository;

@Service
public class EducationService {

	@Autowired	
	private EducationRepository eduRepo;
	
	public void save(Education edu) {
		eduRepo.save(edu);
	}
	
	public void delete(int id) {
		eduRepo.deleteById(id);
	}
	
	public Optional<Education> get(int id) {
		return eduRepo.findById(id);
	}
}
