package com.ftn.backend.service;

import com.ftn.backend.dto.UplataDTO;
import com.ftn.backend.model.Uplata;

import java.text.ParseException;
import java.util.List;

public interface UplataService {

    List<Uplata> istorijaUplata(String pibIliJMBG);

    boolean proveraDaLiJeZdravstvenoOsiguran(String jmbg) throws ParseException;

    void evidentirajUplatu(UplataDTO request);

}
