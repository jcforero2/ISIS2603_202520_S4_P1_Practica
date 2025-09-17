package co.edu.uniandes.dse.parcial1.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uniandes.dse.parcial1.entities.MercanciaEntity;
import co.edu.uniandes.dse.parcial1.exceptions.IllegalOperationException;
import co.edu.uniandes.dse.parcial1.repositories.MercanciaRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MercanciaService {
    @Autowired
    private MercanciaRepository mercanciaRepository;

    @Transactional
    public MercanciaEntity createMercancia (MercanciaEntity mercancia) throws IllegalOperationException {

        if (mercancia.getCodigodebarras().isBlank()) {
            throw new IllegalOperationException("No se puede registrar una mercancía sin código de barras único.");
        }

        if (mercancia.getNombre().isBlank()) {
            throw new IllegalOperationException("El nombre de la mercancía es obligatorio y no puede estar vacío.");
        }

        if (mercancia.getFechaderecepcion().isAfter(LocalDateTime.now())) {
            throw new IllegalOperationException("La fecha de recepcion no puede ser posterior a la fecha actual");
        }

        return mercanciaRepository.save(mercancia);
    }

}
