package com.ftn.backend.service;

import com.ftn.backend.dto.FirmaDTO;

public interface APRService {
    FirmaDTO[] izlistajFirme(String pib);

    void evidentirajFirmu(FirmaDTO request) throws Exception;

}
