package com.app.clinicamedica.dao;


import com.app.clinicamedica.models.Usuario;

import java.util.List;

public interface IUsuarioDao {

    Usuario crear(Usuario usuario);

    List<Usuario> listar();

    void modificar(Usuario usuario);

    void eliminar(int id);
}
