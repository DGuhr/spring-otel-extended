package org.acme3.animalapp.repository;

import org.acme3.animalapp.model.Animal;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AnimalRepository {
    private final JdbcTemplate template;

    public AnimalRepository(JdbcTemplate template) {
        this.template = template;
    }

    public List<Animal> findAll() {
        return template.query("SELECT * FROM animals", (rs, rowNum) -> new Animal(rs.getLong("id"), rs.getString("name"), rs.getString("type")));
    }
}
