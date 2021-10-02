package com.pashin.pharmacyweb.repository;

import com.pashin.pharmacyweb.model.PharmacyModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PharmacyRepository extends JpaRepository<PharmacyModel, Long> {
}
