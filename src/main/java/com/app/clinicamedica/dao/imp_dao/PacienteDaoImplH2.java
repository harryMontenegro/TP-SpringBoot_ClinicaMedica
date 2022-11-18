package com.app.clinicamedica.dao.imp_dao;


import com.app.clinicamedica.dao.DaoInterface;
import com.app.clinicamedica.models.Paciente;
import com.app.clinicamedica.utils.ConexionBD;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

@Repository
public class PacienteDaoImplH2 implements DaoInterface<Paciente> {

    private static final Logger LOGGER = LogManager.getLogger(PacienteDaoImplH2.class);

    public Connection getConexcion() throws SQLException, ClassNotFoundException {
        return ConexionBD.conectarseBd();
    }


    @Override
    public Paciente crear(Paciente paciente) throws SQLException, ClassNotFoundException {

        PreparedStatement queryInsert = getConexcion().prepareStatement("INSERT INTO paciente " +
                "(nombre,apellido,domicilio,dni, fechaAlta) " +
                "VALUES(?, ?, ?, ?, ?)");

        queryInsert.setString(1, paciente.getNombre());
        queryInsert.setString(2, paciente.getApellido());
        queryInsert.setString(3, paciente.getDomicilio());
        queryInsert.setString(4, paciente.getDni());
        queryInsert.setTimestamp(5, Timestamp.valueOf(paciente.getFechaAlta()));

        queryInsert.execute();
        LOGGER.info("¡Paciente creado con exito!");
        queryInsert.close();

        return null;
    }

    @Override
    public List<Paciente> listar() {
        return null;
    }

    @Override
    public void modificar(Paciente paciente) {

    }

    @Override
    public void eliminar(int id) {

    }
}
