/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Josea
 */

public class Producto {

    private String id;
    private String nombre;
    private String descripcion;
    private String categoria;   // Selecciones / Clubes
    private String pais;
    private int anio;
    private double precio;
    private String imagen; // Ruta de imagen

    public Producto(String id, String nombre, String descripcion, String categoria,
                    String pais, int anio, double precio, String imagen) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.pais = pais;
        this.anio = anio;
        this.precio = precio;
        this.imagen = imagen;
    }

    public Producto() {}

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public String getPais() { return pais; }
    public void setPais(String pais) { this.pais = pais; }

    public int getAnio() { return anio; }
    public void setAnio(int anio) { this.anio = anio; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    public String getImagen() { return imagen; }
    public void setImagen(String imagen) { this.imagen = imagen; }

    @Override
    public String toString() {
        return id + ";" + nombre + ";" + descripcion + ";" + categoria + ";" +
               pais + ";" + anio + ";" + precio + ";" + imagen;
    }
}
