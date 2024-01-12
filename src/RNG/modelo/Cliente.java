package RNG.modelo;

import javax.persistence.*;

@Entity
@Table(name = "Cliente")
public class Cliente {

    @Id
    @Column(name = "correoElectronicoCliente")
    private String correoElectronicoCliente;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "premium")
    private boolean premium;

    // Constructor vacío necesario para Hibernate
    public Cliente() {
    }

    public Cliente(String correoElectronicoCliente, String nombre, String direccion, boolean premium) {
        this.correoElectronicoCliente = correoElectronicoCliente;
        this.nombre = nombre;
        this.direccion = direccion;
        this.premium = premium;
    }

    // Otros métodos y setters

    @Override
    public String toString() {
        return "Cliente{" +
                "correoElectronicoCliente='" + correoElectronicoCliente + '\'' +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", premium=" + premium +
                '}';
    }

    // Getters y setters necesarios para Hibernate
    public String getCorreoElectronicoCliente() {
        return correoElectronicoCliente;
    }

    public void setCorreoElectronicoCliente(String correoElectronicoCliente) {
        this.correoElectronicoCliente = correoElectronicoCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public boolean isPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }
}
