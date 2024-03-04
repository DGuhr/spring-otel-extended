package org.acme4.animalapp.controller;

import org.acme4.animalapp.model.Animal;
import org.acme4.animalapp.service.AnimalComponent;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/animals")
public class AnimalController {

    private final AnimalComponent animalComponent;
    public AnimalController(AnimalComponent animalComponent) {
        this.animalComponent = animalComponent;
    }

    @GetMapping()
    public ResponseEntity<List<Animal>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(animalComponent.getAnimalsFromFooService());
    }
}
