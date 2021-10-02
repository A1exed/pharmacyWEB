package com.pashin.pharmacyweb.repositories;

import com.pashin.pharmacyweb.entities.PharmacyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PharmacyRepository extends JpaRepository<PharmacyEntity, Long> {
}
