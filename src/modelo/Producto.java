

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
    private String categoria;
    private int anio;
    private double precio;
    private String imagen;

    public Producto() {}

    public Producto(String id, String nombre, String descripcion, String categoria,
                    String pais, int anio, double precio, String imagen) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.anio = anio;
        this.precio = precio;
        this.imagen = imagen;
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
    public String getCategoria() { return categoria; }
    public int getAnio() { return anio; }
    public double getPrecio() { return precio; }
    public String getImagen() { return imagen; }

    public void setId(String id) { this.id = id; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
    public void setAnio(int anio) { this.anio = anio; }
    public void setPrecio(double precio) { this.precio = precio; }
    public void setImagen(String imagen) { this.imagen = imagen; }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Producto)) return false;
        return this.id.equals(((Producto)o).id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
