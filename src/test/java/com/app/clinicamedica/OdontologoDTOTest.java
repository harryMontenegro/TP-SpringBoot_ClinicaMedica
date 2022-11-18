package com.app.clinicamedica;


import com.app.clinicamedica.models.Odontologo;
import com.app.clinicamedica.services.OdontologoService;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class OdontologoDTOTest {

    @Test
    void instanciarOdontologoTest(){
        Odontologo odontologo = new Odontologo();
        assertNotNull(odontologo);
    }

    //@Test
/*    void listarOdontologos(){
        OdontologoService service = new OdontologoService();
        List<Odontologo> lista = service.listarTodosOdontologos();
        assertTrue(lista.size() > 0);
    }*/
}