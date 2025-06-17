package org.example.springdatapartitionkey.data.adresses;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.PartitionKey;

@Entity
@Table(name = "address")
public class Address extends PartitionAware<Address> {
    @Id
    @GeneratedValue
    private Integer id;

    private String city;
    private String street;




    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
