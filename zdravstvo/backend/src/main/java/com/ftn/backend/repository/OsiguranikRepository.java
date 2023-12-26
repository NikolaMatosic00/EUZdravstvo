package com.ftn.backend.repository;

import com.ftn.backend.model.Osiguranik;
import com.ftn.backend.model.Vakcina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OsiguranikRepository extends JpaRepository<Osiguranik, Long> {
    Osiguranik findByJmbg(String jmbg);
}
