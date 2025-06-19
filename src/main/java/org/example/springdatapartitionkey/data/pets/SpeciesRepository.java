package org.example.springdatapartitionkey.data.pets;

import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;


public interface SpeciesRepository extends CrudRepository<Species, SpeciesId> {
    @Query("SELECT s.pets FROM Species s WHERE s.name = :name")
    Set<Pet> findPetsBySpeciesName(@Param("name") String name);

    @NativeQuery("""
            select * from species
            where family = :name
            and partition_key = :partitionKey
            """)
    List<Species> findSpeciesByFamilyOrAreal(String name, String partitionKey);
}
