package controlador;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import modelo.Compra;
import modelo.Producto;
import modelo.Sesion;

import java.time.LocalDate;

public class CarritoController {

    @FXML private ListView<String> listaCarrito;
    @FXML private TextField txtBuscar;
    @FXML private Button btnContinuarCompra;
    @FXML private Button btnEliminarCompra;
    @FXML private Label lblTotal;

    @FXML
    private void initialize() {
        actualizarListaCarrito();

        // Filtro en tiempo real
        txtBuscar.textProperty().addListener((obs, viejo, nuevo) -> filtrarCarrito(nuevo));

       
        btnEliminarCompra.setOnAction(e -> eliminarProductoSeleccionado());

     
        btnContinuarCompra.setOnAction(e -> continuarProductoSeleccionado());
    }

    private void actualizarListaCarrito() {
        listaCarrito.getItems().clear();
        if (Sesion.usuarioActual == null) {
            lblTotal.setText("Total: $0.0");
            return;
        }

        double total = 0.0;

        for (Producto p : Sesion.usuarioActual.getCarrito()) {
            listaCarrito.getItems().add(p.getNombre() + " - $" + p.getPrecio());
            total += p.getPrecio();
        }

        lblTotal.setText("Total: $" + total);
    }

    private void filtrarCarrito(String filtro) {
        listaCarrito.getItems().clear();
        if (Sesion.usuarioActual == null) {
            lblTotal.setText("Total: $0.0");
            return;
        }

        String filtroLower = filtro == null ? "" : filtro.toLowerCase();

        double total = 0.0;

        for (Producto p : Sesion.usuarioActual.getCarrito()) {
            if (p.getNombre().toLowerCase().contains(filtroLower)) {
                listaCarrito.getItems().add(p.getNombre() + " - $" + p.getPrecio());
                total += p.getPrecio();
            }
        }

        lblTotal.setText("Total: $" + total);
    }

    private void eliminarProductoSeleccionado() {
        int index = listaCarrito.getSelectionModel().getSelectedIndex();
        if (index >= 0 && Sesion.usuarioActual != null) {
            Producto p = Sesion.usuarioActual.getCarrito().get(index);
            Sesion.usuarioActual.quitarDelCarrito(p);
            actualizarListaCarrito();
            mostrarInfo("Carrito", p.getNombre() + " eliminado del carrito.");
        } else {
            mostrarInfo("Carrito", "Seleccione un producto para eliminar.");
        }
    }

    private void continuarProductoSeleccionado() {
        int index = listaCarrito.getSelectionModel().getSelectedIndex();
        if (index >= 0 && Sesion.usuarioActual != null) {
            Producto p = Sesion.usuarioActual.getCarrito().get(index);
            Sesion.usuarioActual.agregarCompra(new Compra(p, LocalDate.now()));
            Sesion.usuarioActual.quitarDelCarrito(p);
            actualizarListaCarrito();
            mostrarInfo("Compra", p.getNombre() + " agregado al historial.");
        } else {
            mostrarInfo("Carrito", "Seleccione un producto para continuar la compra.");
        }
    }

    private void mostrarInfo(String titulo, String mensaje) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle(titulo);
        a.setHeaderText(null);
        a.setContentText(mensaje);
        a.showAndWait();
    }
}
