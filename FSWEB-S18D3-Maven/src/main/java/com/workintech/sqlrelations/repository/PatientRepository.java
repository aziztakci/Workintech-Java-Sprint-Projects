package com.workintech.sqlrelations.repository;

import com.workintech.sqlrelations.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
