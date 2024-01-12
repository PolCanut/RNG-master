package RNG.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Articulo {
    @Id
    private String codigoArticulo;
    private String descripcion;
    private float precioVenta;
    private float gastosEnvio;
    private int tiempoPreparacion;


    // Constructor sin argumentos necesario para Hibernate
    public Articulo() {
    }

    public Articulo(String codigo, String descripcion, double precio) {
    }

    public float getGastosEnvio(){
        return this.gastosEnvio;
    }

    public float getPrecioVenta() {
        return this.precioVenta;
    }

    public int getTiempoPreparacion() {
        return this.tiempoPreparacion;
    }

    public String getCodigoArticulo() {
        return this.codigoArticulo;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public Articulo(String codigoArticulo, String descripcion, float precioVenta, float gastosEnvio, int tiempoPreparacion) {
        this.codigoArticulo = codigoArticulo;
        this.descripcion = descripcion;
        this.precioVenta = precioVenta;
        this.gastosEnvio = gastosEnvio;
        this.tiempoPreparacion = tiempoPreparacion;
    }

    // Getters y setters

    @Override
    public String toString() {
        return "Articulo{" +
                "codigoArticulo='" + codigoArticulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precioVenta=" + precioVenta +
                ", gastosEnvio=" + gastosEnvio +
                ", tiempoPreparacion=" + tiempoPreparacion +
                '}';
    }
}