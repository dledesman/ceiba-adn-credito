select count(1) from credito
where identificacion.tipoIdentificacion = :tipoIdentificacion and
identificacion.numeroIdentificacion = :numeroIdentificacion;
