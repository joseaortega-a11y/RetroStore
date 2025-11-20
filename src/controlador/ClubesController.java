package controlador;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import modelo.Producto;
import modelo.Repositorio;

public class ClubesController {

    // ============================================================
    // MÉTODO PARA MOSTRAR ALERTAS
    // ============================================================
    private void mensaje(String titulo, String texto) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setHeaderText(null);
        a.setTitle(titulo);
        a.setContentText(texto);
        a.show();
    }

    // ============================================================
    // MÉTODOS AUXILIARES PARA CREAR PRODUCTOS
    // ============================================================
    private Producto crearProducto(String id, String nombre, int anio, String imagen) {
        return new Producto(
                id,
                nombre,
                "Camiseta retro " + nombre,
                "Clubes",
                "Desconocido",
                anio,
                49.99,
                imagen
        );
    }

    private void agregarCarrito(Producto p) {
        Repositorio.compras.add(p);
        mensaje("Carrito", "Agregado al carrito: " + p.getNombre());
    }

    private void agregarFavoritos(Producto p) {
        Repositorio.favoritos.add(p);
        mensaje("Favoritos", "Agregado a favoritos: " + p.getNombre());
    }

    // ============================================================
    // ARSENAL
    // ============================================================
    @FXML
    private void carritoArsenal() {
        agregarCarrito(crearProducto("ARS2004", "Arsenal 2004-2005", 2004, "../imagenes/arsenal.png"));
    }

    @FXML
    private void favoritoArsenal() {
        agregarFavoritos(crearProducto("ARS2004", "Arsenal 2004-2005", 2004, "../imagenes/arsenal.png"));
    }

    // ============================================================
    // CHELSEA
    // ============================================================
    @FXML
    private void carritoChelsea() {
        agregarCarrito(crearProducto("CHE2007", "Chelsea 2007-2008", 2007, "../imagenes/chelsea.png"));
    }

    @FXML
    private void favoritoChelsea() {
        agregarFavoritos(crearProducto("CHE2007", "Chelsea 2007-2008", 2007, "../imagenes/chelsea.png"));
    }

    // ============================================================
    // LIVERPOOL
    // ============================================================
    @FXML
    private void carritoLiverpool() {
        agregarCarrito(crearProducto("LIV2006", "Liverpool 2006-2007", 2006, "../imagenes/liverpool.png"));
    }

    @FXML
    private void favoritoLiverpool() {
        agregarFavoritos(crearProducto("LIV2006", "Liverpool 2006-2007", 2006, "../imagenes/liverpool.png"));
    }

    // ============================================================
    // BARCELONA
    // ============================================================
    @FXML
    private void carritoBarcelona() {
        agregarCarrito(crearProducto("BAR2008", "Barcelona 2008-2009", 2008, "../imagenes/barsa.png"));
    }

    @FXML
    private void favoritoBarcelona() {
        agregarFavoritos(crearProducto("BAR2008", "Barcelona 2008-2009", 2008, "../imagenes/barsa.png"));
    }

    // ============================================================
    // UNITED
    // ============================================================
    @FXML
    private void carritoUnited() {
        agregarCarrito(crearProducto("UNI2002", "United 2002-2004", 2002, "../imagenes/united.png"));
    }

    @FXML
    private void favoritoUnited() {
        agregarFavoritos(crearProducto("UNI2002", "United 2002-2004", 2002, "../imagenes/united.png"));
    }

    // ============================================================
    // REAL MADRID
    // ============================================================
    @FXML
    private void carritoMadrid() {
        agregarCarrito(crearProducto("RMA2011", "Real Madrid 2011-2012", 2011, "../imagenes/madrid.png"));
    }

    @FXML
    private void favoritoMadrid() {
        agregarFavoritos(crearProducto("RMA2011", "Real Madrid 2011-2012", 2011, "../imagenes/madrid.png"));
    }

    // ============================================================
    // MILAN
    // ============================================================
    @FXML
    private void carritoMilan() {
        agregarCarrito(crearProducto("MIL2006", "Milan 2006-2007", 2006, "../imagenes/milan.png"));
    }

    @FXML
    private void favoritoMilan() {
        agregarFavoritos(crearProducto("MIL2006", "Milan 2006-2007", 2006, "../imagenes/milan.png"));
    }

    // ============================================================
    // CITY
    // ============================================================
    @FXML
    private void carritoCity() {
        agregarCarrito(crearProducto("CIT1997", "City 1997-1998", 1997, "../imagenes/city.png"));
    }

    @FXML
    private void favoritoCity() {
        agregarFavoritos(crearProducto("CIT1997", "City 1997-1998", 1997, "../imagenes/city.png"));
    }
}
