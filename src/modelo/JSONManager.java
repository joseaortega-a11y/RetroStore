package modelo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class JSONManager {

    private static final Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    // Guarda cualquier lista en una ruta (json)
    public static <T> void guardarJSON(String ruta, List<T> lista) {
        try {
            Path p = Path.of(ruta);
            Files.createDirectories(p.getParent() == null ? Path.of("") : p.getParent());
            try (Writer w = new FileWriter(p.toFile())) {
                gson.toJson(lista, w);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Carga una lista desde json, si no existe devuelve lista vacía
    public static <T> List<T> cargarJSON(String ruta, TypeToken<List<T>> token) {
        try {
            File f = Path.of(ruta).toFile();
            if (!f.exists()) return new ArrayList<>();
            try (Reader r = new FileReader(f)) {
                Type type = token.getType();
                List<T> lista = gson.fromJson(r, type);
                return lista == null ? new ArrayList<>() : lista;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
