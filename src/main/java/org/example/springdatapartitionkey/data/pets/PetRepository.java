package org.example.springdatapartitionkey.data.pets;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface PetRepository extends CrudRepository<Pet, PetId> {


    @Query("SELECT p.species FROM Pet p WHERE p.name = :name")
    Species findSpeciesByName(@Param("name") String name);

}
