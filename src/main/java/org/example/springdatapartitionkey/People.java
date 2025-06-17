package org.example.springdatapartitionkey;

import jakarta.persistence.*;
import org.hibernate.annotations.PartitionKey;

@Entity
@Table(name = "people")
public class People {

	@Id
	private Long id;

	private String firstname;

    @PartitionKey
	private String lastname;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}