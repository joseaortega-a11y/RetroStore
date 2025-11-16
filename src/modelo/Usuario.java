/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Josea
 */
public class Usuario {

    private String id;
    private String correo;
    private String apodo;
    private String contrasena;
    private String rol;

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
}
