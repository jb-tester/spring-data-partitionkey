package org.example.springdatapartitionkey.data.people;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PeopleRepository extends JpaRepository<People, Long> {


    List<People> findByLastname(String lastname);
    Optional<People> findByFirstnameAndLastname(String firstname, String lastname);
    List<People> findByFirstnameContainingIgnoreCase(String firstnamePattern);
    List<People> findByLastnameOrderByFirstnameAsc(String lastname);


    @Query("SELECT p FROM People p WHERE p.lastname = :lastname AND LOWER(p.firstname) LIKE LOWER(CONCAT('%', :firstnamePattern, '%'))")
    List<People> searchByLastnameAndFirstnamePattern(
            @Param("lastname") String lastname,
            @Param("firstnamePattern") String firstnamePattern
    );

    @Query("SELECT p FROM People p WHERE p.firstname = :firstname OR p.lastname = :lastname")
    List<People> findByFirstnameOrLastname(
            @Param("firstname") String firstname,
            @Param("lastname") String lastname
    );

    long countByLastname(String lastname);

    @Query("SELECT new org.example.springdatapartitionkey.data.people.PartitionCount(p.lastname, COUNT(p)) " +
           "FROM People p GROUP BY p.lastname ORDER BY p.lastname")
    List<PartitionCount> countByPartitions();


    boolean existsByFirstnameAndLastname(String firstname, String lastname);
}
