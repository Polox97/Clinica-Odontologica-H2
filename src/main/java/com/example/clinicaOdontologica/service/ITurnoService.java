package com.example.clinicaOdontologica.service;

import com.example.clinicaOdontologica.dto.TurnoDTO;
import com.example.clinicaOdontologica.model.Turno;

import java.util.Collection;

public interface ITurnoService {

    void crearTurno(Turno t);
    TurnoDTO buscarTurno(Long id);
    void actualizarTurno(TurnoDTO p);
    void borrarTurno(Long id);

    Collection<TurnoDTO> getAll();

}
