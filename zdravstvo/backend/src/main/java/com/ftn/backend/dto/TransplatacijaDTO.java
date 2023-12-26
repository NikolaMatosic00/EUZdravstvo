package com.ftn.backend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransplatacijaDTO {
    private Long id;
    private String jmbg;
    private String komentar;

    @Override
    public String toString() {
        return "TransplatacijaDTO{" +
                "id=" + id +
                ", jmbg='" + jmbg + '\'' +
                ", komentar='" + komentar + '\'' +
                '}';
    }
}
