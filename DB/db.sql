-- MySQL Script generated by MySQL Workbench
-- Tue Jan 23 01:07:11 2024
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema interview
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema interview
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `interview` DEFAULT CHARACTER SET utf8 ;
USE `interview` ;

-- -----------------------------------------------------
-- Table `interview`.`geography_columns`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `interview`.`geography_columns` (
  `id` INT NOT NULL,
  `city_name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
