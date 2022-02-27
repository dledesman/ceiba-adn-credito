insert into credito (id_cliente, fecha_solicitud, ingreso_mensual, egreso_mensual,
    codigo_moneda, plazo, tasa_cambio, valor_prestamo, valor_dividendo, fecha_primera_cuota, estado)
values (:idCliente, :fechaSolicitud, :ingresoMensual, :egresoMensual, :codigoMoneda,
    :plazo, :tasaCambio, :valorPrestamo, :valorDividendo, :fechaPrimeraCuota, :estado);