package com.example.clinicaOdontologica.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name="Turno")
@Getter @Setter
public class Turno {
    @Id
    @GeneratedValue
    private Long id;
    
    private Long id_paciente;
    private Long id_odontologo;
    private Date fecha;
    private Time hora;

    public Turno(){}
}
