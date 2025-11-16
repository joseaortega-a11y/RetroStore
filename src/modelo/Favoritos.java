/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Josea
 */
public class Favoritos {

    private List<Producto> lista = new ArrayList<>();

    public void agregar(Producto p) {
        if (!lista.contains(p)) lista.add(p);
    }

    public void eliminar(Producto p) {
        lista.remove(p);
    }

    public List<Producto> getLista() {
        return lista;
    }
}
