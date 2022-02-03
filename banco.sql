CREATE TABLE department (
  Id int(11) NOT NULL AUTO_INCREMENT,
  Name varchar(60) DEFAULT NULL,
  PRIMARY KEY (Id)
);

CREATE TABLE seller (
  Id int(11) NOT NULL AUTO_INCREMENT,
  Name varchar(60) NOT NULL,
  Email varchar(100) NOT NULL,
  BirthDate datetime NOT NULL,
  BaseSalary double NOT NULL,
  DepartmentId int(11) NOT NULL,
  PRIMARY KEY (Id),
  FOREIGN KEY (DepartmentId) REFERENCES department (id)
);

INSERT INTO department (Name) VALUES 
  ('Computers'),
  ('Electronics'),
  ('Fashion'),
  ('Books');

INSERT INTO seller (Name, Email, BirthDate, BaseSalary, DepartmentId) VALUES 
  ('Bob Brown','bob@gmail.com','1998-04-21 000000',1000,1),
  ('Maria Green','maria@gmail.com','1979-12-31 000000',3500,2),
  ('Alex Grey','alex@gmail.com','1988-01-15 000000',2200,1),
  ('Martha Red','martha@gmail.com','1993-11-30 000000',3000,4),
  ('Donald Blue','donald@gmail.com','2000-01-09 000000',4000,3),
  ('Alex Pink','bob@gmail.com','1997-03-04 000000',3000,2);