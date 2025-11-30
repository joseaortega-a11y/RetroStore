package modelo;

import java.util.ArrayList;
import java.util.List;

public class Repositorio {

    public static List<Usuario> usuarios = new ArrayList<>();
    public static List<Producto> productos = new ArrayList<>();

    public static void inicializarProductos() {
        productos.clear();

        //CLUBES 
        productos.add(new Producto("001", "Chelsea 2007-2008", "", "Clubes", 2007, 120.0, "/imagenes/chelsea.png"));
        productos.add(new Producto("002", "Arsenal 2004-2005", "", "Clubes", 2004, 100.0, "/imagenes/arsenal.png"));
        productos.add(new Producto("003", "Liverpool 2006-2007", "", "Clubes", 2006, 110.0, "/imagenes/liverpool.png"));
        productos.add(new Producto("004", "Barcelona 2008-2009", "", "Clubes", 2008, 130.0, "/imagenes/barsa.png"));
        productos.add(new Producto("005", "United 2002-2004", "", "Clubes", 2002, 115.0, "/imagenes/united.png"));
        productos.add(new Producto("006", "Milan 2006-2007", "", "Clubes", 2006, 125.0, "/imagenes/milan.png"));
        productos.add(new Producto("007", "City 1997-1998", "", "Clubes", 1997, 105.0, "/imagenes/city.png"));

        //SELECCIONES 
        productos.add(new Producto("101", "Portugal 2022", "", "Selecciones", 2022, 150.0, "/imagenes/portugal.png"));
        productos.add(new Producto("102", "Brasil 2022", "", "Selecciones", 2022, 145.0, "/imagenes/brazil.png"));
        productos.add(new Producto("103", "Francia 2022", "", "Selecciones", 2022, 140.0, "/imagenes/francia.png"));
        productos.add(new Producto("104", "Argentina 2022", "", "Selecciones", 2022, 155.0, "/imagenes/argentina.png"));
        productos.add(new Producto("105", "Alemania 2022", "", "Selecciones", 2022, 135.0, "/imagenes/alemania.png"));
        productos.add(new Producto("106", "Italia 2022", "", "Selecciones", 2022, 138.0, "/imagenes/italia.png"));
        productos.add(new Producto("107", "España 2022", "", "Selecciones", 2022, 142.0, "/imagenes/spain.png"));
        productos.add(new Producto("108", "Croacia 2022", "", "Selecciones", 2022, 137.0, "/imagenes/croacia.png"));
    }

    public static Producto buscarProductoPorNombre(String nombre) {
        for (Producto p : productos) {
            if (p.getNombre().equalsIgnoreCase(nombre)) return p;
        }
        return null;
    }
}
