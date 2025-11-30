package controlador;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import modelo.Producto;
import modelo.Sesion;
import modelo.Usuario;
import modelo.Compra;
import java.time.LocalDate;

public class HistorialController implements Initializable {

    @FXML
    private ListView<String> listaHistorial;

    @FXML
    private TextField txtBuscar;

    private ObservableList<Producto> productosHistorial;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        productosHistorial = FXCollections.observableArrayList();
        Usuario usuario = Sesion.getUsuarioActual();
        if (usuario != null) {
            productosHistorial.addAll(usuario.getHistorial().stream()
                    .map(Compra::getProducto)
                    .collect(Collectors.toList()));
        }

        actualizarLista();

        // Filtrado dinámico
        txtBuscar.textProperty().addListener((obs, oldVal, newVal) -> filtrarLista(newVal));
    }

    private void actualizarLista() {
        ObservableList<String> items = FXCollections.observableArrayList();
        for (Producto p : productosHistorial) {
            items.add(p.getNombre() + " - $" + String.format("%.2f", p.getPrecio()));
        }
        listaHistorial.setItems(items);
    }

    private void filtrarLista(String filtro) {
        if (filtro == null || filtro.isEmpty()) {
            actualizarLista();
            return;
        }
        List<Producto> filtrados = productosHistorial.stream()
                .filter(p -> p.getNombre().toLowerCase().contains(filtro.toLowerCase()))
                .collect(Collectors.toList());

        ObservableList<String> items = FXCollections.observableArrayList();
        for (Producto p : filtrados) {
            items.add(p.getNombre() + " - $" + String.format("%.2f", p.getPrecio()));
        }
        listaHistorial.setItems(items);
    }

    // Método para agregar un producto al historial (desde CarritoController)
    public void agregarAlHistorial(Producto producto) {
        if (producto == null) return;

        Usuario usuario = Sesion.getUsuarioActual();
        if (usuario != null) {
            // Agregar al historial del usuario
            Compra compra = new Compra(producto, LocalDate.now());
            usuario.agregarCompra(compra);

            // Actualizar lista en la vista
            productosHistorial.add(producto);
            actualizarLista();
        }
    }
}
