package RNG.modelo;

public class Datos {
    private ListaArticulos listaArticulos;
    private ListaClientes listaClientes;
    private ListaPedidos listaPedidos;

    public Datos() {
        listaArticulos = new ListaArticulos();
        listaClientes = new ListaClientes();
        listaPedidos = new ListaPedidos();
    }

    public ListaArticulos getListaArticulos() {
        return listaArticulos;
    }

    public ListaClientes getListaClientes() {
        return listaClientes;
    }

    public ListaPedidos getListaPedidos() {
        return listaPedidos;
    }

    // Métodos para gestionar los datos

    public void agregarArticulo(Articulo articulo) {
        listaArticulos.add(articulo);
    }

    public void eliminarArticulo(Articulo articulo) {
        listaArticulos.borrar(articulo);
    }

    public void agregarCliente(Cliente cliente) {
        listaClientes.add(cliente);
    }

    public void eliminarCliente(Cliente cliente) {
        listaClientes.borrar(cliente);
    }

    public void agregarPedido(Pedido pedido) {
        listaPedidos.add(pedido);
    }

    public void eliminarPedido(Pedido pedido) {
        listaPedidos.borrar(pedido);
    }

    public ListaPedidos getListaPedidosPendientes(){
        ListaPedidos lista=this.getListaPedidos();
        ListaPedidos lista2 = new ListaPedidos();
        for (int i=0;i<lista.getSize();i++) {
            if (!lista.getAt(i).pedidoEnviado()) {
                lista2.add(lista.getAt(i));
            }
        }
        return lista;
    }

    public Cliente buscarClientePorCorreo(String correo){
        ListaClientes lista=this.getListaClientes();
        for (int i=0;i<lista.getSize();i++){
            if (lista.getAt(i).getCorreoElectronicoCliente().equals(correo)){
                return lista.getAt(i);
            }
        }
        return null;
    }
    public Articulo buscarArticuloPorCodigo(String codigoArticulo){
       ListaArticulos lista=this.getListaArticulos();
       for (int i=0;i<lista.getSize();i++){
           if (lista.getAt(i).getCodigoArticulo().equals(codigoArticulo)){
               return lista.getAt(i);
           }
       }
       return null;
    }
}
