package org.acme2.animalapp.service;

import org.acme2.animalapp.model.Animal;
import org.acme2.animalapp.repository.AnimalRepository;
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