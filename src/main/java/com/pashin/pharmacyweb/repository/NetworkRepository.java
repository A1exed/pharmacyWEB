package com.pashin.pharmacyweb.repository;

import com.pashin.pharmacyweb.model.NetworkModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NetworkRepository extends JpaRepository<NetworkModel, Long> {
}
