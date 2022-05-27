-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema tamagochi
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema tamagochi
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `tamagochi` DEFAULT CHARACTER SET utf8 ;
USE `tamagochi` ;

-- -----------------------------------------------------
-- Table `tamagochi`.`t_usuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tamagochi`.`t_usuarios` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user` VARCHAR(45) NOT NULL,
  `password` LONGTEXT NOT NULL,
  `token_security` TINYTEXT NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tamagochi`.`t_mascota`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tamagochi`.`t_mascota` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  `type` VARCHAR(45) NULL DEFAULT NULL,
  `color` VARCHAR(45) NULL DEFAULT NULL,
  `t_usuarios_id` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_t_mascota_t_usuarios_idx` (`t_usuarios_id` ASC) VISIBLE,
  CONSTRAINT `fk_t_mascota_t_usuarios`
    FOREIGN KEY (`t_usuarios_id`)
    REFERENCES `tamagochi`.`t_usuarios` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 10
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tamagochi`.`t_caracteristicas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tamagochi`.`t_caracteristicas` (
  `id` INT NOT NULL,
  `vida` INT NULL DEFAULT NULL,
  `sed` INT NULL DEFAULT NULL,
  `hambre` INT NULL DEFAULT NULL,
  `suciedad` INT NULL DEFAULT NULL,
  `t_mascota_id` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_t_caracteristicas_t_mascota1_idx` (`t_mascota_id` ASC) VISIBLE,
  CONSTRAINT `fk_t_caracteristicas_t_mascota1`
    FOREIGN KEY (`t_mascota_id`)
    REFERENCES `tamagochi`.`t_mascota` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
