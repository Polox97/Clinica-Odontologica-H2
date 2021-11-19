package com.example.clinicaOdontologica.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Paciente")
@Getter @Setter
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;
    private String apellido;
    private String domicilio;
    private Integer dni;

    @Basic
    @CreationTimestamp
    private Date fechaAlta;

    @OneToMany(mappedBy="paciente", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Turno> turno = new HashSet<>();

    public Paciente() {}
}
