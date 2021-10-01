package com.example.clinicaOdontologica.controller;

import com.example.clinicaOdontologica.dto.TurnoDTO;
import com.example.clinicaOdontologica.service.ITurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    @Autowired
    ITurnoService turnoService;

    @PostMapping()
    public ResponseEntity<?> addTurno(@RequestBody TurnoDTO t){
        turnoService.crearTurno(t);
        return ResponseEntity.ok(HttpStatus.OK);
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
