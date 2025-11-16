/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author Josea
 */



public class Carrito {

    private Map<Producto, Integer> productos = new HashMap<>();

    public void agregarProducto(Producto p) {
        productos.put(p, productos.getOrDefault(p, 0) + 1);
    }

    public void eliminarProducto(Producto p) {
        if (productos.containsKey(p)) {
            int cant = productos.get(p);
            if (cant == 1) productos.remove(p);
            else productos.put(p, cant - 1);
        }
    }

    public double calcularTotal() {
        double total = 0;
        for (Producto p : productos.keySet())
            total += p.getPrecio() * productos.get(p);
        return total;
    }

    public Map<Producto, Integer> getProductos() {
        return productos;
    }

    public void vaciar() {
        productos.clear();
    }
}
