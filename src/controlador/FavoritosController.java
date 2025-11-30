package controlador;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import modelo.Producto;
import modelo.Repositorio;
import modelo.Sesion;

import java.io.IOException;
import java.util.Locale;

public class FavoritosController {

    @FXML private TextField txtBuscar;
    @FXML private VBox contenedorFavoritos;

    @FXML
    private void initialize() {
        Repositorio.inicializarProductos();
        mostrarFavoritos();
    }

   @FXML
private void buscarFavorito() {
    String filtro = txtBuscar.getText().toLowerCase();

    for (var nodo : contenedorFavoritos.getChildren()) {
        if (nodo instanceof HBox hbox) {
            
            VBox vbox = (VBox) hbox.getChildren().get(1); 
            Text nombreText = (Text) vbox.getChildren().get(0);
            String nombre = nombreText.getText().toLowerCase();

            boolean coincide = nombre.contains(filtro);
            hbox.setVisible(coincide);
            hbox.setManaged(coincide); 
        }
    }
}


    private void mostrarFavoritos() {
        contenedorFavoritos.getChildren().clear();
        if (Sesion.usuarioActual == null) return;

        for (Producto p : Sesion.usuarioActual.getFavoritos()) {
            HBox hbox = crearCajaProducto(p);
            contenedorFavoritos.getChildren().add(hbox);
        }
    }

    private HBox crearCajaProducto(Producto p) {
    HBox hbox = new HBox();
    hbox.setSpacing(10);

    // Borde negro
    hbox.setStyle("-fx-border-color: black; -fx-border-width: 1; -fx-padding: 10;");

    ImageView imgView = new ImageView();
    try {
        imgView.setImage(new Image(p.getImagen()));
    } catch (Exception e) {
        System.err.println("Error cargando imagen: " + p.getImagen());
    }
    imgView.setFitHeight(80);
    imgView.setFitWidth(80);

    VBox vbox = new VBox();
    vbox.setSpacing(5);
    Text nombre = new Text(p.getNombre());
    Text precio = new Text("$" + p.getPrecio());

    Button btnCompra = new Button("Comprar");
    btnCompra.setOnAction(e -> comprarProducto(p));

    Button btnEliminar = new Button("Eliminar");
    btnEliminar.setOnAction(e -> {
        Sesion.usuarioActual.quitarFavorito(p);
        mostrarFavoritos();
    });

    vbox.getChildren().addAll(nombre, precio, btnCompra, btnEliminar);

    hbox.getChildren().addAll(imgView, vbox);
    return hbox;
}


    private void comprarProducto(Producto p) {
        if (Sesion.usuarioActual != null) {
            Sesion.usuarioActual.agregarAlCarrito(p);
            mostrarInfo("Carrito", p.getNombre() + " agregado al carrito. Precio: $" + p.getPrecio());
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
    private void irAClubes() {
        cargarVentana("/vista/Clubes.fxml");
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
