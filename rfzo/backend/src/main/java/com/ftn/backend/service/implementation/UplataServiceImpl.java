package com.ftn.backend.service.implementation;

import com.ftn.backend.dto.FirmaDTO;
import com.ftn.backend.dto.UplataDTO;
import com.ftn.backend.dto.ZaposleniDTO;
import com.ftn.backend.model.Uplata;
import com.ftn.backend.repository.UplataRepository;
import com.ftn.backend.service.APRService;
import com.ftn.backend.service.CROSOService;
import com.ftn.backend.service.UplataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class UplataServiceImpl implements UplataService {

    @Autowired
    UplataRepository uplataRepository;

    @Autowired
    CROSOService crosoService;

    @Override
    public List<Uplata> istorijaUplata(String pibIliJMBG) {
        if(pibIliJMBG == null || pibIliJMBG.isBlank() || pibIliJMBG.equals("null")){
            return uplataRepository.findAll();
        }
        return uplataRepository.findAllByRefFirmaPIBOrRefOsiguranikJMBG(pibIliJMBG, pibIliJMBG);
    }

    @Override
    public boolean proveraDaLiJeZdravstvenoOsiguran(String jmbg) throws ParseException {
        List<Uplata> sveUplate = uplataRepository.findAllByRefFirmaPIBOrRefOsiguranikJMBG(jmbg, jmbg);
        boolean zdravstvenoOsiguran = false;
        for(Uplata u:sveUplate){
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date datumUplate = formatter.parse(u.getVremeUplate());
            int uplataIzvrsenaPreXMeseci = monthsBetween(datumUplate, new Date());
            if(uplataIzvrsenaPreXMeseci < 3){
                zdravstvenoOsiguran = true;
            }
        }
        return zdravstvenoOsiguran;
    }

    @Override
    public void evidentirajUplatu(UplataDTO request) {
        Uplata u = new Uplata();
        u.setRefOsiguranik(request.getIdZaposleni());
        u.setRefFirma(request.getIdFirma());
        u.setUkupanIznosUplate(request.getIznos());
        u.setOdTogaZdravstvenoOsiguranje((int)(request.getIznos()*(30.0f/100.0f))); //30%
        u.setVremeUplate(request.getVremeUplate());
        ZaposleniDTO zaposleniDTO = crosoService.findById(request.getIdZaposleni());
        u.setRefFirmaPIB(zaposleniDTO.getRefPib());
        u.setRefOsiguranikJMBG(zaposleniDTO.getJmbg());
        uplataRepository.save(u);
    }


    public static int monthsBetween(Date d1, Date d2){
        if(d2==null || d1==null){
            return -1;//Error
        }
        Calendar m_calendar=Calendar.getInstance();
        m_calendar.setTime(d1);
        int nMonth1=12*m_calendar.get(Calendar.YEAR)+m_calendar.get(Calendar.MONTH);
        m_calendar.setTime(d2);
        int nMonth2=12*m_calendar.get(Calendar.YEAR)+m_calendar.get(Calendar.MONTH);
        return java.lang.Math.abs(nMonth2-nMonth1);
    }
}
