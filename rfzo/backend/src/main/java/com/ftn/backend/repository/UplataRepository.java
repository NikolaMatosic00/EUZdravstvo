package com.ftn.backend.repository;

import com.ftn.backend.model.Uplata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UplataRepository extends JpaRepository<Uplata, Long> {
    List<Uplata> findAllByRefFirmaPIBOrRefOsiguranikJMBG(String pib, String jmbg);
}
