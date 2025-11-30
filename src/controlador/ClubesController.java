package controlador;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import modelo.*;

import java.util.Locale;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ClubesController {

    @FXML private TextField txtBuscar;
    @FXML private VBox contenedorPrincipal;

    @FXML
    private void initialize() {
        
        Repositorio.inicializarProductos();
    }

@FXML
private void onBuscar() {
    String filtro = txtBuscar.getText() == null ? "" : txtBuscar.getText().toLowerCase(Locale.ROOT);

    for (var fila : contenedorPrincipal.getChildren()) {
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

    @FXML private void carritoChelsea()   { agregarCarritoPorNombre("Chelsea 2007-2008"); }
    @FXML private void carritoArsenal()   { agregarCarritoPorNombre("Arsenal 2004-2005"); }
    @FXML private void carritoLiverpool() { agregarCarritoPorNombre("Liverpool 2006-2007"); }
    @FXML private void carritoBarcelona() { agregarCarritoPorNombre("Barcelona 2008-2009"); }
    @FXML private void carritoUnited()    { agregarCarritoPorNombre("United 2002-2004"); }
    @FXML private void carritoMilan()     { agregarCarritoPorNombre("Milan 2006-2007"); }
    @FXML private void carritoCity()      { agregarCarritoPorNombre("City 1997-1998"); }

    private void agregarCarritoPorNombre(String nombre) {
        Producto p = Repositorio.buscarProductoPorNombre(nombre);
        if (p != null && Sesion.usuarioActual != null) {
            Sesion.usuarioActual.agregarAlCarrito(p);
            mostrarInfo("Carrito", p.getNombre() + " agregado al carrito. Precio: $" + p.getPrecio());
        }
    }

    @FXML private void favoritoChelsea()   { agregarFavoritoPorNombre("Chelsea 2007-2008"); }
    @FXML private void favoritoArsenal()   { agregarFavoritoPorNombre("Arsenal 2004-2005"); }
    @FXML private void favoritoLiverpool() { agregarFavoritoPorNombre("Liverpool 2006-2007"); }
    @FXML private void favoritoBarcelona() { agregarFavoritoPorNombre("Barcelona 2008-2009"); }
    @FXML private void favoritoUnited()    { agregarFavoritoPorNombre("United 2002-2004"); }
    @FXML private void favoritoMilan()     { agregarFavoritoPorNombre("Milan 2006-2007"); }
    @FXML private void favoritoCity()      { agregarFavoritoPorNombre("City 1997-1998"); }

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
    private void irASelecciones() {
        cargarVentana("/vista/Seleccion.fxml");
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
