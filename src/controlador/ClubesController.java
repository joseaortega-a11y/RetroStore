package controlador;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import modelo.Producto;
import modelo.Repositorio;

/**
 * ClubesController: añade productos a Repositorio.carrito y Repositorio.favoritos.
 * Usa los métodos ya presentes en tus FXML (onAction="#carritoArsenal", etc.)
 */
public class ClubesController {

    // Mensaje simple
    private void mensaje(String titulo, String texto){
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setHeaderText(null);
        a.setTitle(titulo);
        a.setContentText(texto);
        a.show();
    }

    // Crea un producto con los datos básicos (usa la ruta de imagen que uses en tu proyecto)
    private Producto crearProducto(String id, String nombre, int anio, String imagen){
        // Constructor Producto(id,nombre,descripcion,categoria,anio,precio,imagen)
        return new Producto(id, nombre, "Camiseta retro " + nombre, "Clubes", anio, 49.99, imagen);
    }

    // Métodos de negocio: agregan a las listas públicas en Repositorio
    private void agregarCarrito(Producto p){
        Repositorio.carrito.add(p);
        mensaje("Carrito", "Agregado al carrito: " + p.getNombre());
    }

    private void agregarFavoritos(Producto p){
        // evita duplicados visualmente
        if (!Repositorio.favoritos.contains(p)) {
            Repositorio.favoritos.add(p);
            mensaje("Favoritos", "Agregado a favoritos: " + p.getNombre());
        } else {
            mensaje("Favoritos", "El producto ya está en favoritos: " + p.getNombre());
        }
    }

    // ==========================
    // Métodos conectados a FXML
    // Los nombres deben coincidir con onAction en tu FXML
    // ==========================
    @FXML private void carritoArsenal() {
        agregarCarrito(crearProducto("ARS2004","Arsenal 2004-2005",2004,"/imagenes/arsenal.png"));
    }
    @FXML private void favoritoArsenal() {
        agregarFavoritos(crearProducto("ARS2004","Arsenal 2004-2005",2004,"/imagenes/arsenal.png"));
    }

    @FXML private void carritoChelsea() {
        agregarCarrito(crearProducto("CHE2007","Chelsea 2007-2008",2007,"/imagenes/chelsea.png"));
    }
    @FXML private void favoritoChelsea() {
        agregarFavoritos(crearProducto("CHE2007","Chelsea 2007-2008",2007,"/imagenes/chelsea.png"));
    }

    @FXML private void carritoLiverpool() {
        agregarCarrito(crearProducto("LIV2006","Liverpool 2006-2007",2006,"/imagenes/liverpool.png"));
    }
    @FXML private void favoritoLiverpool() {
        agregarFavoritos(crearProducto("LIV2006","Liverpool 2006-2007",2006,"/imagenes/liverpool.png"));
    }

    @FXML private void carritoBarcelona() {
        agregarCarrito(crearProducto("BAR2008","Barcelona 2008-2009",2008,"/imagenes/barsa.png"));
    }
    @FXML private void favoritoBarcelona() {
        agregarFavoritos(crearProducto("BAR2008","Barcelona 2008-2009",2008,"/imagenes/barsa.png"));
    }

    @FXML private void carritoUnited() {
        agregarCarrito(crearProducto("UNI2002","United 2002-2004",2002,"/imagenes/united.png"));
    }
    @FXML private void favoritoUnited() {
        agregarFavoritos(crearProducto("UNI2002","United 2002-2004",2002,"/imagenes/united.png"));
    }

    @FXML private void carritoMadrid() {
        agregarCarrito(crearProducto("RMA2011","Real Madrid 2011-2012",2011,"/imagenes/madrid.png"));
    }
    @FXML private void favoritoMadrid() {
        agregarFavoritos(crearProducto("RMA2011","Real Madrid 2011-2012",2011,"/imagenes/madrid.png"));
    }

    @FXML private void carritoMilan() {
        agregarCarrito(crearProducto("MIL2006","Milan 2006-2007",2006,"/imagenes/milan.png"));
    }
    @FXML private void favoritoMilan() {
        agregarFavoritos(crearProducto("MIL2006","Milan 2006-2007",2006,"/imagenes/milan.png"));
    }

    @FXML private void carritoCity() {
        agregarCarrito(crearProducto("CIT1997","City 1997-1998",1997,"/imagenes/city.png"));
    }
    @FXML private void favoritoCity() {
        agregarFavoritos(crearProducto("CIT1997","City 1997-1998",1997,"/imagenes/city.png"));
    }
}
