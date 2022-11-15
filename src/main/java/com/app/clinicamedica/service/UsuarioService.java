package com.app.clinicamedica.service;


import com.app.clinicamedica.dao.IUsuarioDao;
import com.app.clinicamedica.dao.imp_dao.UsuarioDaoImpH2;
import com.app.clinicamedica.models.Usuario;

import java.util.List;

public class UsuarioService {

    IUsuarioDao usuario;

    public UsuarioService() {
        this.usuario = new UsuarioDaoImpH2();
    }

    public Usuario guardarUsuario(Usuario usuario) {
        return this.usuario.crear(usuario);
    }

    public List<Usuario> listarTodosUsuarios(){
        return usuario.listar();
    }


    public void modificarUsuario(Usuario usuario){
        this.usuario.modificar(usuario);
    }

    public void eliminarUsuario(int id){
        usuario.eliminar(id);
    }
}
