package com.app.clinicamedica.dao.imp_dao;

import com.app.clinicamedica.dao.DaoInterface;
import com.app.clinicamedica.models.Odontologo;
import com.app.clinicamedica.utils.ConexionBD;
import org.apache.logging.log4j.*;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OdontologoDaoImpH2 implements DaoInterface<Odontologo> {

    private static final Logger LOGGER = LogManager.getLogger(OdontologoDaoImpH2.class);

    public Connection getConexcion() throws SQLException, ClassNotFoundException {
        return ConexionBD.conectarseBd();
    }

    @Override
    public Odontologo crear(Odontologo odontologo) throws SQLException, ClassNotFoundException {

        PreparedStatement queryInsert = getConexcion().prepareStatement("INSERT INTO odontologo " +
                "(nombre,apellido,matricula) " +
                "VALUES(?, ?, ?)");

        queryInsert.setString(1, odontologo.getNombre());
        queryInsert.setString(2, odontologo.getApellido());
        queryInsert.setString(3, odontologo.getMatricula());


        queryInsert.execute();
        LOGGER.info("¡Odontologo creado con exito!");
        queryInsert.close();

        return null;
    }

    @Override
    public List<Odontologo> listar() {
        List<Odontologo> odontologos = new ArrayList<>();

        try(Statement stmt = getConexcion().createStatement()){
            ResultSet rs = stmt.executeQuery("SELECT * FROM odontologo");
            while (rs.next()){
                Odontologo o = new Odontologo();
                o.setIdOdontologo(rs.getInt(1));
                o.setNombre(rs.getString(2));
                o.setApellido(rs.getString(3));
                o.setMatricula(rs.getString(4));
                odontologos.add(o);
            }

        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }

        return odontologos;
    }

    @Override
    public void modificar(Odontologo odontologo) {
        try (PreparedStatement stmt = getConexcion().prepareStatement("UPDATE odontologo set nombre = ?, apellido = ?, matricula = ? where idOdontologo = ?")){
            stmt.setString(1, odontologo.getNombre());
            stmt.setString(2, odontologo.getApellido());
            stmt.setString(3, odontologo.getMatricula());
            stmt.setInt(4, odontologo.getIdOdontologo());
            stmt.executeUpdate();
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }

        LOGGER.info("¡Odontologo actualizado con exito!");
    }

    @Override
    public void eliminar(int id) {
        try (PreparedStatement stmt = getConexcion().prepareStatement("DELETE FROM odontologo WHERE idOdontologo = ?")){
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }

        LOGGER.info("¡Odontólogo eliminado con éxito!");
    }
}








