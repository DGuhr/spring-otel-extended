package org.acme3.animalapp.controller;

import org.acme3.animalapp.model.Animal;
import org.acme3.animalapp.service.AnimalComponent;
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

    //for demo purposes: @Controller calls @Component calls @Service calls @Repository calls db.
    @GetMapping()
    public List<Animal> findAll() {
        return animalComponent.getAnimalsFromFooService();
    }
}
