package com.example.clinicaOdontologica.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="Paciente")
@Getter @Setter
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String nombre;
    private String apellido;
    private String domicilio;
    private Integer dni;

    @Basic
    @CreationTimestamp
    private Date fechaAlta;

    @OneToMany(mappedBy="paciente")
    private Set<Turno> turno;

    public Paciente() {}
}
