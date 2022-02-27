select id,tipo_identificacion,numero_identificacion from cliente
where tipo_identificacion = :tipoIdentificacion and numero_identificacion = :numeroIdentificacion;
