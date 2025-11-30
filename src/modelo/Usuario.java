package modelo;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

    private String id;
    private String correo;
    private String apodo;
    private String contrasena;
    private String rol;

    private List<Producto> favoritos = new ArrayList<>();
    private List<Producto> carrito = new ArrayList<>();
    private List<Compra> historial = new ArrayList<>();

    public Usuario() {}

    public Usuario(String id, String correo, String apodo, String contrasena, String rol) {
        this.id = id;
        this.correo = correo;
        this.apodo = apodo;
        this.contrasena = contrasena;
        this.rol = rol;
    }

    
    public String getId() { return id; }
    public String getCorreo() { return correo; }
    public String getApodo() { return apodo; }
    public String getContrasena() { return contrasena; }
    public String getRol() { return rol; }

    public void setId(String id) { this.id = id; }
    public void setCorreo(String correo) { this.correo = correo; }
    public void setApodo(String apodo) { this.apodo = apodo; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }
    public void setRol(String rol) { this.rol = rol; }

   
    public List<Producto> getFavoritos() { return favoritos; }
    public void agregarFavorito(Producto p) {
        if (!favoritos.contains(p)) favoritos.add(p);
    }
    public void quitarFavorito(Producto p) { favoritos.remove(p); }

   
    public List<Producto> getCarrito() { return carrito; }
    public void agregarAlCarrito(Producto p) { carrito.add(p); }
    public void quitarDelCarrito(Producto p) { carrito.remove(p); }
    public void limpiarCarrito() { carrito.clear(); }

   
    public List<Compra> getHistorial() { return historial; }
    public void agregarCompra(Compra compra) { historial.add(compra); }
}

