/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controlador;


import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import modelo.Producto;
import modelo.Repositorio;
import modelo.Compra;
import modelo.Sesion;
import modelo.Historial;

/**
 * FXML Controller class
 *
 * @author Josea
 */



import java.time.LocalDate;
import java.util.List;

/**
 * CarritoController:
 * - muestra los productos de Repositorio.carrito en contenedorCarrito (VBox)
 * - permite eliminar item y finalizar compra (btnComprar)
 *
 * Requiere que en carrito.fxml exista:
 *  - VBox fx:id="contenedorCarrito"
 *  - Text/Label fx:id="lblTotal"
 *  - Button fx:id="btnComprar"
 */
public class CarritoController {

    @FXML private VBox contenedorCarrito;
    @FXML private Text lblTotal;
    @FXML private Button btnComprar;

    @FXML
    private void initialize() {
   
        refrescarVista();
        if (btnComprar != null) {
            btnComprar.setOnAction(e -> finalizarCompra());
        }
    }

    // recalcula total
    private void actualizarTotal() {
        double total = 0;
        for (Producto p : Repositorio.carrito) total += p.getPrecio();
        if (lblTotal != null) lblTotal.setText(String.format("Total: $%.2f", total));
    }

    
    private void refrescarVista() {
        if (contenedorCarrito == null) return;
        contenedorCarrito.getChildren().clear();
        List<Producto> lista = Repositorio.carrito;
        for (Producto p : lista) {
            HBox fila = crearFilaProducto(p);
            contenedorCarrito.getChildren().add(fila);
        }
        actualizarTotal();
    }

    // crea HBox con imagen, texto y botón eliminar
    private HBox crearFilaProducto(Producto p) {
        HBox h = new HBox(10);
        ImageView iv = new ImageView();
        try {
            iv.setImage(new Image(p.getImagen(), 80, 80, true, true));
        } catch (Exception ex) {
            
            try { iv.setImage(new Image(getClass().getResourceAsStream(p.getImagen()))); } catch (Exception e){ }
        }
        Text t = new Text(p.getNombre() + " - $" + p.getPrecio());
        javafx.scene.control.Button btnEliminar = new javafx.scene.control.Button("Eliminar");
        btnEliminar.setOnAction(evt -> {
            Repositorio.carrito.remove(p);
            refrescarVista();
            mostrarInfo("Carrito", "Producto eliminado: " + p.getNombre());
        });
        h.getChildren().addAll(iv, t, btnEliminar);
        return h;
    }

    private void mostrarInfo(String t, String m){
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setHeaderText(null); a.setTitle(t); a.setContentText(m); a.show();
    }

    // Finalizar compra: crea registros en Historial y Repositorio.compras, limpia carrito
    private void finalizarCompra(){
        if (Repositorio.carrito.isEmpty()) { mostrarInfo("Compra", "El carrito está vacío."); return; }
        // crea compras individuales por producto
        for (Producto p : List.copyOf(Repositorio.carrito)) {
            Compra c = new Compra(Sesion.usuarioActual, p, LocalDate.now());
            Historial.agregarCompra(c);
            Repositorio.carrito.add(p);
        }
        Repositorio.carrito.clear();
        refrescarVista();
        mostrarInfo("Compra", "Compra registrada correctamente.");
    }
}
