package modelo;

import java.time.LocalDate;

public class Compra {

    private Producto producto;
    private LocalDate fecha;

    public Compra(Producto producto, LocalDate fecha) {
        this.producto = producto;
        this.fecha = fecha;
    }

    public Producto getProducto() { return producto; }
    public LocalDate getFecha() { return fecha; }
}
