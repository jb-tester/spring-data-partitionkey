package org.example.springdatapartitionkey.services;

import org.example.springdatapartitionkey.data.people.PartitionCount;
import org.example.springdatapartitionkey.data.people.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
