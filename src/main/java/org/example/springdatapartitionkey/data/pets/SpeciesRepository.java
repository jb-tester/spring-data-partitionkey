package org.example.springdatapartitionkey.data.pets;

import org.springframework.data.repository.CrudRepository;


public interface SpeciesRepository extends CrudRepository<Species, SpeciesId> {
}
