package org.acme.animalapp.service;

import org.acme.animalapp.model.Animal;
import org.acme.animalapp.repository.AnimalRepository;
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