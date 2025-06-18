drop schema if exists partitions_test cascade;
create schema partitions_test;
SET search_path TO partitions_test;
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

create table if not exists  species_asia
    PARTITION OF species FOR VALUES IN ('Asia');

create table if not exists  species_africa
    PARTITION OF species FOR VALUES IN ('Africa');

create table if not exists  species_north_america
    PARTITION OF species FOR VALUES IN ('North America');

create table if not exists  species_south_america
    PARTITION OF species FOR VALUES IN ('South America');

create table if not exists  species_europe
    PARTITION OF species FOR VALUES IN ('Europe');

create table if not exists  species_australia
    PARTITION OF species FOR VALUES IN ('Australia');

create table if not exists  species_antarctica
    PARTITION OF species FOR VALUES IN ('Antarctica');

create table if not exists  pets
(
    id            bigint NOT NULL,
    name          varchar(255),
    sex           varchar(15),
    age           int,
    specie_id     bigint,
    partition_key varchar(255),
    PRIMARY KEY (id, partition_key)
) PARTITION BY LIST (partition_key);

create table if not exists  pets_asia
    PARTITION OF pets FOR VALUES IN ('Asia');

create table if not exists  pets_africa
    PARTITION OF pets FOR VALUES IN ('Africa');

create table if not exists  pets_north_america
    PARTITION OF pets FOR VALUES IN ('North America');

create table if not exists  pets_south_america
    PARTITION OF pets FOR VALUES IN ('South America');

create table if not exists  pets_europe
    PARTITION OF pets FOR VALUES IN ('Europe');

create table if not exists  pets_australia
    PARTITION OF pets FOR VALUES IN ('Australia');
create table if not exists  pets_antarctica
    PARTITION OF pets FOR VALUES IN ('Antarctica');

ALTER TABLE IF EXISTS pets
    ADD CONSTRAINT fk_pets_specie_id
    FOREIGN KEY (specie_id, partition_key)
    REFERENCES species;



-- Range partitions:
create table if not exists  people (
                       id BIGINT,
                       firstname VARCHAR(255),
                       lastname VARCHAR(255) NOT NULL,
                       PRIMARY KEY (lastname, id)
) PARTITION BY RANGE (lastname);

create table if not exists  people_a_m PARTITION OF people
    FOR VALUES FROM ('A') TO ('N');

create table if not exists  people_n_z PARTITION OF people
    FOR VALUES FROM ('N') TO ('Z');