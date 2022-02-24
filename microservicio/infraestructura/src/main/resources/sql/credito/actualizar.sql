update credito
set valor_ingresos = :valorIngresos,
	valor_egresos = :valoregresos,
	plazo = :plazo
	valor_prestamo = :valorPrestamo,
	valor_dividendo = :valoDividendo,
	fecha_primera_cuota = :fechaPrimeraCuota,
	estado = :estado
where id = :id