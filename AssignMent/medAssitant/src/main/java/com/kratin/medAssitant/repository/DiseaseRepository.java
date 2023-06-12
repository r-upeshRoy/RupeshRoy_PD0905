package com.kratin.medAssitant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kratin.medAssitant.entities.Disease;

public interface DiseaseRepository extends JpaRepository<Disease, Long>{

}
