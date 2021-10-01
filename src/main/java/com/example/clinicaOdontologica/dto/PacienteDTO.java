package com.example.clinicaOdontologica.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter @Setter
public class PacienteDTO {
    private Integer id;
    private String nombre;
    private String apellido;
    private String domicilio;
    private String dni;
    private Date fechaAlta;
}
