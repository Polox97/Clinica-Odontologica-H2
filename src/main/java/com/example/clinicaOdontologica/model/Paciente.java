package com.example.clinicaOdontologica.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name="Paciente")
@Getter @Setter
public class Paciente {
    @Id
    @GeneratedValue
    private Long id;

    private String nombre;
    private String apellido;
    private String domicilio;
    private Integer dni;
    private LocalDate fechaAlta;

    public Paciente() {
        this.fechaAlta = LocalDate.now();
    }
}
