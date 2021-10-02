package com.pashin.pharmacyweb.repositories;

import com.pashin.pharmacyweb.entities.DrugEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DrugRepository extends JpaRepository<DrugEntity, Long> {
}
