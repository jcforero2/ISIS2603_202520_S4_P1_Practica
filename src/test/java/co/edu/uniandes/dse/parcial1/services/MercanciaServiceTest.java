package co.edu.uniandes.dse.parcial1.services;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import co.edu.uniandes.dse.parcial1.entities.MercanciaEntity;
import co.edu.uniandes.dse.parcial1.exceptions.IllegalOperationException;
import jakarta.transaction.Transactional;

@DataJpaTest
@Transactional
@Import(MercanciaService.class)
public class MercanciaServiceTest {
    @Autowired
    private MercanciaService mercanciaService;


    @Test
    void testcreacionexitoso() throws IllegalOperationException{
        MercanciaEntity mercancia = new MercanciaEntity();
        mercancia.setCantidaddisponible(5);
        mercancia.setCodigodebarras("1a2b3c4d");
        mercancia.setFechaderecepcion(LocalDateTime.now().minusDays(3));
        mercancia.setNombre("Papas Margarita");
    }
    @Test
    void testcreacionfechapasada() {
        MercanciaEntity mercancia = new MercanciaEntity();
        mercancia.setCantidaddisponible(5);
        mercancia.setCodigodebarras("1a2b3c4d");
        mercancia.setFechaderecepcion(LocalDateTime.now().plusDays(3));
        mercancia.setNombre("Papas Margarita");
        assertThrows(IllegalOperationException.class, () -> mercanciaService.createMercancia(mercancia));
    }

    
}
