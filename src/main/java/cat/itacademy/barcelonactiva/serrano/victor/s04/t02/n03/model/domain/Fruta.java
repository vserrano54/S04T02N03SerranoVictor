package cat.itacademy.barcelonactiva.serrano.victor.s04.t02.n03.model.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;

@Document(collection = "fruta") // Indica que esta clase se mapea a la colección "fruta" en MongoDB
public class Fruta implements Serializable {

    private static final long serialVersionUID = 5474227552982677611L;

    @Id // Indica que el campo "id" es el identificador único en MongoDB
    private String id;

    @NotNull
    @NotBlank
    private String nombre;

    @NotNull
    @DecimalMin(value = "0.00", message = "La cantidad debe ser mayor o igual a 0.00")
    @DecimalMax(value = "99999.99", message = "La cantidad debe ser menor o igual a 99999.99")
    private Float cantidadKilos;

    public Fruta() {
        // Constructor vacío requerido por Spring Data MongoDB
    }

    public Fruta(String nombre, Float cantidadKilos) {
        this.nombre = nombre;
        this.cantidadKilos = cantidadKilos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Float getCantidadKilos() {
        return cantidadKilos;
    }

    public void setCantidadKilos(Float cantidadKilos) {
        this.cantidadKilos = cantidadKilos;
    }

    @Override
    public String toString() {
        return "Fruta [id=" + id + ", nombre=" + nombre + ", cantidadKilos=" + cantidadKilos + "]";
    }
}
