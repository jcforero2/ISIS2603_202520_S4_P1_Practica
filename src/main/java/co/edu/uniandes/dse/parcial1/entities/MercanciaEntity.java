package co.edu.uniandes.dse.parcial1.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class MercanciaEntity extends BaseEntity{
    private String nombre;
    private String codigodebarras;
    private LocalDateTime fechaderecepcion;
    private int cantidaddisponible;
    @ManyToOne
    private UbicacionBodegaEntity Bodega;

}
