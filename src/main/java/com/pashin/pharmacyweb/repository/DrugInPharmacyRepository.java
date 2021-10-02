package com.pashin.pharmacyweb.repository;

import com.pashin.pharmacyweb.model.DrugInPharmacyModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrugInPharmacyRepository extends JpaRepository<DrugInPharmacyModel, DrugInPharmacyModel.DrugInPharmacyKey> {
}
