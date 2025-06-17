package org.example.springdatapartitionkey;

import java.io.Serializable;
import java.util.Objects;

public class SpeciesId implements Serializable {
    private Long id;
    private String partitionKey;

    public SpeciesId() {
    }

    public SpeciesId(Long id, String partitionKey) {
        this.id = id;
        this.partitionKey = partitionKey;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpeciesId that = (SpeciesId) o;
        return Objects.equals(id, that.id) && Objects.equals(partitionKey, that.partitionKey);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, partitionKey);
    }
}
