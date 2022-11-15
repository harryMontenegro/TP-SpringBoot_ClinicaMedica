package com.app.clinicamedica.dao;



import com.app.clinicamedica.models.Turno;

import java.sql.SQLException;
import java.util.List;

public interface ITurnoDao {

    Turno crear(Turno turno) throws SQLException, ClassNotFoundException;

    List<Turno> listar();

    void modificar(Turno turno);

    void eliminar(int id);
}
