package com.ftn.backend.repository;

import com.ftn.backend.model.Transplatacija;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransplatacijaRepository extends JpaRepository<Transplatacija, Long> {
    List<Transplatacija> findAllByJmbg(String jmbg);
}
