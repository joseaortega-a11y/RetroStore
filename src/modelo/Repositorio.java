package modelo;

import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;

public class Repositorio {

    public static List<Usuario> usuarios = new ArrayList<>();
    public static List<Producto> productos = new ArrayList<>();

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

    public static Producto buscarProductoPorNombre(String nombre) {
        for (Producto p : productos) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                return p;
            }
        }
        return null;
    }

    public static void ordenarPorPrecioBurbuja() {
        int n = productos.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (productos.get(j).getPrecio() > productos.get(j + 1).getPrecio()) {
                    Producto t = productos.get(j);
                    productos.set(j, productos.get(j + 1));
                    productos.set(j + 1, t);
                }
            }
        }
    }

    public static void ordenarPorNombreSeleccion() {
        int n = productos.size();
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (productos.get(j).getNombre().compareToIgnoreCase(productos.get(min).getNombre()) < 0) {
                    min = j;
                }
            }
            Producto t = productos.get(min);
            productos.set(min, productos.get(i));
            productos.set(i, t);
        }
    }
}
