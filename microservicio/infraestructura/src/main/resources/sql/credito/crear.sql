insert into credito (tipo_identificacion, numero_identificacion, fecha_solicitud, ingreso_mensual,
    egreso_mensual, codigo_moneda, plazo, tasa_cambio, valor_prestamo, valor_dividendo, fecha_primera_cuota, estado)
values (:tipoIdentificacion, :numeroIdentificacion, :fechaSolicitud, :ingresoMensual,
    :egresoMensual, :codigoMoneda, :plazo, :tasaCambio, :valorPrestamo, :valorDividendo, :fechaPrimeraCuota, :estado);