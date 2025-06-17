package org.example.springdatapartitionkey.data.pets;

import jakarta.persistence.*;
import org.hibernate.annotations.PartitionKey;

@Entity
@Table(name = "pets")
@IdClass(PetId.class)
public class Pet {
    @Id
    private Long id;

    @Id
    @PartitionKey
    @Column(name = "partition_key")
    private String partitionKey;

    private String name;
    private String sex;
    private Integer age;

    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "specie_id", referencedColumnName = "id"),
        @JoinColumn(name = "partition_key", referencedColumnName = "partition_key", insertable = false, updatable = false)
    })
    private Species species;


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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }
}
