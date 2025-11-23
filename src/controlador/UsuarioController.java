/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controlador;

/**
 * FXML Controller class
 *
 * @author Josea
 */
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class UsuarioController {

    @FXML
    private Button btnCerrar;
    @FXML
    private Button btnInicio;

    @FXML
    private void cerrarSesion() {
        try {
            // Cargar el login
            Parent root = FXMLLoader.load(getClass().getResource("/vista/Login.fxml"));
            Scene nuevaEscena = new Scene(root);

            // Obtener la ventana actual desde el botón
            Stage ventanaActual = (Stage) btnCerrar.getScene().getWindow();

            ventanaActual.setScene(nuevaEscena);
            ventanaActual.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     @FXML
    private void Inicio() {
        try {
            // Cargar seleccion
            Parent root = FXMLLoader.load(getClass().getResource("/vista/seleccion.fxml"));
            Scene nuevaEscena = new Scene(root);

            // Obtener la ventana actual desde el botón
            Stage ventanaActual = (Stage) btnInicio.getScene().getWindow();

            ventanaActual.setScene(nuevaEscena);
            ventanaActual.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
