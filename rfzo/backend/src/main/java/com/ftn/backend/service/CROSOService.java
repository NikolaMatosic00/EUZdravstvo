package com.ftn.backend.service;

import com.ftn.backend.dto.ZaposleniDTO;

public interface CROSOService {
    ZaposleniDTO[] izlistajOsiguranike(String pibIliJMBG);

    void evidentirajZaposlenog(ZaposleniDTO request) throws Exception;

    ZaposleniDTO findById(Long id);
}
