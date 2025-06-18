package org.example.springdatapartitionkey.services;

import org.example.springdatapartitionkey.data.people.PartitionCount;
import org.example.springdatapartitionkey.data.people.People;
import org.example.springdatapartitionkey.data.people.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class PeopleService {
    @Autowired
    private PeopleRepository peopleRepository;
    
    public void printPartitionCounts() {
        List<PartitionCount> counts = peopleRepository.countByPartitions();
        for (PartitionCount count : counts) {
            System.out.printf("Partition '%s': %d people%n", 
                count.lastname(), count.count());
        }
    }
    public void printAllPeopleNames(){
        for (People p : peopleRepository.findAll()) {
            System.out.println(p.getFirstname() + " " + p.getLastname());
        }
    }
    public void printPeopleNamesByPartition(){
        List<Object[]> res = peopleRepository.countRowsInPartitions();
        res.forEach(row -> {
            System.out.printf("Partition '%s': %d entries%n",
                    row[0], row[1]);
        });
    }
}
