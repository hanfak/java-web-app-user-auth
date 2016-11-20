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


--Change default to not null, so all fields are required
--Not working need to sort out
ALTER TABLE clients
CHANGE COLUMN password password varchar(255) DEFAULT NULL;
ALTER TABLE clients
CHANGE COLUMN username username varchar(255) DEFAULT NULL;
ALTER TABLE clients
CHANGE COLUMN email email varchar(255) DEFAULT NULL;
ALTER TABLE clients
CHANGE COLUMN mobile mobile varchar(255) DEFAULT NULL;