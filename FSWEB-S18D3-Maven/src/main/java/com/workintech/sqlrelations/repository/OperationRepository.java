package com.workintech.sqlrelations.repository;

import com.workintech.sqlrelations.entity.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationRepository extends JpaRepository<Operation, Long> {
}
