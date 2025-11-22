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
import javafx.scene.control.Alert;
import modelo.Producto;
import modelo.Repositorio;

public class SeleccionController {

    // ============================
    //  ALERTA
    // ============================
    private void show(String t, String m) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setHeaderText(null);
        a.setTitle(t);
        a.setContentText(m);
        a.show();
    }

    // ============================
    //  CREAR PRODUCTO
    // ============================
    private Producto crearProducto(String id, String nombre, int anio, String imagen) {
        return new Producto(
                id,
                nombre,
                "Camiseta retro " + nombre,
                "Selecciones",
                "Desconocido",
                anio,
                49.99,
                imagen
        );
    }

    private void addCarrito(Producto p) {
        Repositorio.carrito.add(p);
        show("Carrito", p.getNombre() + " agregado al carrito.");
    }

    private void addFav(Producto p) {
        Repositorio.favoritos.add(p);
        show("Favoritos", p.getNombre() + " agregado a favoritos.");
    }

    // ============================
    //  ALEMANIA
    // ============================
    @FXML private void carritoAlemania() {
        addCarrito(crearProducto("ALE2006", "Alemania 2006", 2006, "../imagenes/alemania2006.png"));
    }

    @FXML private void favoritoAlemania() {
        addFav(crearProducto("ALE2006", "Alemania 2006", 2006, "../imagenes/alemania2006.png"));
    }

    // ============================
    //  ITALIA
    // ============================
    @FXML private void carritoItalia() {
        addCarrito(crearProducto("ITA1996", "Italia 1996", 1996, "../imagenes/italia1996.png"));
    }

    @FXML private void favoritoItalia() {
        addFav(crearProducto("ITA1996", "Italia 1996", 1996, "../imagenes/italia1996.png"));
    }

    // ============================
    //  ESPAÑA
    // ============================
    @FXML private void carritoEspaña() {
        addCarrito(crearProducto("ESP2006", "España 2006", 2006, "../imagenes/espana2006.png"));
    }

    @FXML private void favoritoEspaña() {
        addFav(crearProducto("ESP2006", "España 2006", 2006, "../imagenes/espana2006.png"));
    }

    // ============================
    //  CROACIA
    // ============================
    @FXML private void carritoCroacia() {
        addCarrito(crearProducto("CRO1996", "Croacia 1996", 1996, "../imagenes/croacia1996.png"));
    }

    @FXML private void favoritoCroacia() {
        addFav(crearProducto("CRO1996", "Croacia 1996", 1996, "../imagenes/croacia1996.png"));
    }

    // ============================
    //  PORTUGAL
    // ============================
    @FXML private void carritoPortugal() {
        addCarrito(crearProducto("POR2002", "Portugal 2002", 2002, "../imagenes/portugal2002.png"));
    }

    @FXML private void favoritoPortugal() {
        addFav(crearProducto("POR2002", "Portugal 2002", 2002, "../imagenes/portugal2002.png"));
    }

    // ============================
    //  BRASIL
    // ============================
    @FXML private void carritoBrasil() {
        addCarrito(crearProducto("BRA2002", "Brasil 2002", 2002, "../imagenes/brasil2002.png"));
    }

    @FXML private void favoritoBrasil() {
        addFav(crearProducto("BRA2002", "Brasil 2002", 2002, "../imagenes/brasil2002.png"));
    }

    // ============================
    //  FRANCIA
    // ============================
    @FXML private void carritoFrancia() {
        addCarrito(crearProducto("FRA2006", "Francia 2006", 2006, "../imagenes/francia2006.png"));
    }

    @FXML private void favoritoFrancia() {
        addFav(crearProducto("FRA2006", "Francia 2006", 2006, "../imagenes/francia2006.png"));
    }

    // ============================
    //  ARGENTINA
    // ============================
    @FXML private void carritoArgentina() {
        addCarrito(crearProducto("ARG2006", "Argentina 2006", 2006, "../imagenes/argentina2006.png"));
    }

    @FXML private void favoritoArgentina() {
        addFav(crearProducto("ARG2006", "Argentina 2006", 2006, "../imagenes/argentina2006.png"));
    }
}
