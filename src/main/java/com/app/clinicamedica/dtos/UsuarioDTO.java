package com.app.clinicamedica.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UsuarioDTO {

    private String usuario;
    private String contasenia;
    private String rol;
    private boolean activo;

    public String getUsuario() {
        return usuario;
    }

    public String getContasenia() {
        return contasenia;
    }

    public String getRol() {
        return rol;
    }

    public boolean isActivo() {
        return activo;
    }
}
