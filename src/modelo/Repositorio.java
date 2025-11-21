/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Josea
 */



public class Repositorio {

    // --- Listas principales ---
    public static List<Usuario> usuarios = new ArrayList<>();
    public static List<Producto> productos = new ArrayList<>();
    public static List<Producto> carrito = new ArrayList<>();
    public static List<Producto> favoritos = new ArrayList<>();



    // --- Cargar datos desde JSON ---
    public static void cargarDatos() {
        usuarios = JSONManager.cargarJSON(
                "usuarios.json",
                new TypeToken<List<Usuario>>() {}
        );

        productos = JSONManager.cargarJSON(
                "productos.json",
                new TypeToken<List<Producto>>() {}
        );

        if (usuarios == null) usuarios = new ArrayList<>();
        if (productos == null) productos = new ArrayList<>();
    }

    // --- Búsqueda secuencial ---
    public static Producto buscarProductoPorNombre(String nombre) {
        for (Producto p : productos) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                return p;
            }
        }
        return null;
    }

    // --- Ordenamiento: Burbuja (por precio) ---
    public static void ordenarPorPrecioBurbuja() {
        int n = productos.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (productos.get(j).getPrecio() > productos.get(j + 1).getPrecio()) {
                    Producto temp = productos.get(j);
                    productos.set(j, productos.get(j + 1));
                    productos.set(j + 1, temp);
                }
            }
        }
    }

    // --- Ordenamiento: Selección (por nombre) ---
    public static void ordenarPorNombreSeleccion() {
        int n = productos.size();
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (productos.get(j).getNombre()
                        .compareToIgnoreCase(productos.get(min).getNombre()) < 0) {
                    min = j;
                }
            }
            Producto temp = productos.get(min);
            productos.set(min, productos.get(i));
            productos.set(i, temp);
        }
    }
}
