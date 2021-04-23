package com.ICF.assignment.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ICF.assignment.Entity.Dependants;

@Repository
public interface DependantRepository extends JpaRepository<Dependants, Integer> {

}
