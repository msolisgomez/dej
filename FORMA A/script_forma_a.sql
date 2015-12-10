-- MySQL Script generated by MySQL Workbench
-- 10/18/15 20:32:47
-- Model: New Model    Version: 1.0
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema et_dej4501
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `et_dej4501` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `et_dej4501` ;

-- -----------------------------------------------------
-- Table `et_dej4501`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `et_dej4501`.`cliente` (
  `rut` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`rut`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `et_dej4501`.`producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `et_dej4501`.`producto` (
  `id_producto` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(45) NOT NULL,
  `valor` INT NOT NULL,
  PRIMARY KEY (`id_producto`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `et_dej4501`.`pedido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `et_dej4501`.`pedido` (
  `ticket` INT NOT NULL AUTO_INCREMENT,
  `rut` INT NOT NULL,
  `medio_pago` VARCHAR(45) NOT NULL,
  `agranda_bebida_papas` TINYINT(1) NOT NULL,
  `para_llevar` TINYINT(1) NOT NULL,
  `total` INT NOT NULL,
  PRIMARY KEY (`ticket`),
  INDEX `fk_pedido_cliente_idx` (`rut` ASC),
  CONSTRAINT `fk_pedido_cliente`
    FOREIGN KEY (`rut`)
    REFERENCES `et_dej4501`.`cliente` (`rut`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `et_dej4501`.`pedido_detalle`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `et_dej4501`.`pedido_detalle` (
  `id_pedido_detalle` INT NOT NULL AUTO_INCREMENT,
  `ticket` INT NOT NULL,
  `id_producto` INT NOT NULL,
  `cantidad` INT NOT NULL,
  PRIMARY KEY (`id_pedido_detalle`),
  INDEX `fk_pedido_detalle_producto1_idx` (`id_producto` ASC),
  INDEX `fk_pedido_detalle_pedido1_idx` (`ticket` ASC),
  UNIQUE INDEX `idu_ticket_pedido` (`ticket` ASC, `id_producto` ASC),
  CONSTRAINT `fk_pedido_detalle_producto1`
    FOREIGN KEY (`id_producto`)
    REFERENCES `et_dej4501`.`producto` (`id_producto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pedido_detalle_pedido1`
    FOREIGN KEY (`ticket`)
    REFERENCES `et_dej4501`.`pedido` (`ticket`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
