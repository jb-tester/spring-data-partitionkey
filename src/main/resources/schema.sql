create table species
(
    id            bigint not null,
    name          varchar(30),
    binomial_name varchar(50),
    class         varchar(50),
    family        varchar(255),
    partition_key varchar(255),
    PRIMARY KEY (id, partition_key)
) PARTITION BY LIST (partition_key);

CREATE TABLE species_asia
    PARTITION OF species FOR VALUES IN ('Asia');

CREATE TABLE species_africa
    PARTITION OF species FOR VALUES IN ('Africa');

CREATE TABLE species_north_america
    PARTITION OF species FOR VALUES IN ('North America');

CREATE TABLE species_south_america
    PARTITION OF species FOR VALUES IN ('South America');

CREATE TABLE species_europe
    PARTITION OF species FOR VALUES IN ('Europe');

CREATE TABLE species_australia
    PARTITION OF species FOR VALUES IN ('Australia');

CREATE TABLE species_antarctica
    PARTITION OF species FOR VALUES IN ('Antarctica');

CREATE TABLE pets
(
    id            bigint NOT NULL,
    name          varchar(255),
    sex           varchar(15),
    age           int,
    specie_id     bigint,
    partition_key varchar(255),
    PRIMARY KEY (id, partition_key)
) PARTITION BY LIST (partition_key);

CREATE TABLE pets_asia
    PARTITION OF pets FOR VALUES IN ('Asia');

CREATE TABLE pets_africa
    PARTITION OF pets FOR VALUES IN ('Africa');

CREATE TABLE pets_north_america
    PARTITION OF pets FOR VALUES IN ('North America');

CREATE TABLE pets_south_america
    PARTITION OF pets FOR VALUES IN ('South America');

CREATE TABLE pets_europe
    PARTITION OF pets FOR VALUES IN ('Europe');

CREATE TABLE pets_australia
    PARTITION OF pets FOR VALUES IN ('Australia');
CREATE TABLE pets_antarctica
    PARTITION OF pets FOR VALUES IN ('Antarctica');

ALTER TABLE IF EXISTS pets
    ADD CONSTRAINT fk_pets_specie_id
    FOREIGN KEY (specie_id, partition_key)
    REFERENCES species;



-- Range partitions:
CREATE TABLE people (
                       id BIGINT,
                       firstname VARCHAR(255),
                       lastname VARCHAR(255) NOT NULL,
                       PRIMARY KEY (lastname, id)
) PARTITION BY RANGE (lastname);

CREATE TABLE people_a_m PARTITION OF people
    FOR VALUES FROM ('A') TO ('N');

CREATE TABLE people_n_z PARTITION OF people
    FOR VALUES FROM ('N') TO ('Z');