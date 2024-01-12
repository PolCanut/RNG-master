package RNG.vista;

import RNG.modelo.Pedido;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import RNG.controlador.Controlador;
import RNG.modelo.Articulo;
import RNG.modelo.Cliente;
import RNG.modelo.Pedido;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.w3c.dom.Text;

import javax.swing.*;
import java.io.IOException;

public class GestionOSController {

    @FXML
    private TextField CajaCodigoEliminar;

    @FXML
    private TextField CajaCodigo;

    @FXML
    private TextField CajaDescripcion;

    @FXML
    private TextField CajaPrecio;

    @FXML
    private TextField CajaNombre;

    @FXML
    private TextField CajaCorreo;

    @FXML
    private TextField CajaDireccion;

    @FXML
    private TextField CajaPremium;

    @FXML
    private TextField CajaNumero;

    @FXML
    private TextField CajaFechaHoraPedido;

    @FXML
    private TextField CajaCliente;

    @FXML
    private TextField CajaArticulo;

    @FXML
    private TextField CajaCantidad;

    private Controlador controlador;  // Tener una instancia de tu controlador

    @FXML
    public void initialize() {
        // Inicializa tu controlador aquí
        this.controlador = new Controlador();
    }

    @FXML
    void guardarArticulo(ActionEvent event) {
        String codigo = CajaCodigo.getText();
        String descripcion = CajaDescripcion.getText();
        String precioStr = CajaPrecio.getText();

        // Verifica si todos los campos están llenos
        if (!codigo.isEmpty() && !descripcion.isEmpty() && !precioStr.isEmpty()) {
            try {
                double precio = Double.parseDouble(precioStr);

                // Aquí llamamos al método en tu controlador para guardar el artículo
                controlador.agregarArticulo(new Articulo(codigo, descripcion, precio));

                // Muestra una alerta de éxito
                mostrarAlerta("Éxito", "Artículo guardado correctamente.");

                // Limpia los campos después de guardar
                limpiarCamposNuevoArticulo();
            } catch (NumberFormatException e) {
                mostrarAlerta("Error", "Ingrese un valor numérico válido para el precio.");
            }
        } else {
            // Muestra una alerta de error si algún campo está vacío
            mostrarAlerta("Error", "Complete todos los campos antes de guardar.");
        }
    }

    @FXML
    void guardarCliente(ActionEvent event) {
        String nombre = CajaNombre.getText();
        String correo = CajaCorreo.getText();
        String direccion = CajaDireccion.getText();
        String premiumStr = CajaPremium.getText();

        // Verifica si todos los campos están llenos
        if (!nombre.isEmpty() && !correo.isEmpty() && !direccion.isEmpty() && !premiumStr.isEmpty()) {
            try {
                boolean premium = Boolean.parseBoolean(premiumStr);

                // Aquí llamamos al método en tu controlador para guardar el cliente
                controlador.agregarCliente(new Cliente(nombre, correo, direccion, premium));

                // Muestra una alerta de éxito
                mostrarAlerta("Éxito", "Cliente guardado correctamente.");

                // Limpia los campos después de guardar
                limpiarCamposNuevoCliente();
            } catch (NumberFormatException e) {
                mostrarAlerta("Error", "Ingrese un valor válido para la opción Premium (true o false).");
            }
        } else {
            // Muestra una alerta de error si algún campo está vacío
            mostrarAlerta("Error", "Complete todos los campos antes de guardar.");
        }
    }

//    @FXML
//  void guardarPedido(ActionEvent event) {
//      String numero = CajaNumero.getText();
//      String fechaHoraPedido = CajaFechaHoraPedido.getText();
//      String clienteNombre = CajaCliente.getText();
//      String articulo = CajaArticulo.getText();
//      String cantidadStr = CajaCantidad.getText();

//      // Verifica si todos los campos están llenos
//      if (!numero.isEmpty() && !fechaHoraPedido.isEmpty() && !clienteNombre.isEmpty() && !articulo.isEmpty() && !cantidadStr.isEmpty()) {
//          try {
//              int cantidad = Integer.parseInt(cantidadStr);

//              // Aquí llamamos al método en tu controlador para guardar el pedido
//              controlador.agregarPedido(new Pedido(numero, fechaHoraPedido, clienteNombre, articulo, cantidad));

//              // Muestra una alerta de éxito
//              mostrarAlerta("Éxito", "Pedido guardado correctamente.");

//              // Limpia los campos después de guardar
//              limpiarCamposNuevoPedido();
//          } catch (NumberFormatException e) {
//              mostrarAlerta("Error", "Ingrese un valor válido para la cantidad.");
//          }
//      } else {
//          // Muestra una alerta de error si algún campo está vacío
//          mostrarAlerta("Error", "Complete todos los campos antes de guardar.");
//      }
//  }

    @FXML
    void EliminarArticulo(ActionEvent event) {
        String codigoEliminar = CajaCodigoEliminar.getText();

        // Verifica si el código a eliminar no está vacío
        if (!codigoEliminar.isEmpty()) {
            // Aquí llamamos al método en tu controlador para eliminar el artículo
            controlador.eliminarArticulo(codigoEliminar);

            // Muestra una alerta de éxito
            mostrarAlerta("Éxito", "Artículo eliminado correctamente.");

            // Limpia los campos después de eliminar
            limpiarCamposEliminarArticulo();
        } else {
            // Muestra una alerta de error si el código está vacío
            mostrarAlerta("Error", "Ingrese un código de artículo válido.");
        }
    }

    private void loadScene(String fxmlFileName, Event event) {
        try {
            // Cargar la vista correspondiente
            Parent gestionView = FXMLLoader.load(getClass().getResource(fxmlFileName));

            // Obtener la escena actual
            Scene currentScene = ((Node) event.getSource()).getScene();

            // Establecer la nueva escena
            currentScene.setRoot(gestionView);
        } catch (IOException e) {
            e.printStackTrace();
            // Manejar la excepción según tus necesidades
        }
    }

    private void mostrarAlerta(String titulo, String contenido) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(contenido);
        alert.showAndWait();
    }

    private void limpiarCamposNuevoArticulo() {
        CajaCodigo.clear();
        CajaDescripcion.clear();
        CajaPrecio.clear();
    }

    private void limpiarCamposNuevoCliente(){
        CajaNombre.clear();
        CajaCorreo.clear();
        CajaDireccion.clear();
        CajaPremium.clear();
    }

    private void limpiarCamposNuevoPedido(){
        CajaCodigo.clear();
        CajaCorreo.clear();
        CajaCantidad.clear();
    }

    @FXML
    void Close_Clicked(MouseEvent event) {
        // Lógica para cerrar la ventana actual
        ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();
    }

    private void limpiarCamposEliminarArticulo() {
        CajaCodigoEliminar.clear();
    }

    public void showArticuloscreados(ActionEvent actionEvent) {
    }

    public void showDeleteCliente(ActionEvent actionEvent) {
    }

    @FXML
    void showArticulos(ActionEvent event) {
        loadScene("GestionArticulos.fxml", event);
    }

    @FXML
    void showNuevo(ActionEvent event){
        loadScene("NuevoArticulo.fxml", event);
    }

    @FXML
    void showClientes(ActionEvent event) {
        loadScene("GestionClientes.fxml", event);
    }

    @FXML
    void showPedidos(ActionEvent event) {
        loadScene("GestionPedidos.fxml", event);
    }

    @FXML
    void showDelete(ActionEvent event) {
        loadScene("EliminarArticulo.fxml", event);
    }

    @FXML
    void showMenu(ActionEvent event) {
        loadScene("OnlineStore.fxml", event);
    }

    @FXML
    void showNuevoCliente(ActionEvent event) {
        loadScene("NuevoCliente.fxml", event);
    }

    @FXML
    void showEliminarCliente(ActionEvent event) {
        loadScene("EliminarCliente.fxml", event);
    }

    @FXML
    void showNuevoPedido(ActionEvent event) {
        loadScene("NuevoPedido.fxml", event);
    }

    @FXML
    void showEliminarPedido(ActionEvent event) {
        loadScene("EliminarPedido.fxml", event);
    }
}
