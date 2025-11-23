package controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class BarraNavegacionController {

    @FXML private Button btnHome;
    @FXML private Button btnFavoritos;
    @FXML private Button btnCarrito;
    @FXML private Button btnHistorial;
    @FXML private Button btnUsuario;

    private void cambiarVentana(String ruta) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(ruta));
            Stage ventana = (Stage) btnHome.getScene().getWindow();
            ventana.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void irHome(ActionEvent e) {
        cambiarVentana("/vista/seleccion.fxml");
    }

    @FXML
    private void irFavoritos(ActionEvent e) {
        cambiarVentana("/vista/Favoritos.fxml");
    }

    @FXML
    private void irCarrito(ActionEvent e) {
        cambiarVentana("/vista/carrito.fxml");
    }

    @FXML
    private void irHistorial(ActionEvent e) {
        cambiarVentana("/vista/Historial.fxml");
    }


    @FXML
  
    private void irUsuario(ActionEvent e) { cambiarVentana("/vista/usuario.fxml"); }

}