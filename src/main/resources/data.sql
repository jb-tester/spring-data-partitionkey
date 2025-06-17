
-- insert some species data
INSERT INTO species (id, name, binomial_name, class, family, partition_key) VALUES
    (1, 'Siberian Husky', 'Canis lupus familiaris', 'Mammalia', 'Canidae', 'Asia'),
    (2, 'Bengal Tiger', 'Panthera tigris tigris', 'Mammalia', 'Felidae', 'Asia'),
    (3, 'African Lion', 'Panthera leo', 'Mammalia', 'Felidae', 'Africa'),
    (4, 'African Grey Parrot', 'Psittacus erithacus', 'Aves', 'Psittacidae', 'Africa'),
    (5, 'American Bald Eagle', 'Haliaeetus leucocephalus', 'Aves', 'Accipitridae', 'North America'),
    (6, 'Maine Coon', 'Felis catus', 'Mammalia', 'Felidae', 'North America'),
    (7, 'Andean Condor', 'Vultur gryphus', 'Aves', 'Cathartidae', 'South America'),
    (8, 'European Robin', 'Erithacus rubecula', 'Aves', 'Muscicapidae', 'Europe'),
    (9, 'Kangaroo', 'Macropus rufus', 'Mammalia', 'Macropodidae', 'Australia'),
    (10, 'Emperor Penguin', 'Aptenodytes forsteri', 'Aves', 'Spheniscidae', 'Antarctica');

-- insert some pets data
INSERT INTO pets (id, name, sex, age, specie_id, partition_key) VALUES
    (1, 'Luna', 'Female', 3, 1, 'Asia'),
    (2, 'Raja', 'Male', 5, 2, 'Asia'),
    (3, 'Simba', 'Male', 4, 3, 'Africa'),
    (4, 'Grey', 'Male', 2, 4, 'Africa'),
    (5, 'Freedom', 'Female', 6, 5, 'North America'),
    (6, 'Fluffy', 'Female', 4, 6, 'North America'),
    (7, 'Sky', 'Male', 8, 7, 'South America'),
    (8, 'Robin', 'Female', 1, 8, 'Europe'),
    (9, 'Skippy', 'Male', 3, 9, 'Australia'),
    (10, 'Happy', 'Male', 5, 10, 'Antarctica');



-- Insert people with lastnames A-M
INSERT INTO people (id, firstname, lastname) VALUES
                                                 (1, 'John', 'Anderson'),
                                                 (2, 'Mary', 'Brown'),
                                                 (3, 'James', 'Cooper'),
                                                 (4, 'Emma', 'Davis'),
                                                 (5, 'Michael', 'Johnson'),
                                                 (6, 'Sarah', 'King'),
                                                 (7, 'David', 'Lee'),
                                                 (8, 'Lisa', 'Miller');

-- Insert people with lastnames N-Z
INSERT INTO people (id, firstname, lastname) VALUES
                                                 (9, 'Robert', 'Nelson'),
                                                 (10, 'Patricia', 'O''Connor'),
                                                 (11, 'William', 'Parker'),
                                                 (12, 'Jennifer', 'Smith'),
                                                 (13, 'Richard', 'Thompson'),
                                                 (14, 'Elizabeth', 'Walker'),
                                                 (15, 'Thomas', 'Wilson'),
                                                 (16, 'Susan', 'Young');