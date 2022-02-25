update credito
set fecha_solicitud = :fechaSolicitud,
    ingreso_mensual = :ingresoMensual,
	egreso_mensual = :egresoMensual,
	codigo_moneda = :codigoMoneda,
	plazo = :plazo,
	valor_prestamo = :valorPrestamo,
	valor_dividendo = :valorDividendo,
	fecha_primera_cuota = :fechaPrimeraCuota,
	tasa_cambio = :tasaCambio,
	estado = :estado
where id = :id