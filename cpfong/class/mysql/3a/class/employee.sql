drop database if exists employee;
create database employee;

use employee;

create table department
(
  departmentID int not null auto_increment primary key,
  name varchar(20)  
) type=InnoDB;

create table employee
(
  employeeID int not null auto_increment primary key,
  name varchar(80),
  job varchar(15),
  departmentID int not null references department(departmentID)
) type=InnoDB;

create table employeeSkills
(
  employeeID int not null references employee(employeeID),
  skill varchar(15) not null,
  primary key (employeeID, skill)
) type=InnoDB;

create table client
(
  clientID int not null auto_increment primary key,
  name varchar(40),
  address varchar(100),
  contactPerson varchar(80),
  contactNumber char(12)
) type=InnoDB;

create table assignment
(
  clientID int not null references client(clientID),
  employeeID int not null references employee(employeeID),
  workdate date not null,
  hours float,
  primary key (clientID, employeeID, workdate)
) type=InnoDB;