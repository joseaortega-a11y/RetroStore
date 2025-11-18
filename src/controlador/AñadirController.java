/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controlador;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;




public class AñadirController {

    @FXML
    private ImageView imgInter;

    @FXML
    private ImageView imgAjax;

    @FXML
    private Button btnSeleccion;

    @FXML
    private Button btnClubes;

    // Variable para saber qué producto seleccionó el admin
    private String productoSeleccionado = null;

    @FXML
    private void initialize() {
        System.out.println("AñadirController cargado");

        // Detectar clic en imágenes
        imgInter.setOnMouseClicked(e -> seleccionarProducto("Inter 1997-1998"));
        imgAjax.setOnMouseClicked(e -> seleccionarProducto("Ajax 1997-1998"));
    }

    // ---- SELECCIÓN DE PRODUCTO ----
    private void seleccionarProducto(String producto) {
        productoSeleccionado = producto;
        mostrarMensaje("Producto seleccionado", "Seleccionaste: " + producto);
    }

    // ---- BOTÓN: AGREGAR COMO SELECCIÓN ----
    @FXML
    private void agregarSeleccion() {
        if (productoSeleccionado == null) {
            mostrarError("Error", "Primero debes seleccionar un producto haciendo clic en una imagen.");
            return;
        }

        mostrarMensaje(
                "Agregado correctamente",
                "El producto \"" + productoSeleccionado + "\" fue agregado como SELECCIÓN."
        );
    }

    // ---- BOTÓN: AGREGAR COMO CLUBES ----
    @FXML
    private void agregarClubes() {
        if (productoSeleccionado == null) {
            mostrarError("Error", "Primero debes seleccionar un producto haciendo clic en una imagen.");
            return;
        }

        mostrarMensaje(
                "Agregado correctamente",
                "El producto \"" + productoSeleccionado + "\" fue agregado como CLUB."
        );
    }

    // ---- ALERTA DE INFORMACIÓN ----
    private void mostrarMensaje(String titulo, String contenido) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle(titulo);
        alert.setContentText(contenido);
        alert.showAndWait();
    }

    // ---- ALERTA DE ERROR ----
    private void mostrarError(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setTitle(titulo);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}

