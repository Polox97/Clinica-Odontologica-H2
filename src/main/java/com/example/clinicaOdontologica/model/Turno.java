package com.example.clinicaOdontologica.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name="Turno")
@Getter @Setter
public class Turno {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name="paciente_id")
    private Paciente paciente;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name="odontologo_id")
    private Odontologo odontologo;

    private String fecha;
    private String hora;

    public Turno(){}

    public Turno(Paciente paciente, Odontologo odontologo, String fecha, String hora) {
        this.paciente = paciente;
        this.odontologo = odontologo;
        this.fecha = fecha;
        this.hora = hora;
    }
}
