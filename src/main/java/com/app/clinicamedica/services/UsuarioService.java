package com.app.clinicamedica.services;


import com.app.clinicamedica.dao.DaoInterface;
import com.app.clinicamedica.dao.imp_dao.UsuarioDaoImpH2;
import com.app.clinicamedica.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class UsuarioService {

    private final DaoInterface<Usuario> usuarioDaoImpl;

    @Autowired
    public UsuarioService(UsuarioDaoImpH2 usuarioDaoImpl) {
        this.usuarioDaoImpl = usuarioDaoImpl;
    }

    public Usuario guardarUsuario(Usuario usuario) throws SQLException, ClassNotFoundException {
        return this.usuarioDaoImpl.crear(usuario);
    }

    public List<Usuario> listarTodosUsuarios() {
        return usuarioDaoImpl.listar();
    }

    public void modificarUsuario(Usuario usuario) {
        this.usuarioDaoImpl.modificar(usuario);
    }

    public void eliminarUsuario(int id) {
        usuarioDaoImpl.eliminar(id);
    }
}
