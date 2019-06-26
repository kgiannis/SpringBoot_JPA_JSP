--<ScriptOptions statementTerminator=";"/>

CREATE TABLE `spring_db`.`person` (
	`ID` BIGINT NOT NULL AUTO_INCREMENT,
	`Name` VARCHAR(50),
	`Surname` VARCHAR(50),
	`Age` INT,
	PRIMARY KEY (`ID`)
) ENGINE=InnoDB;

