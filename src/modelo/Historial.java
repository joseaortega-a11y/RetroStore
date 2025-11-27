package modelo;

import java.util.Stack;

public class Historial {
    private static Stack<Compra> compras = new Stack<>();

    public static void agregarCompra(Compra compra) {
        compras.push(compra);
    }

    public static Stack<Compra> getHistorial() {
        return compras;
    }
}
