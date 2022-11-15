package com.app.clinicamedica.service;



import com.app.clinicamedica.dao.ITurnoDao;
import com.app.clinicamedica.dao.imp_dao.TurnoDaoImpH2;
import com.app.clinicamedica.models.Turno;

import java.sql.SQLException;
import java.util.List;

public class TurnoService {

    ITurnoDao turno;

    public TurnoService() {
        this.turno = new TurnoDaoImpH2();
    }

    public Turno guardarTurno(Turno turno) throws SQLException, ClassNotFoundException {
        return this.turno.crear(turno);
    }

    public List<Turno> listarTodosTurnos(){
        return turno.listar();
    }


    public void modificarTurno(Turno turno){
        this.turno.modificar(turno);
    }

    public void eliminarTurno(int id){
        turno.eliminar(id);
    }
}
