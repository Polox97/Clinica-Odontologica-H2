package com.example.clinicaOdontologica.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class OdontologoDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private Integer matricula;
}
