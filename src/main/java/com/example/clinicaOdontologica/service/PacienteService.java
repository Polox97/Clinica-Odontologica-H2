package com.example.clinicaOdontologica.service;

import com.example.clinicaOdontologica.dto.PacienteDTO;
import com.example.clinicaOdontologica.model.Odontologo;
import com.example.clinicaOdontologica.model.Paciente;
import com.example.clinicaOdontologica.repository.IPacienteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PacienteService implements IPacienteService{

    @Autowired
    IPacienteRepository pacienteRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public void crearPaciente(PacienteDTO p) {
        Paciente paciente = mapper.convertValue(p, Paciente.class);
        pacienteRepository.save(paciente);
    }

    @Override
    public PacienteDTO buscarPaciente(Long id) {
        Optional<Paciente> found = pacienteRepository.findById(id);
        return mapper.convertValue(found, PacienteDTO.class);
    }

    @Override
    public void actualizarPaciente(PacienteDTO p) {
        Paciente paciente = mapper.convertValue(p, Paciente.class);
        pacienteRepository.save(paciente);
    }

    @Override
    public void borrarPaciente(Long id) {
        pacienteRepository.deleteById(id);
    }

    @Override
    public Collection<PacienteDTO> getAll() {
        List<Paciente> todosPacientes = pacienteRepository.findAll();
        Set<PacienteDTO> todosPacientesDTO = new HashSet<PacienteDTO>();
        for(Paciente paciente: todosPacientes)
            todosPacientesDTO.add(mapper.convertValue(paciente,PacienteDTO.class));

        return todosPacientesDTO;
    }
}
