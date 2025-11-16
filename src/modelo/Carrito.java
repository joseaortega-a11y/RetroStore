/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author Josea
 */


public class Carrito {

    private List<Producto> productos = new ArrayList<>();
    private Stack<Producto> pilaUndo = new Stack<>(); // para deshacer eliminaciones

    public void agregarProducto(Producto p) {
        productos.add(p);
    }

    public void eliminarProducto(Producto p) {
        productos.remove(p);
        pilaUndo.push(p);
    }

    public boolean deshacerEliminacion() {
        if (pilaUndo.isEmpty()) return false;
        productos.add(pilaUndo.pop());
        return true;
    }

    public double calcularTotal() {
        return productos.stream().mapToDouble(Producto::getPrecio).sum();
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void vaciar() {
        productos.clear();
    }
}
