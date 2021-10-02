package com.pashin.pharmacyweb.repositories;

import com.pashin.pharmacyweb.entities.DrugInPharmacyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DrugInPharmacyRepository extends JpaRepository<DrugInPharmacyEntity, DrugInPharmacyEntity.DrugInPharmacyKey> {
}
