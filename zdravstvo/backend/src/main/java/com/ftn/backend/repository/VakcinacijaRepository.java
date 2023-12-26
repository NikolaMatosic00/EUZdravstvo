package com.ftn.backend.repository;

import com.ftn.backend.model.Vakcinacija;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VakcinacijaRepository extends JpaRepository<Vakcinacija, Long> {

    @Query("SELECT vak FROM Vakcinacija vak ORDER BY vak.vremeVakcinisanja DESC")
    List<Vakcinacija> findAllOrderByVremeVakcinisanjaDesc();

    @Query("SELECT vak FROM Vakcinacija vak WHERE vak.osiguranik.jmbg = ?1 ORDER BY vak.vremeVakcinisanja DESC")
    List<Vakcinacija> findAllByOsiguranikJmbgOrderByVremeVakcinisanjaDesc(String jmbg);




}
