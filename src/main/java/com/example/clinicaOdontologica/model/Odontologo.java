package com.example.clinicaOdontologica.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="Odontologo")
@Getter @Setter
public class Odontologo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String nombre;
    private String apellido;
    private Integer matricula;

    @OneToMany(mappedBy="odontologo")
    private Set<Turno> turnos;

    public Odontologo() {}
}
