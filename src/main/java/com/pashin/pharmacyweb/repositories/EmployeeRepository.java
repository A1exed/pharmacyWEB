package com.pashin.pharmacyweb.repositories;

import com.pashin.pharmacyweb.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
}
