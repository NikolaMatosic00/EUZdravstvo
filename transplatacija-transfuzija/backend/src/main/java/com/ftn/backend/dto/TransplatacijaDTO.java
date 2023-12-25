package com.ftn.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
