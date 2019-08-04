CREATE DATABASE resttest;
USE resttest;
CREATE TABLE customers (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(30) NOT NULL,
  email VARCHAR(30) NOT NULL,
  adress VARCHAR(30) NOT NULL ,
  number BIGINT(255) NOT NULL,
  PRIMARY KEY (id)
);
INSERT INTO customers(name, email, adress, number) VALUES ('Brayn', 'J.Brayn@gmail.com','New York Lexington Ave 65', 18007423333),
                                                          ('Emin', 'A.emil98@mail.ru','Gence H.Aliyev 17',994558523665);

