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
    private String rol; // USER o ADMIN

    public Usuario(String id, String correo, String apodo, String contrasena, String rol) {
        this.id = id;
        this.correo = correo;
        this.apodo = apodo;
        this.contrasena = contrasena;
        this.rol = rol;
    }

    public Usuario() {}

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getApodo() { return apodo; }
    public void setApodo(String apodo) { this.apodo = apodo; }

    public String getContrasena() { return contrasena; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }

    public String getRol() { return rol; }
    public void setRol(String rol) { this.rol = rol; }

    @Override
    public String toString() {
        return id + ";" + correo + ";" + apodo + ";" + contrasena + ";" + rol;
    }
}

