package com.ftn.backend.repository;

import com.ftn.backend.model.Zaposleni;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ZaposleniRepository extends JpaRepository<Zaposleni, Long> {
    List<Zaposleni> findAllByJmbgOrRefPib(String jmbg, String pib);
}
