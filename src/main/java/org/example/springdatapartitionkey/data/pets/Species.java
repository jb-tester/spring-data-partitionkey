package org.example.springdatapartitionkey.data.pets;

import jakarta.persistence.*;
import org.hibernate.annotations.PartitionKey;
import java.util.Set;

@Entity
@Table(name = "species")
@IdClass(SpeciesId.class)
public class Species {
    @Id
    private Long id;

    @Id
    @PartitionKey
    @Column(name = "partition_key")
    private String partitionKey;

    @Column(length = 30)
    private String name;

    @Column(name = "binomial_name", length = 50)
    private String binomialName;

    @Column(name = "class", length = 50)
    private String speciesClass;

    private String family;

    @OneToMany(mappedBy = "species")
    private Set<Pet> pets;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPartitionKey() {
        return partitionKey;
    }

    public void setPartitionKey(String partitionKey) {
        this.partitionKey = partitionKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBinomialName() {
        return binomialName;
    }

    public void setBinomialName(String binomialName) {
        this.binomialName = binomialName;
    }

    public String getSpeciesClass() {
        return speciesClass;
    }

    public void setSpeciesClass(String speciesClass) {
        this.speciesClass = speciesClass;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }
}
