package controlador;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Locale;

public class ClubesController {

    @FXML
    private TextField txtBuscar;

    @FXML
    private VBox contenedorPrincipal;

  
    @FXML
    private void onBuscar() {

        String filtro = txtBuscar.getText().toLowerCase(Locale.ROOT);

        for (var fila : contenedorPrincipal.getChildren()) {

            if (fila instanceof javafx.scene.layout.HBox hbox) {

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


 

    @FXML private void carritoChelsea()   { agregarCarrito("Chelsea 2007-2008"); }
    @FXML private void carritoArsenal()   { agregarCarrito("Arsenal 2004-2005"); }
    @FXML private void carritoLiverpool() { agregarCarrito("Liverpool 2006-2007"); }
    @FXML private void carritoBarcelona() { agregarCarrito("Barcelona 2008-2009"); }
    @FXML private void carritoUnited()    { agregarCarrito("United 2002-2004"); }
    @FXML private void carritoMilan()     { agregarCarrito("Milan 2006-2007"); }
    @FXML private void carritoCity()      { agregarCarrito("City 1997-1998"); }

    private void agregarCarrito(String item) {
        System.out.println("🛒 Añadido al carrito → " + item);
    }

    
    
  
    @FXML private void favoritoChelsea()   { agregarFavorito("Chelsea 2007-2008"); }
    @FXML private void favoritoArsenal()   { agregarFavorito("Arsenal 2004-2005"); }
    @FXML private void favoritoLiverpool() { agregarFavorito("Liverpool 2006-2007"); }
    @FXML private void favoritoBarcelona() { agregarFavorito("Barcelona 2008-2009"); }
    @FXML private void favoritoUnited()    { agregarFavorito("United 2002-2004"); }
    @FXML private void favoritoMilan()     { agregarFavorito("Milan 2006-2007"); }
    @FXML private void favoritoCity()      { agregarFavorito("City 1997-1998"); }

    private void agregarFavorito(String item) {
        System.out.println("⭐ Añadido a favoritos → " + item);
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