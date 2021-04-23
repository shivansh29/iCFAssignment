package com.ICF.assignment.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ICF.assignment.Entity.Dependants;
import com.ICF.assignment.Repository.DependantRepository;

@Service
public class DependantService {

	@Autowired
	private DependantRepository dpdRepo;
	
	public void save(Dependants depen) {
		dpdRepo.save(depen);
	}
	
	public void delete(int id) {
		dpdRepo.deleteById(id);
	}
	
	public Optional<Dependants> get(int id) {
		return dpdRepo.findById(id);
	}
}
