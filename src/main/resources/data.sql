
//Creacion de la base de datos
create database bd_Camposgapi;
use bd_Camposgapi;

create table Cliente(
id int not null primary key auto_increment,
nombre varchar(80) not null,
balance varchar(80) not null,
stateaccount varchar(80) not null
);

insert into Cliente(nombre, balance, stateaccount) values
("Gilberto","campos","activo");

select * from Cliente;
ALTER TABLE cliente MODIFY stateaccount VARCHAR(255) NULL;
ALTER TABLE cliente MODIFY stateaccount VARCHAR(255) NOT NULL;
