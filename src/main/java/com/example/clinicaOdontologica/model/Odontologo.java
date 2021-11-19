package com.example.clinicaOdontologica.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Odontologo")
@Getter @Setter
public class Odontologo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;
    private String apellido;
    private Integer matricula;

    @OneToMany(mappedBy="odontologo", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Turno> turnos = new HashSet<>();

    public Odontologo() {}
}
