CREATE DATABASE fonix_users;

USE fonix_users;

CREATE TABLE IF NOT EXISTS clients (
  id int(3) NOT NULL AUTO_INCREMENT,
  username varchar(255) DEFAULT NULL,
  email varchar(255) DEFAULT NULL,
  mobile varchar(255) DEFAULT NULL,
  password varchar(255) DEFAULT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY email (email)
);