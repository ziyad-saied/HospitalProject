CREATE TABLE patient
(
    `p-id`        INT AUTO_INCREMENT NOT NULL,
    name          VARCHAR(255) NULL,
    gender        VARCHAR(255) NULL,
    age           INT NULL,
    date_of_birth datetime NULL,
    mob_no        INT NULL,
    CONSTRAINT pk_patient PRIMARY KEY (`p-id`)
);