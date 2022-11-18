package com.app.clinicamedica.dao.imp_dao;


import com.app.clinicamedica.dao.DaoInterface;
import com.app.clinicamedica.models.Turno;
import com.app.clinicamedica.utils.ConexionBD;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

@Repository
public class TurnoDaoImpH2 implements DaoInterface<Turno> {

    private static final Logger LOGGER = LogManager.getLogger(TurnoDaoImpH2.class);

    public Connection getConexcion() throws SQLException, ClassNotFoundException {
        return ConexionBD.conectarseBd();
    }

    @Override
    public Turno crear(Turno turno) throws SQLException, ClassNotFoundException {

        PreparedStatement queryInsert = getConexcion().prepareStatement("INSERT INTO turno " +
                "(idOdontologo,idPaciente,fechaTurno) " +
                "VALUES(?, ?, ?)");

        queryInsert.setInt(1, turno.getIdOdontologo());
        queryInsert.setInt(2, turno.getIdPaciente());
        queryInsert.setTimestamp(3, Timestamp.valueOf(turno.getFechaTurno()));

        queryInsert.execute();
        LOGGER.info("¡Turno creado con exito!");
        queryInsert.close();
        getConexcion().close();

        return null;
    }

    @Override
    public List<Turno> listar() {
        return null;
    }

    @Override
    public void modificar(Turno turno) {

    }

    @Override
    public void eliminar(int id) {

    }
}
