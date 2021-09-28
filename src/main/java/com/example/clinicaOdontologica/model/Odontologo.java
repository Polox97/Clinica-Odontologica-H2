package com.example.clinicaOdontologica.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Odontologo")
@Getter @Setter
public class Odontologo {
    @Id
    @GeneratedValue
    private Long id;

    private String nombre;
    private String apellido;
    private Integer matricula;

    public Odontologo() {}
}
