/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.util.List;
/**
 *
 * @author Josea
 */


public class JSONManager {

    private static final Gson gson = new Gson();

    public static <T> void guardarJSON(String ruta, List<T> lista) {
        try (Writer w = new FileWriter(ruta)) {
            gson.toJson(lista, w);
        } catch (IOException e) { e.printStackTrace(); }
    }

    public static <T> List<T> cargarJSON(String ruta, TypeToken<List<T>> token) {
        try (Reader r = new FileReader(ruta)) {
            return gson.fromJson(r, token);
        } catch (Exception e) {
            return new java.util.ArrayList<>();
        }
    }
}
