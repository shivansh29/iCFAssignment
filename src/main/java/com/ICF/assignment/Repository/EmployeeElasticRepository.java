package com.ICF.assignment.Repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.ICF.assignment.Entity.EmployeeElastic;

public interface EmployeeElasticRepository extends ElasticsearchRepository<EmployeeElastic, Integer> {

}
