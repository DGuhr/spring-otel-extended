package org.acme3.animalapp.service;

import org.acme3.animalapp.model.Animal;
import org.acme3.animalapp.repository.AnimalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalFooService {
    private final AnimalRepository animalRepository;

    public AnimalFooService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public List<Animal> findAnimalsInDb() {
        return animalRepository.findAll();
    }
}