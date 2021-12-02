create database listeEmployes;
use listeEmployes;
create table employe (
id int(11) not null auto_increment,
lastName varchar(45) not null,
firstName varchar(45) not null,
courriel varchar(128) not null,
age int not null,
position varchar(45),
phone varchar(10),
adress varchar(128),
primary key(id),
unique key id_unique (id),
unique key courriel_unique (courriel)
) engine=InnoDB;

select * from employe;


