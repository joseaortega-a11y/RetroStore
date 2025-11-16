/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.time.LocalDate;

public class Compra {

    private String usuarioId;
    private Producto producto;
    private LocalDate fecha;
/**
 *
 * @author Josea
 */
    public Compra(String usuarioId, Producto producto, LocalDate fecha) {
        this.usuarioId = usuarioId;
        this.producto = producto;
        this.fecha = fecha;
    }

    public String getUsuarioId() { return usuarioId; }
    public Producto getProducto() { return producto; }
    public LocalDate getFecha() { return fecha; }

    @Override
    public String toString() {
        return usuarioId + ";" + producto.getId() + ";" + fecha.toString();
    }
}
