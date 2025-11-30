package modelo;

public class Sesion {
   
    public static Usuario usuarioActual = null;

    
    public static Usuario getUsuarioActual() {
        return usuarioActual;
    }

   
    public static void setUsuarioActual(Usuario u) {
        usuarioActual = u;
    }
}
