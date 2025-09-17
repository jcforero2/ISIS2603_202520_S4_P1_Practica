package co.edu.uniandes.dse.parcial1.services;

import static org.junit.jupiter.api.Assertions.assertThrows;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import co.edu.uniandes.dse.parcial1.entities.UbicacionBodegaEntity;
import co.edu.uniandes.dse.parcial1.exceptions.IllegalOperationException;
import jakarta.transaction.Transactional;

@DataJpaTest
@Transactional
@Import(UbicacionBodegaService.class)
public class UbicacionBodegaServiceTest {

    @Autowired
    private UbicacionBodegaService ubicacionbodegaService;


    @Test
    void testcreacionexitoso() throws IllegalOperationException{
        UbicacionBodegaEntity ubicacion = new UbicacionBodegaEntity();
        ubicacion.setCanastadeposito(12);
        ubicacion.setPesomaximo(235);
        ubicacion.setNumerodeestante(2);

    }
    @Test
    void testcreacionnumerodeestantenegativo() {
        UbicacionBodegaEntity ubicacion = new UbicacionBodegaEntity();
        ubicacion.setCanastadeposito(120);
        ubicacion.setPesomaximo(235);
        ubicacion.setNumerodeestante(-25);
        assertThrows(IllegalOperationException.class, () -> ubicacionbodegaService.createUbicacionBodega(ubicacion));
    }
    
}
