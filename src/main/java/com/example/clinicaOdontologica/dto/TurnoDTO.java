package com.example.clinicaOdontologica.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.sql.Time;

@Getter @Setter
public class TurnoDTO {
    private Long id;
    private Long id_paciente;
    private Long id_odontologo;
    private Date fecha;
    private Time hora;
}
