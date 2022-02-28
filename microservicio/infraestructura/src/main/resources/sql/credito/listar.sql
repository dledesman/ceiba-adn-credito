select cre.id, cli.tipo_identificacion, cli.numero_identificacion, cre.fecha_solicitud,
        cre.ingreso_mensual, cre.egreso_mensual, cre.codigo_moneda, cre.plazo,
        cre.tasa_cambio, cre.valor_prestamo, cre.valor_dividendo, cre.fecha_primera_cuota, cre.estado
from credito cre, cliente cli
where cre.id_cliente = cli.id;
