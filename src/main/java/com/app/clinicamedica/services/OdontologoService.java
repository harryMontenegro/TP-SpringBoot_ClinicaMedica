package com.app.clinicamedica.services;


import com.app.clinicamedica.dao.DaoInterface;
import com.app.clinicamedica.dao.imp_dao.OdontologoDaoImpH2;
import com.app.clinicamedica.models.Odontologo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class OdontologoService {

    private final DaoInterface<Odontologo> odontologoDaoImpl;

    @Autowired
    public OdontologoService(OdontologoDaoImpH2 odontologoDaoImpl) {
        this.odontologoDaoImpl = odontologoDaoImpl;
    }

    public Odontologo guardarOdontologo(Odontologo odontologo) throws SQLException, ClassNotFoundException {
        return this.odontologoDaoImpl.crear(odontologo);
    }

    public List<Odontologo> listarTodosOdontologos() {
        return odontologoDaoImpl.listar();
    }


    public void modificarOdontologo(Odontologo odontologo) {
        this.odontologoDaoImpl.modificar(odontologo);
    }

    public void eliminarOdontologo(int id) {
        odontologoDaoImpl.eliminar(id);
    }
}
