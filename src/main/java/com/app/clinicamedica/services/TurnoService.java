package com.app.clinicamedica.services;



import com.app.clinicamedica.dao.DaoInterface;
import com.app.clinicamedica.dao.imp_dao.TurnoDaoImpH2;
import com.app.clinicamedica.models.Turno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class TurnoService {

    private final DaoInterface<Turno> turnoDaoImpl;

    @Autowired
    public TurnoService(TurnoDaoImpH2 turnoDaoImpl) {
        this.turnoDaoImpl = turnoDaoImpl;
    }

    public Turno guardarTurno(Turno turno) throws SQLException, ClassNotFoundException {
        return this.turnoDaoImpl.crear(turno);
    }

    public List<Turno> listarTodosTurnos(){
        return turnoDaoImpl.listar();
    }


    public void modificarTurno(Turno turno){
        this.turnoDaoImpl.modificar(turno);
    }

    public void eliminarTurno(int id){
        turnoDaoImpl.eliminar(id);
    }
}
