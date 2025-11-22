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

public class LoginController {

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtCorreo;

    @FXML
    private TextField txtApodo;

    @FXML
    private TextField txtContra;

    @FXML
    private Button btnUsuario;

    @FXML
    private Button btnAdmin;

    @FXML
    private void initialize() {
        // Para debug opcional
        System.out.println("LoginController inicializado.");
    }

    // Evento botón "Usuario"
  
    @FXML
    private void onUsuario(ActionEvent event) {
        if (!validarCampos()) return;

        
        mostrarInfo("Inicio de sesión", "Inicio de sesión como Usuario exitoso.");
              cambiarVentana("/vista/seleccion.fxml", "Retro Store - Catálogo");
    }

   
    // Evento botón "Admin"
   
    @FXML
    private void onAdmin(ActionEvent event) {
        cambiarVentana("/vista/Admin.fxml", "Retro Store - Admin");
    }

  
    // Validación de campos
  
    private boolean validarCampos() {
        if (txtId.getText().isEmpty() ||
            txtCorreo.getText().isEmpty() ||
            txtApodo.getText().isEmpty() ||
            txtContra.getText().isEmpty()) {

            mostrarError("Campos vacíos", "Debe llenar todos los campos para continuar.");
            return false;
        }
        return true;
    }

 
    // Cambiar pantalla
   
    private void cambiarVentana(String rutaFXML, String tituloVentana) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(rutaFXML));
            Stage stage = new Stage();
            stage.setTitle(tituloVentana);
            stage.setScene(new Scene(root));
            stage.show();

            // Cerrar la ventana actual
            Stage actual = (Stage) btnUsuario.getScene().getWindow();
            actual.close();

        } catch (Exception e) {
            e.printStackTrace();
            mostrarError("Error", "No se pudo abrir la ventana: " + rutaFXML);
        }
    }


    // Alertas
    
    private void mostrarError(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setHeaderText(null);
        alerta.setTitle(titulo);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    private void mostrarInfo(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setHeaderText(null);
        alerta.setTitle(titulo);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}
