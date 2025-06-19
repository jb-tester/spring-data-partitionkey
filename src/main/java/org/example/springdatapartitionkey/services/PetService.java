package org.example.springdatapartitionkey.services;

import org.example.springdatapartitionkey.data.pets.Pet;
import org.example.springdatapartitionkey.data.pets.PetRepository;
import org.example.springdatapartitionkey.data.pets.Species;
import org.example.springdatapartitionkey.data.pets.SpeciesRepository;
import org.springframework.stereotype.Service;


@Service
public class PetService {


    private final PetRepository petRepository;
    private final SpeciesRepository speciesRepository;

    public PetService(PetRepository petRepository, SpeciesRepository speciesRepository) {
        this.petRepository = petRepository;
        this.speciesRepository = speciesRepository;
    }

    public void printAllPets() {
        System.out.println("====== all pets:  =======================");
        for (Pet pet : petRepository.findAll()) {
            System.out.println(pet);
        }
        System.out.println("=========================================");
    }

    public void printSpecieForPet() {
        System.out.println("====== specie for pet by its name: ======");
        System.out.println(petRepository.findSpeciesByName("Raja"));
        System.out.println("=========================================");
    }

    ;
    public void printAllSpecies() {
        System.out.println("====== all species:======================");
        for (Species species : speciesRepository.findAll()) {
            System.out.println(species);
        }
        System.out.println("=========================================");
    }

    public void printAllPetsBySpecieName() {
        System.out.println("====== pets by specie name(Kangaroo):====");
         speciesRepository.findPetsBySpeciesName("Kangaroo").forEach(System.out::println);
        System.out.println("=========================================");
    }

    public void printSpeciesByArealAndFamily() {
        System.out.println("====== species by areal and family: =====");
        speciesRepository.findSpeciesByFamilyOrAreal("Felidae", "Africa");
        System.out.println("===================");
    }


}
