package controlador;

import java.io.IOException;
import java.util.Locale;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import modelo.Producto;
import modelo.Repositorio;
import modelo.Sesion;

public class SeleccionController {

    @FXML private TextField txtBuscar;
    @FXML private VBox contenedorSeleccion;

    @FXML
    private void initialize() {
        
        Repositorio.inicializarProductos();
    }

   
    @FXML
    private void buscarProducto() {
        String filtro = txtBuscar.getText() == null ? "" : txtBuscar.getText().toLowerCase(Locale.ROOT);
        for (var fila : contenedorSeleccion.getChildren()) {
            if (fila instanceof HBox hbox) {
                for (var nodo : hbox.getChildren()) {
                    if (nodo instanceof VBox vbox) {
                        String nombre = vbox.getChildren()
                                .stream()
                                .filter(c -> c instanceof Text)
                                .map(c -> ((Text) c).getText())
                                .findFirst()
                                .orElse("")
                                .toLowerCase(Locale.ROOT);

                        boolean coincide = nombre.contains(filtro);
                        vbox.setVisible(coincide);
                        vbox.setManaged(coincide);
                    }
                }
            }
        }
    }

    @FXML private void carritoPortugal()  { agregarCarritoPorNombre("Portugal 2022"); }
    @FXML private void carritoBrasil()    { agregarCarritoPorNombre("Brasil 2022"); }
    @FXML private void carritoFrancia()   { agregarCarritoPorNombre("Francia 2022"); }
    @FXML private void carritoArgentina() { agregarCarritoPorNombre("Argentina 2022"); }
    @FXML private void carritoAlemania()  { agregarCarritoPorNombre("Alemania 2022"); }
    @FXML private void carritoItalia()    { agregarCarritoPorNombre("Italia 2022"); }
    @FXML private void carritoEspana()    { agregarCarritoPorNombre("España 2022"); }
    @FXML private void carritoCroacia()   { agregarCarritoPorNombre("Croacia 2022"); }

    private void agregarCarritoPorNombre(String nombre) {
        Producto p = Repositorio.buscarProductoPorNombre(nombre);
        if (p != null && Sesion.usuarioActual != null) {
            Sesion.usuarioActual.agregarAlCarrito(p);
            mostrarInfo("Carrito", p.getNombre() + " agregado al carrito. Precio: $" + p.getPrecio());
        }
    }

  
    @FXML private void favoritoPortugal()  { agregarFavoritoPorNombre("Portugal 2022"); }
    @FXML private void favoritoBrasil()    { agregarFavoritoPorNombre("Brasil 2022"); }
    @FXML private void favoritoFrancia()   { agregarFavoritoPorNombre("Francia 2022"); }
    @FXML private void favoritoArgentina() { agregarFavoritoPorNombre("Argentina 2022"); }
    @FXML private void favoritoAlemania()  { agregarFavoritoPorNombre("Alemania 2022"); }
    @FXML private void favoritoItalia()    { agregarFavoritoPorNombre("Italia 2022"); }
    @FXML private void favoritoEspana()    { agregarFavoritoPorNombre("España 2022"); }
    @FXML private void favoritoCroacia()   { agregarFavoritoPorNombre("Croacia 2022"); }

    private void agregarFavoritoPorNombre(String nombre) {
        Producto p = Repositorio.buscarProductoPorNombre(nombre);
        if (p != null && Sesion.usuarioActual != null) {
            Sesion.usuarioActual.agregarFavorito(p);
            mostrarInfo("Favoritos", p.getNombre() + " agregado a favoritos.");
        }
    }

    
    private void mostrarInfo(String titulo, String mensaje) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle(titulo);
        a.setHeaderText(null);
        a.setContentText(mensaje);
        a.show();
    }

    @FXML
    private void VerClubes() {
        cargarVentana("/vista/Clubes.fxml");
    }

    private void cargarVentana(String rutaFXML) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(rutaFXML));
            Stage stage = (Stage) txtBuscar.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException ex) {
            System.err.println("ERROR cargando ventana: " + rutaFXML);
            ex.printStackTrace();
        }
    }
}
