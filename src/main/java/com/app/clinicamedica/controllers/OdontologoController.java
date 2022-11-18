package com.app.clinicamedica.controllers;


import com.app.clinicamedica.models.Odontologo;
import com.app.clinicamedica.services.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping("/odontologo")
public class OdontologoController {

    private final OdontologoService odontologoService;

    @Autowired
    public OdontologoController(OdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }

    @PostMapping
    public Odontologo create(@RequestBody Odontologo odontologo) throws SQLException, ClassNotFoundException {
        return odontologoService.guardarOdontologo(odontologo);
    }
}
