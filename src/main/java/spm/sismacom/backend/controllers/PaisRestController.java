/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spm.sismacom.backend.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import spm.sismacom.backend.entidades.Pais;
import spm.sismacom.backend.interfaces.services.IPaisService;

/**
 *
 * @author SISMACOM
 */
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost"})
@RestController
@RequestMapping("/api")
public class PaisRestController {

    @Autowired
    private IPaisService paisService;

    @GetMapping("/pais/listartodos")
    public List<Pais> getAllUsers() {
        return paisService.findAll();
    }

    @GetMapping("/pais/buscarbyid/{id}")
    public Pais show(@PathVariable Integer id) {
        return paisService.findByID(id);
    }

    @PostMapping("/pais/nuevo")
    @ResponseStatus(HttpStatus.CREATED)
    public Pais create(@RequestBody Pais pais) {
        System.out.println("EL PAIS ES: " + pais);
        return paisService.save(pais);
    }

    @PutMapping("/pais/actualizar/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Pais update(@RequestBody Pais pais, @PathVariable Integer id) {
        //Pais usactual=service.findByID(id);
        return paisService.save(pais);
    }

    @DeleteMapping("/pais/eliminar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Integer id) {
        paisService.delete(id);
    }

}
