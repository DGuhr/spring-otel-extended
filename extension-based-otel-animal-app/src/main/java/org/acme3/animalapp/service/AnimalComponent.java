package org.acme3.animalapp.service;

import org.acme3.animalapp.model.Animal;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AnimalComponent {

    private final AnimalFooService animalFooService;

    public AnimalComponent(AnimalFooService animalFooService) {
        this.animalFooService = animalFooService;
    }

    public List<Animal> getAnimalsFromFooService(){
        return animalFooService.findAnimalsInDb();
    }
}