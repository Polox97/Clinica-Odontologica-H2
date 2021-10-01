package com.example.clinicaOdontologica.service;

import com.example.clinicaOdontologica.dto.TurnoDTO;

import java.util.Collection;

public interface ITurnoService {

    void crearTurno(TurnoDTO t);
    TurnoDTO buscarTurno(Long id);
    void actualizarTurno(TurnoDTO p);
    void borrarTurno(Long id);

    Collection<TurnoDTO> getAll();

}
