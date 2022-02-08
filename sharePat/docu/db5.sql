-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
DROP DATABASE IF EXISTS db5;
-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `db5` DEFAULT CHARACTER SET utf8 ;
USE `db5` ;

-- -----------------------------------------------------
-- Table `mydb`.`member`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db5`.`member` (
  `member_no` INT NOT NULL AUTO_INCREMENT,
  `member_id` VARCHAR(20) NULL,
  `member_pw` VARCHAR(45) NULL,
  `member_name` VARCHAR(45) NULL,
  `member_email` VARCHAR(45) NULL,
  `member_phone` VARCHAR(45) NULL,
  PRIMARY KEY (`member_no`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`shareNote`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db5`.`shareNote` (
  `share_no` INT NOT NULL AUTO_INCREMENT,
  `share_title` VARCHAR(45) NULL,
  `share_contents` VARCHAR(45) NULL,
  `share_profile` BLOB NULL,
  `share_time` TIMESTAMP NULL default current_timestamp,
  `writer` INT NOT NULL,
  PRIMARY KEY (`share_no`, `writer`),
  INDEX `fk_shareNote_member_idx` (`writer` ASC) VISIBLE,
  CONSTRAINT `fk_shareNote_member`
    FOREIGN KEY (`writer`)
    REFERENCES `db5`.`member` (`member_no`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`story`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db5`.`story` (
  `story_no` INT NOT NULL AUTO_INCREMENT,
  `story_title` VARCHAR(45) NULL,
  `story_contents` VARCHAR(45) NULL,
  `story_profile` BLOB NULL,
  `story_views` INT NULL,
  `story_time` TIMESTAMP NULL default current_timestamp,
  `writer` INT NOT NULL,
  PRIMARY KEY (`story_no`, `writer`),
  INDEX `fk_story_member1_idx` (`writer` ASC) VISIBLE,
  CONSTRAINT `fk_story_member1`
    FOREIGN KEY (`writer`)
    REFERENCES `db5`.`member` (`member_no`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
