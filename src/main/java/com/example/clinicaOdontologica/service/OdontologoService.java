package com.example.clinicaOdontologica.service;

import com.example.clinicaOdontologica.model.Odontologo;
import com.example.clinicaOdontologica.dto.OdontologoDTO;
import com.example.clinicaOdontologica.repository.IOdontologoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OdontologoService implements IOdontologoService{

    @Autowired
    IOdontologoRepository odontologoRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public void crearOdontologo(OdontologoDTO o) {
        Odontologo odontologo = mapper.convertValue(o, Odontologo.class);
        odontologoRepository.save(odontologo);
    }

    @Override
    public OdontologoDTO buscarOdontologo(Long id) {
        Optional<Odontologo> found = odontologoRepository.findById(id);
        return mapper.convertValue(found, OdontologoDTO.class);
    }

    @Override
    public void actualizarOdontologo(OdontologoDTO o) {
        Odontologo odontologo = mapper.convertValue(o, Odontologo.class);
        odontologoRepository.save(odontologo);
    }

    @Override
    public void borrarOdontologo(Long id) {
        odontologoRepository.deleteById(id);
    }

    @Override
    public Collection<OdontologoDTO> getAll() {
        List<Odontologo> todosOdontologos = odontologoRepository.findAll();
        Set<OdontologoDTO> todosOdontologosDTO = new HashSet<OdontologoDTO>();
        for(Odontologo odontologo: todosOdontologos)
            todosOdontologosDTO.add(mapper.convertValue(odontologo,OdontologoDTO.class));

        return todosOdontologosDTO;
    }
}
