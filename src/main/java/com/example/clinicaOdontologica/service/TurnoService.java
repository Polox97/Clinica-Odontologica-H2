package com.example.clinicaOdontologica.service;

import com.example.clinicaOdontologica.dto.PacienteDTO;
import com.example.clinicaOdontologica.dto.TurnoDTO;
import com.example.clinicaOdontologica.model.Paciente;
import com.example.clinicaOdontologica.model.Turno;
import com.example.clinicaOdontologica.repository.IPacienteRepository;
import com.example.clinicaOdontologica.repository.ITurnoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TurnoService implements ITurnoService{

    @Autowired
    ITurnoRepository turnoRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public void crearTurno(TurnoDTO t) {
        Turno turno = mapper.convertValue(t, Turno.class);
        turnoRepository.save(turno);
    }

    @Override
    public TurnoDTO buscarTurno(Long id) {
        Optional<Turno> found = turnoRepository.findById(id);
        return mapper.convertValue(found, TurnoDTO.class);
    }

    @Override
    public void actualizarTurno(TurnoDTO p) {

    }

    @Override
    public void borrarTurno(Long id) {
        turnoRepository.deleteById(id);
    }

    @Override
    public Collection<TurnoDTO> getAll() {
        List<Turno> todosTurnos = turnoRepository.findAll();
        Set<TurnoDTO> todosTurnoDTO = new HashSet<TurnoDTO>();
        for(Turno turno: todosTurnos)
            todosTurnoDTO.add(mapper.convertValue(turno,TurnoDTO.class));

        return todosTurnoDTO;
    }
}
