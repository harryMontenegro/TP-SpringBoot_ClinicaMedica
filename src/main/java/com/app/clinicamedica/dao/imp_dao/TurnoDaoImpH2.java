package com.app.clinicamedica.dao.imp_dao;


import com.app.clinicamedica.dao.ITurnoDao;
import com.app.clinicamedica.models.Turno;
import com.app.clinicamedica.utils.ConexionBD;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.List;

public class TurnoDaoImpH2 implements ITurnoDao {

    private static final Logger LOGGER = LogManager.getLogger(TurnoDaoImpH2.class);

    private final static String CREATE_TABLE_TURNO = "create table if not exists turno " +
            "(idTurno int auto_increment primary key," +
            "idOdontologo int," +
            "idPaciente int,"+
            "fechaTurno DATE);";

    public Connection getConexcion() throws SQLException, ClassNotFoundException {
        return ConexionBD.conectarseBd();
    }

    @Override
    public Turno crear(Turno turno) throws SQLException, ClassNotFoundException {
        Statement stmtCrearTabla = getConexcion().createStatement();
        stmtCrearTabla.execute(CREATE_TABLE_TURNO);

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
