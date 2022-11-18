package com.app.clinicamedica.dao;

import java.sql.SQLException;
import java.util.List;

public interface DaoInterface<T> {

    T crear(T t) throws SQLException, ClassNotFoundException;

    List<T> listar();

    void modificar(T t);

    void eliminar(int id);

}
