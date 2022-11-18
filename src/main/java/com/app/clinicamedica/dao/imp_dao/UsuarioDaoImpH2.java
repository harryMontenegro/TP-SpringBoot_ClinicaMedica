package com.app.clinicamedica.dao.imp_dao;
;

import com.app.clinicamedica.dao.DaoInterface;
import com.app.clinicamedica.models.Usuario;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsuarioDaoImpH2 implements DaoInterface<Usuario> {

    @Override
    public Usuario crear(Usuario usuario) {
        return null;
    }

    @Override
    public List<Usuario> listar() {
        return null;
    }

    @Override
    public void modificar(Usuario usuario) {

    }

    @Override
    public void eliminar(int id) {

    }
}
