/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controlador;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AdminController {

    @FXML
    private TextField txtContra;

    @FXML
    private Button btnContinuar;

    @FXML
    private Button btnVolver;

    private final String PASS_ADMIN = "admin123"; // puedes cambiarla

    @FXML
    private void initialize() {
        System.out.println("AdminController cargado");
    }

    //  BOTÓN CONTINUAR
    @FXML
    private void onContinuar(ActionEvent event) {
        if (txtContra.getText().isEmpty()) {
            mostrarError("Campo vacío", "Debe ingresar la contraseña del administrador.");
            return;
        }

        if (!txtContra.getText().equals(PASS_ADMIN)) {
            mostrarError("Contraseña incorrecta", "La contraseña ingresada no es válida.");
            return;
        }

        // Si la contraseña es correcta → abrir panel admin
        cambiarVentana("/vista/añadir.fxml", "Panel de Administración");
    }

    //  BOTÓN VOLVER
    @FXML
    private void onVolver(ActionEvent event) {
        cambiarVentana("/vista/Login.fxml", "Retro Store");
    }

   // CAMBIAR DE VENTANA
  
    private void cambiarVentana(String ruta, String titulo) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(ruta));
            Stage stage = new Stage();
            stage.setTitle(titulo);
            stage.setScene(new Scene(root));
            stage.show();

            // Cerrar la ventana actual
            Stage actual = (Stage) btnVolver.getScene().getWindow();
            actual.close();

        } catch (Exception e) {
            e.printStackTrace();
            mostrarError("Error", "No se pudo abrir la ventana: " + ruta);
        }
    }

    // ALERTAS
  
    private void mostrarError(String titulo, String msg) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(msg);
        alerta.showAndWait();
    }
}

