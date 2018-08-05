CREATE TABLE vehicle (
    id  INTEGER NOT NULL AUTO_INCREMENT,
    vin VARCHAR(17) NOT NULL,
    brand VARCHAR(2) NOT NULL,
    model VARCHAR(50),
    year VARCHAR(4),
    color VARCHAR(10),
    price Int,
    PRIMARY KEY (id)
);

