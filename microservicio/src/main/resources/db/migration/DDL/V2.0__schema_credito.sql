create table credito (
 id int(11) not null auto_increment,
 indentificacion varchar(200) not null,
 valor_ingresos varchar(200) not null,
 valor_egresos varchar(200) not null,
 plazo int(2) not null,
 valor_prestamo varchar(200),
 valor_dividendo varchar(200),
 fecha_primera_cuota datetime,
 estado varchar(20),
 primary key (id)
);