/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.util.HashSet;
import java.util.Set;

public class Favoritos {

    private Set<Producto> favoritos = new HashSet<>();

    public void agregar(Producto p) {
        favoritos.add(p);
    }

    public void eliminar(Producto p) {
        favoritos.remove(p);
    }

    public Set<Producto> getFavoritos() {
        return favoritos;
    }
}

