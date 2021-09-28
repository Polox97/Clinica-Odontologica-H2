package com.example.clinicaOdontologica.service;
import com.example.clinicaOdontologica.model.OdontologoDTO;

import java.util.Collection;

public interface IOdontologoService {
    void crearOdontologo(OdontologoDTO o);
    OdontologoDTO buscarOdontologo(Long id);
    void actualizarOdontologo(OdontologoDTO o);
    void borrarOdontologo(Long id);

    Collection<OdontologoDTO> getAll();
}
