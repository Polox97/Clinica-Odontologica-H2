package com.example.clinicaOdontologica.service;

import com.example.clinicaOdontologica.dto.PacienteDTO;

import java.util.Collection;

public interface IPacienteService {
    void crearPaciente(PacienteDTO p);
    PacienteDTO buscarPaciente(Long id);
    void actualizarPaciente(PacienteDTO p);
    void borrarPaciente(Long id);

    Collection<PacienteDTO> getAll();
}
