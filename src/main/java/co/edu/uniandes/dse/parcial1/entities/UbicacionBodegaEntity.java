package co.edu.uniandes.dse.parcial1.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;
@Data
@Entity
public class UbicacionBodegaEntity extends BaseEntity{
   private int numerodeestante;
   private int canastadeposito;
   private float pesomaximo;
    @OneToMany(mappedBy = "Bodega")
    private List<MercanciaEntity> Mercancia = new ArrayList<>();
}
