package com.ICF.assignment.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ICF.assignment.Entity.Education;

@Repository
public interface EducationRepository extends JpaRepository<Education, Integer> {

}
