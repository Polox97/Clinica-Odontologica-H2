package com.example.clinicaOdontologica.controller;

import com.example.clinicaOdontologica.dto.TurnoDTO;
import com.example.clinicaOdontologica.model.Turno;
import com.example.clinicaOdontologica.service.IOdontologoService;
import com.example.clinicaOdontologica.service.IPacienteService;
import com.example.clinicaOdontologica.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    @Autowired
    TurnoService turnoService;
    @Autowired
    private IPacienteService pacienteService;
    @Autowired
    private IOdontologoService odontologoService;

    @PostMapping()
    public ResponseEntity<?> addTurno(@RequestBody Turno t){
        turnoService.crearTurno(t);
        return ResponseEntity.ok((HttpStatus.OK));
    }

    @GetMapping("/{id}")
    public TurnoDTO getTurno(@PathVariable Long id){
        return turnoService.buscarTurno(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTurno(@PathVariable Long id){
        ResponseEntity<String> response = null;

        if (turnoService.buscarTurno(id) != null) {
            turnoService.buscarTurno(id);
            response = ResponseEntity.status(HttpStatus.OK).body("Eliminado");
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return response;
    }

    @GetMapping("/list")
    public Collection<TurnoDTO> listTurnos(){
        return turnoService.getAll();
    }

}
