package controlador;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SeleccionController {

    @FXML
    private TextField txtBuscar;

    @FXML
    private VBox contenedorSeleccion;


    /* ╔═══════════════════════════════════╗
       ║        BUSCADOR                   ║
       ╚═══════════════════════════════════╝ */
    @FXML
    private void buscarProducto() {
        String filtro = txtBuscar.getText().toLowerCase();

        contenedorSeleccion.getChildren().forEach(nodo -> nodo.setVisible(true));

        contenedorSeleccion.getChildren().forEach(fila -> {
            if (fila instanceof VBox || fila instanceof javafx.scene.layout.HBox) {
                javafx.scene.layout.HBox filaCamisetas = (javafx.scene.layout.HBox) fila;

                filaCamisetas.getChildren().forEach(c -> {
                    VBox camiseta = (VBox) c;

                    String nombre = ((javafx.scene.text.Text) camiseta.getChildren().get(1)).getText();

                    camiseta.setVisible(nombre.toLowerCase().contains(filtro));
                });
            }
        });
    }


    /* ╔═══════════════════════════════════╗
       ║  CAMISETAS → AÑADIR AL CARRITO    ║
       ╚═══════════════════════════════════╝ */
    @FXML private void carritoPortugal()  { System.out.println("Portugal añadida al carrito"); }
    @FXML private void carritoBrasil()    { System.out.println("Brasil añadida al carrito"); }
    @FXML private void carritoFrancia()   { System.out.println("Francia añadida al carrito"); }
    @FXML private void carritoArgentina() { System.out.println("Argentina añadida al carrito"); }
    @FXML private void carritoAlemania()  { System.out.println("Alemania añadida al carrito"); }
    @FXML private void carritoItalia()    { System.out.println("Italia añadida al carrito"); }
    @FXML private void carritoEspana()    { System.out.println("España añadida al carrito"); }
    @FXML private void carritoCroacia()   { System.out.println("Croacia añadida al carrito"); }


    /* ╔═══════════════════════════════════╗
       ║   CAMISETAS → FAVORITOS           ║
       ╚═══════════════════════════════════╝ */
    @FXML private void favoritoPortugal()  { System.out.println("Portugal a favoritos"); }
    @FXML private void favoritoBrasil()    { System.out.println("Brasil a favoritos"); }
    @FXML private void favoritoFrancia()   { System.out.println("Francia a favoritos"); }
    @FXML private void favoritoArgentina() { System.out.println("Argentina a favoritos"); }
    @FXML private void favoritoAlemania()  { System.out.println("Alemania a favoritos"); }
    @FXML private void favoritoItalia()    { System.out.println("Italia a favoritos"); }
    @FXML private void favoritoEspana()    { System.out.println("España a favoritos"); }
    @FXML private void favoritoCroacia()   { System.out.println("Croacia a favoritos"); }


    /* ╔═══════════════════════════════════╗
       ║       CAMBIAR A CLUBES            ║
       ╚═══════════════════════════════════╝ */
    @FXML
    private void VerClubes() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/Clubes.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) txtBuscar.getScene().getWindow();
            stage.setScene(new Scene(root));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
