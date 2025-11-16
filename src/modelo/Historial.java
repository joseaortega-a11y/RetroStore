/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Stack;
/**
 *
 * @author Josea
 */


public class Historial {

    private static Stack<Compra> compras = new Stack<>();

    public static void agregarCompra(Compra compra) {
        compras.push(compra);
    }

    public static Compra deshacer() {
        return compras.isEmpty() ? null : compras.pop();
    }

    public static Stack<Compra> getHistorial() {
        return compras;
    }
}

