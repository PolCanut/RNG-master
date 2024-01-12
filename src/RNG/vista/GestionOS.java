package RNG.vista;

import RNG.controlador.Controlador;
import RNG.modelo.*;

import java.util.Scanner;
import java.time.*;

public class GestionOS {
    private Controlador controlador;
    Scanner teclado = new Scanner(System.in);

    public GestionOS() {
        controlador = new Controlador();
    }

    public void inicio() {
        boolean salir = false;
        int opcion;
        do {
            System.out.println("1. Gestión Articulos");
            System.out.println("2. Gestión Clientes");
            System.out.println("3. Gestión Pedidos");
            System.out.println("0. Salir");
            opcion = teclado.nextInt();
            switch (opcion) {
                case 1:
                    gestionArticulos();
                    break;
                case 2:
                    gestionClientes();
                    break;
                case 3:
                    gestionPedidos();
                    break;
                case 0:
                    salir = true;
            }
        } while (!salir);
    }

    private void gestionArticulos() {
        boolean salir = false;
        int opcion;
        do {
            System.out.println("1. Añadir Articulo");
            System.out.println("2. Eliminar Articulo");
            System.out.println("3. Mostrar Articulo");
            System.out.println("0. Volver al menú principal");
            opcion = teclado.nextInt();
            switch (opcion) {
                case 1:
                    añadirArticulo();
                    break;
                case 2:
                    eliminarArticulo();
                    break;
                case 3:
                    mostrarArticulos();
                    break;
                case 0:
                    salir = true;
            }
        } while (!salir);
    }

    private void añadirArticulo() {
        teclado.nextLine(); // Consumir la nueva línea pendiente del buffer

        System.out.println("Ingrese el código del artículo: ");
        String codigoArticulo = teclado.nextLine();
        System.out.println("Ingrese la descripción del artículo: ");
        String descripcion = teclado.nextLine();
        System.out.println("Ingrese el precio de venta del artículo: ");
        float precioVenta = Float.parseFloat(teclado.nextLine());
        System.out.println("Ingrese los gastos de envío del artículo: ");
        float gastosEnvio = Float.parseFloat(teclado.nextLine());
        System.out.println("Ingrese el tiempo de preparación para el envío (en minutos): ");
        int tiempoPreparacion = Integer.parseInt(teclado.nextLine());

        Articulo nuevoArticulo = new Articulo(codigoArticulo, descripcion, precioVenta, gastosEnvio, tiempoPreparacion);
        controlador.agregarArticulo(nuevoArticulo);

        System.out.println("Artículo agregado correctamente.");
    }

    private void eliminarArticulo() {
        mostrarArticulos();

        System.out.println("Ingrese el código del artículo que desea eliminar: ");
        teclado.nextLine();
        String codigoArticulo = teclado.nextLine();

        // Buscar el artículo en la lista y eliminarlo
        Articulo articuloAEliminar = controlador.buscarArticuloPorCodigo(codigoArticulo);
        if (articuloAEliminar != null) {
            controlador.eliminarArticulo(String.valueOf(articuloAEliminar));
            System.out.println("Artículo eliminado correctamente.");
        } else {
            System.out.println("No se encontró un artículo con ese código.");
        }
    }

    private void mostrarArticulos() {
        ListaArticulos listaArticulos = controlador.getDatos().getListaArticulos();
        if (!listaArticulos.isEmpty()) {
            System.out.println("Lista de Artículos:");
            for (int i = 0; i < listaArticulos.getSize(); i++) {
                Articulo articulo = listaArticulos.getAt(i);
                System.out.println(articulo);
            }
        } else {
            System.out.println("No hay artículos registrados.");
        }
    }

    private void gestionClientes() {
        boolean salir = false;
        int opcion;
        do {
            System.out.println("1. Añadir Cliente");
            System.out.println("2. Eliminar Cliente");
            System.out.println("3. Mostrar Clientes");
            System.out.println("0. Volver al menú principal");
            opcion = teclado.nextInt();
            switch (opcion) {
                case 1:
                    añadirCliente();
                    break;
                case 2:
                    eliminarCliente();
                    break;
                case 3:
                    mostrarClientes();
                    break;
                case 0:
                    salir = true;
            }
        } while (!salir);
    }

    private void añadirCliente() {
        teclado.nextLine(); // Consumir la nueva línea pendiente del buffer

        System.out.println("Ingrese el correo electrónico del cliente: ");
        String correoElectronicoCliente = teclado.nextLine();
        System.out.println("Ingrese el nombre del cliente: ");
        String nombre = teclado.nextLine();
        System.out.println("Ingrese la dirección del cliente: ");
        String direccion = teclado.nextLine();
        System.out.println("¿Quiere ser premium pagando la cuota anual de 30 euros?");
        String premium = teclado.nextLine();
        boolean esPremium = premium.equals("si");

        Cliente nuevoCliente = new Cliente(correoElectronicoCliente, nombre, direccion, esPremium);
        controlador.agregarCliente(nuevoCliente);

        System.out.println("Cliente agregado correctamente.");
    }

    private void eliminarCliente() {
        mostrarClientes();

        System.out.println("Ingrese el correo electrónico del cliente que desea eliminar: ");
        teclado.nextLine(); // Consumir la nueva línea pendiente del buffer
        String correoElectronicoCliente = teclado.nextLine();

        // Llama al método eliminarCliente con el correo electrónico
        controlador.eliminarCliente(correoElectronicoCliente);

        System.out.println("Cliente eliminado correctamente.");
    }

    private void mostrarClientes() {
        ListaClientes listaClientes = controlador.getDatos().getListaClientes();
        if (!listaClientes.isEmpty()) {
            System.out.println("Lista de Clientes:");
            for (int i = 0; i < listaClientes.getSize(); i++) {
                Cliente cliente = listaClientes.getAt(i);
                System.out.println(cliente);
            }
        } else {
            System.out.println("No hay clientes registrados.");
        }
    }

    private void gestionPedidos() {
        boolean salir = false;
        int opcion;
        do {
            System.out.println("1. Añadir Pedido");
            System.out.println("2. Eliminar Pedido");
            System.out.println("3. Mostrar Pedidos Pendientes");
            System.out.println("4. Mostrar Pedidos Enviados");
            System.out.println("0. Volver al menú principal");
            opcion = teclado.nextInt();
            switch (opcion) {
                case 1:
                    añadirPedido();
                    break;
                case 2:
                    eliminarPedido();
                    break;
                case 3:
                    mostrarPedidosPendientes();
                    break;
                case 4:
                    mostrarPedidosEnviados();
                    break;
                case 0:
                    salir = true;
            }
        } while (!salir);
    }

    private void añadirPedido() {
        teclado.nextLine(); // Consumir la nueva línea pendiente del buffer

        mostrarClientes();
        System.out.println("Ingrese el correo electrónico del cliente: ");
        String correoElectronicoCliente = teclado.nextLine();

        // Buscar el cliente en la lista
        Cliente cliente = controlador.buscarClientePorCorreo(correoElectronicoCliente);

        if (cliente != null) {
            mostrarArticulos();
            System.out.println("Ingrese el código del artículo: ");
            String codigoArticulo = teclado.nextLine();

            // Buscar el artículo en la lista
            Articulo articulo = controlador.buscarArticuloPorCodigo(codigoArticulo);

            if (articulo != null) {
                System.out.println("Ingrese la cantidad de unidades del artículo: ");
                int cantidad = Integer.parseInt(teclado.nextLine());

                Pedido nuevoPedido = new Pedido(
                        controlador.getDatos().getListaPedidos().getSize() + 1,
                        LocalDateTime.now(),
                        cliente,
                        articulo,
                        cantidad
                );

                controlador.agregarPedido(nuevoPedido);
                System.out.println("Pedido agregado correctamente.");
            } else {
                System.out.println("No se encontró un artículo con ese código.");
            }
        } else {
            System.out.println("No se encontró un cliente con ese correo electrónico.");
        }
    }

    private void eliminarPedido() {
        mostrarPedidosPendientes();

        System.out.println("Ingrese el número de pedido que desea eliminar: ");
        int numeroPedido = Integer.parseInt(teclado.nextLine());

        // Aquí puedes agregar la lógica para eliminar el pedido con el número proporcionado
        // Llama al método eliminarPedido con el número del pedido
        controlador.eliminarPedido(numeroPedido);

        System.out.println("Pedido eliminado correctamente.");
    }

    public static void main(String[] args) {
        GestionOS gestion = new GestionOS();
        gestion.inicio();
    }

    private void mostrarPedidosPendientes() {
        ListaPedidos listaPedidosPendientes = controlador.getListaPedidosPendientes();

        if (listaPedidosPendientes.getSize() > 0) {
            System.out.println("Pedidos Pendientes:");
            for (int i = 0; i < listaPedidosPendientes.getSize(); i++) {
                Pedido pedido = listaPedidosPendientes.getAt(i);
                System.out.println("Número de Pedido: " + pedido.getNumeroPedido());
                System.out.println("Fecha: " + pedido.getFecha());
                System.out.println("Cliente: " + pedido.getCliente().getNombre());
                System.out.println("Artículo: " + pedido.getArticulo().getDescripcion());
                System.out.println("Cantidad: " + pedido.getCantidad());
                System.out.println("------------------------------");
            }
        } else {
            System.out.println("No hay pedidos pendientes.");
        }
    }

    private void mostrarPedidosEnviados() {
        ListaPedidos listaPedidos = controlador.getDatos().getListaPedidos();
        if (listaPedidos.getSize() > 0) {
            System.out.println("Pedidos Enviados:");
            for (int i = 0; i < listaPedidos.getSize(); i++) {
                Pedido pedido = listaPedidos.getAt(i);
                if (pedido.pedidoEnviado()) {
                    System.out.println(pedido);
                }
            }
        } else {
            System.out.println("No hay pedidos registrados.");
        }
    }
}
