CREATE DATABASE master;

USE master;

CREATE TABLE USER (
  `idUSER` INT NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `lastName` VARCHAR(45) NOT NULL,
  `identificationNumber` VARCHAR(10) NOT NULL,
  `address` VARCHAR(45) NOT NULL,
  `zipCode` VARCHAR(6) NOT NULL,
  `city` VARCHAR(45) NOT NULL,
  `state` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idUSER`));

  INSERT INTO USER (`idUSER`, `username`, `name`, `lastName`, `identificationNumber`, `address`, `zipCode`, `city`, `state`) VALUES ('1', 'andgoca96','andres','gomez','1144090825', 'calle 4#79-20','760000','cali', 'valle del cauca');

  INSERT INTO USER (`idUSER`, `username`, `name`, `lastName`, `identificationNumber`, `address`, `zipCode`, `city`, `state`) VALUES ('2', 'ejemplo 1','ejemplo 1','ejemplo 1','1234567891','carrera 123', '760000', 'cali', 'valle del cauca');

  INSERT INTO USER (`idUSER`, `username`, `name`, `lastName`, `identificationNumber`, `address`, `zipCode`, `city`, `state`) VALUES ('3', 'ejemplo 2','ejemplo 2','ejemplo 2','1234567892','carrera 123', '760000', 'cali', 'valle del cauca');

  INSERT INTO USER (`idUSER`, `username`, `name`, `lastName`, `identificationNumber`, `address`, `zipCode`, `city`, `state`) VALUES ('4', 'ejemplo 3','ejemplo 3','ejemplo 3','1234567893','carrera 123', '760000', 'cali', 'valle del cauca');

  INSERT INTO USER (`idUSER`, `username`, `name`, `lastName`, `identificationNumber`, `address`, `zipCode`, `city`, `state`) VALUES ('5', 'ejemplo 4','ejemplo 4','ejemplo 4','1234567894','carrera 123', '760000', 'cali', 'valle del cauca');

  INSERT INTO USER (`idUSER`, `username`, `name`, `lastName`, `identificationNumber`, `address`, `zipCode`, `city`, `state`) VALUES ('6', 'ejemplo 5','ejemplo 5','ejemplo 5','1234567895','carrera 123', '760000', 'cali', 'valle del cauca');

  INSERT INTO USER (`idUSER`, `username`, `name`, `lastName`, `identificationNumber`, `address`, `zipCode`, `city`, `state`) VALUES ('7', 'ejemplo 6','ejemplo 6','ejemplo 6','1234567896','carrera 123', '760000', 'cali', 'valle del cauca');

  INSERT INTO USER (`idUSER`, `username`, `name`, `lastName`, `identificationNumber`, `address`, `zipCode`, `city`, `state`) VALUES ('8', 'ejemplo 7','ejemplo 7','ejemplo 7','1234567897','carrera 123', '760000', 'cali', 'valle del cauca');

  INSERT INTO USER (`idUSER`, `username`, `name`, `lastName`, `identificationNumber`, `address`, `zipCode`, `city`, `state`) VALUES ('9', 'ejemplo 8','ejemplo 8','ejemplo 8','1234567898','carrera 123', '760000', 'cali', 'valle del cauca');

  INSERT INTO USER (`idUSER`, `username`, `name`, `lastName`, `identificationNumber`, `address`, `zipCode`, `city`, `state`) VALUES ('10', 'ejemplo 9','ejemplo 9','ejemplo 9','1234567899','carrera 123', '760000', 'cali', 'valle del cauca');
