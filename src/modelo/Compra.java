package modelo;

import java.time.LocalDate;

public class Compra {

    private Usuario comprador;
    private Producto producto;
    private LocalDate fecha;

    public Compra(Usuario comprador, Producto producto, LocalDate fecha) {
        this.comprador = comprador;
        this.producto = producto;
        this.fecha = fecha;
    }

    public Usuario getComprador() { return comprador; }
    public Producto getProducto() { return producto; }
    public LocalDate getFecha() { return fecha; }
}
