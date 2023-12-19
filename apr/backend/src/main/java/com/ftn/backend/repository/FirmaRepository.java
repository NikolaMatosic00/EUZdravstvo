package com.ftn.backend.repository;

import com.ftn.backend.model.Firma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FirmaRepository extends JpaRepository<Firma, Long> {
    List<Firma> findAllByPib(String pib);
}
