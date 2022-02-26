create table credito (
 id Long not null auto_increment,
 id_cliente Long not null,
 fecha_solicitud datetime not null,
 ingreso_mensual numeric(20,2) not null,
 egreso_mensual numeric(20,2) not null,
 codigo_moneda varchar(3) not null,
 plazo integer not null,
 tasa_cambio numeric(20,2) not null,
 valor_prestamo numeric(20,2),
 valor_dividendo numeric(20,2),
 fecha_primera_cuota datetime,
 estado varchar(1),
 primary key (id)
);