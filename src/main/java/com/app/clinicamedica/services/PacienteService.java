package com.app.clinicamedica.services;


import com.app.clinicamedica.dao.DaoInterface;
import com.app.clinicamedica.dao.imp_dao.PacienteDaoImplH2;
import com.app.clinicamedica.models.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class PacienteService {

    private final DaoInterface<Paciente> pacienteDaoImpl;

    @Autowired
    public PacienteService(PacienteDaoImplH2 pacienteDaoImpl) {
        this.pacienteDaoImpl = pacienteDaoImpl;
    }

    public Paciente guardarPaciente(Paciente paciente) throws SQLException, ClassNotFoundException {
        return this.pacienteDaoImpl.crear(paciente);
    }

    public List<Paciente> listarTodosPaciente(){
        return pacienteDaoImpl.listar();
    }

    public void modificarPaciente(Paciente paciente){
        this.pacienteDaoImpl.modificar(paciente);
    }

    public void eliminarPaciente(int id){
        pacienteDaoImpl.eliminar(id);
    }
}
