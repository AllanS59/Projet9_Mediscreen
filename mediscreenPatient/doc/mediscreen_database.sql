DROP DATABASE mediscreen;
CREATE DATABASE mediscreen;
USE mediscreen;

CREATE USER 'allan'@'localhost' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON mediscreen.* TO 'allan'@'localhost';


CREATE TABLE `patient` (
  `patient_Id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `family` VARCHAR(100) NOT NULL,
  `given` VARCHAR(100) NOT NULL,
  `dob` DATE NOT NULL,
  `sex` VARCHAR(1) NOT NULL,
  `address` VARCHAR(100),
  `phone` VARCHAR(20)
) ;
