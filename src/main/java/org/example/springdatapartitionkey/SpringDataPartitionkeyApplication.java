package org.example.springdatapartitionkey;

import org.example.springdatapartitionkey.services.PeopleService;
import org.example.springdatapartitionkey.services.PetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringDataPartitionkeyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataPartitionkeyApplication.class, args);
    }

        @Bean
            public CommandLineRunner commandLineRunner(PeopleService peopleService, PetService petService) {
                return args -> {
                    System.out.println("--------------------------------------");
                    peopleService.printPartitionCounts();
                    System.out.println("--------------------------------------");
                    peopleService.printAllPeopleNames();
                    System.out.println("--------------------------------------");
                    peopleService.printPeopleNamesByPartition();
                    System.out.println("--------------------------------------");
                    petService.printAllPets();
                    petService.printSpecieForPet();
                    petService.printAllPetsBySpecieName();
                    petService.printAllSpecies();
                    petService.printSpeciesByArealAndFamily();
                };
            }
}
