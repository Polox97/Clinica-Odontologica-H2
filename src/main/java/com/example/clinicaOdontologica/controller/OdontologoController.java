package com.example.clinicaOdontologica.controller;

import com.example.clinicaOdontologica.dto.OdontologoDTO;
import com.example.clinicaOdontologica.service.IOdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {
    @Autowired
    IOdontologoService odontologoService;

    @PostMapping()
    public ResponseEntity<?> addOdontologo(@RequestBody OdontologoDTO o) {
        odontologoService.crearOdontologo(o);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public OdontologoDTO getOdontologo(@PathVariable Long id) {
        return odontologoService.buscarOdontologo(id);
    }

    @PutMapping()
    public ResponseEntity<?> actualizarOdontologo(@RequestBody OdontologoDTO o) {
        odontologoService.actualizarOdontologo(o);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeStudent(@PathVariable Long id) {

        ResponseEntity<String> response = null;

        if (odontologoService.buscarOdontologo(id) != null) {
            odontologoService.borrarOdontologo(id);
            response = ResponseEntity.status(HttpStatus.OK).body("Eliminado");
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return response;
    }

    @GetMapping("/list")
    public Collection<OdontologoDTO> listStudents() {
        return odontologoService.getAll();
    }

}
