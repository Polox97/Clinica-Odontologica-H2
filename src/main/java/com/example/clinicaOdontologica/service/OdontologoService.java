package com.example.clinicaOdontologica.service;

import com.example.clinicaOdontologica.model.OdontologoDTO;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class OdontologoService implements IOdontologoService{
    @Override
    public void crearOdontologo(OdontologoDTO o) {
        
    }

    @Override
    public OdontologoDTO buscarOdontologo(Long id) {
        return null;
    }

    @Override
    public void actualizarOdontologo(OdontologoDTO o) {

    }

    @Override
    public void borrarOdontologo(Long id) {

    }

    @Override
    public Collection<OdontologoDTO> getAll() {
        return null;
    }
}
