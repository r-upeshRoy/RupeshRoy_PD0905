package com.kratin.medAssitant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kratin.medAssitant.entities.Medicine;

public interface MedicineRepository extends JpaRepository<Medicine, Long>{

}
