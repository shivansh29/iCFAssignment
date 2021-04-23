package com.ICF.assignment.Repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.ICF.assignment.Entity.DependantsElastic;

public interface DependantElasticRepository extends ElasticsearchRepository<DependantsElastic, Integer> {

}
