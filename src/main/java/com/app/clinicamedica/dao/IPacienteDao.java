package com.app.clinicamedica.dao;



import com.app.clinicamedica.models.Paciente;

import java.sql.SQLException;
import java.util.List;

public interface IPacienteDao {
    Paciente crear(Paciente paciente) throws SQLException, ClassNotFoundException;

    List<Paciente> listar();

    void modificar(Paciente paciente);

    void eliminar(int id);
}
