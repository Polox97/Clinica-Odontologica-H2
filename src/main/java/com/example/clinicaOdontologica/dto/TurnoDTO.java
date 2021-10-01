package com.example.clinicaOdontologica.dto;

import com.example.clinicaOdontologica.model.Odontologo;
import com.example.clinicaOdontologica.model.Paciente;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.sql.Time;

@Getter @Setter
public class TurnoDTO {
    private Integer id;
    private Paciente paciente;
    private Odontologo odontologo;
    private String fecha;
    private String hora;
}
