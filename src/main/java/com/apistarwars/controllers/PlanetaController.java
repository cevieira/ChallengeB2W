package com.apistarwars.controllers;

import com.apistarwars.entity.Planeta;
import com.apistarwars.services.PlanetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.List;


@RestController
@RequestMapping(value = "/planeta")
public class PlanetaController {

    @Autowired
    private PlanetaService service;

    @GetMapping(value = "/")
    public ResponseEntity<List<Planeta>> findAll(){
        List<Planeta> lista = service.findAll();
        return ResponseEntity.ok().body(lista);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Planeta> findById(@PathVariable String id){
        Planeta planeta = service.findById(id);
        return ResponseEntity.ok().body(planeta);
    }

    @GetMapping(value = "/name/{nome}")
    public ResponseEntity<Planeta> findByNome(@PathVariable String nome){
        Planeta planeta = service.findByNome(nome);
        return ResponseEntity.ok().body(planeta);
    }

    @PostMapping(value = "/")
    public ResponseEntity<Void> gravar(@RequestBody Planeta planeta){
        planeta = service.gravar(planeta);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id").buildAndExpand(planeta.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable String id) {
        service.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/name/{nome}")
    public ResponseEntity<Void> deletarPorNome(@PathVariable String nome) {
        service.deletarPorNome(nome);
        return ResponseEntity.noContent().build();
    }




}
