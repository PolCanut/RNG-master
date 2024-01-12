// Interfaz PedidoDAO
package RNG.modelo;

import java.util.List;

public interface PedidoDAO {
    void agregarPedido(Pedido pedido);
    void eliminarPedido(int numeroPedido);
    Pedido buscarPedidoPorNumero(int numeroPedido);
    List<Pedido> obtenerTodosLosPedidos();
    ListaPedidos obtenerPedidosPendientes(); // Agrega esta línea

    // Nuevo método para establecer la sesión
    void setSession(org.hibernate.Session session);
}