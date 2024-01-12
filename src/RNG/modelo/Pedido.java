package RNG.modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Pedido {
    private static final int TIEMPO_PREPARACION_DEFAULT = 60; // en minutos
    private static final float COSTE_ENVIO_DEFAULT = 5.0f;

    private int numeroPedido;
    private LocalDateTime fechaHoraPedido;
    private Cliente cliente;
    private Articulo articulo;
    private int cantidad;
    private boolean enviado;


    public Pedido(int numeroPedido, LocalDateTime fechaHoraPedido, Cliente cliente, Articulo articulo, int cantidad) {
        this.numeroPedido = numeroPedido;
        this.fechaHoraPedido = fechaHoraPedido;
        this.cliente = cliente;
        this.articulo = articulo;
        this.cantidad = cantidad;
        this.enviado = false;
    }

    // Getters y setters

    public boolean pedidoEnviado() {
        return enviado;
    }

    public float precioEnvio() {
        float costoEnvio = COSTE_ENVIO_DEFAULT;

        // Aplicar descuento de envío si el cliente es premium
        if (this.cliente.isPremium()) {
            costoEnvio -= articulo  .getGastosEnvio() * 0.2f;
        }

        return costoEnvio;
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public LocalDateTime getFecha() {
        return fechaHoraPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public int getCantidad() {
        return cantidad;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "numeroPedido=" + numeroPedido +
                ", fechaHoraPedido=" + fechaHoraPedido +
                ", cliente=" + cliente +
                ", articulo=" + articulo +
                ", cantidad=" + cantidad +
                ", enviado=" + enviado +
                '}';
    }
}
