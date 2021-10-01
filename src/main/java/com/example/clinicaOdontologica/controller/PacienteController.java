package com.example.clinicaOdontologica.controller;

import com.example.clinicaOdontologica.dto.PacienteDTO;
import com.example.clinicaOdontologica.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    IPacienteService pacienteService;

    @PostMapping()
    public ResponseEntity<?> addOdontologo(@RequestBody PacienteDTO p) {
        pacienteService.crearPaciente(p);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public PacienteDTO getOdontologo(@PathVariable Long id) {
        return pacienteService.buscarPaciente(id);
    }

    @PutMapping()
    public ResponseEntity<?> modifyStudent(@RequestBody PacienteDTO p) {
        pacienteService.actualizarPaciente(p);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeStudent(@PathVariable Long id) {

        ResponseEntity<String> response = null;

        if (pacienteService.buscarPaciente(id) != null) {
            pacienteService.borrarPaciente(id);
            response = ResponseEntity.status(HttpStatus.OK).body("Eliminado");
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return response;
    }

    @GetMapping("/list")
    public Collection<PacienteDTO> listStudents() {
        return pacienteService.getAll();
    }
}
