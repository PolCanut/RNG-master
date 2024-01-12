package RNG.modelo;

import java.util.ArrayList;

public class ListaPedidos {
    private ArrayList<Pedido> pedidos;

    public ListaPedidos() {
        this.pedidos = new ArrayList<>();
    }

    public void add(Pedido pedido) {
        pedidos.add(pedido);
    }

    public int getSize() {
        return pedidos.size();
    }

    public Pedido getAt(int index) {
        return pedidos.get(index);
    }

    public void borrar(Pedido pedido) {
        pedidos.remove(pedido);
    }

    public ListaPedidos getListaPedidosPendientes() {
        ListaPedidos pendientes = new ListaPedidos();

        for (int i = 0; i < getSize(); i++) {
            Pedido pedido = getAt(i);
            if (!pedido.pedidoEnviado()) {
                // Agregar a la lista de pedidos pendientes
                pendientes.add(pedido);
            }
        }

        return pendientes;
    }
}
