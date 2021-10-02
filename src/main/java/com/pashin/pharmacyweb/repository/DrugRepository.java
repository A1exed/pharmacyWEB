package com.pashin.pharmacyweb.repository;

import com.pashin.pharmacyweb.model.DrugModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrugRepository extends JpaRepository<DrugModel, Long> {
}
