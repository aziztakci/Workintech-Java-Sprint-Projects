package com.workintech.sqlrelations.repository;

import com.workintech.sqlrelations.entity.Nurse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NurseRepository extends JpaRepository<Nurse, Long> {
}
