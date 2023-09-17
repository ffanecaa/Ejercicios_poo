package com.campusdual.ejercicio6b;
import java.io.*;
import java.util.*;
public class ArchivoGestor {

    public static void crearArchivo(String rutaArchivo) {
        File archivo = new File(rutaArchivo);

        try {
            archivo.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void escribirEnArchivo(String rutaArchivo, String contenido) {
        try {

            ArrayList<String> alimentosGuardados = recuperarContenido(rutaArchivo);
            // Obtener el nombre del alimento del contenido
            String[] partes = contenido.split(" ");
            String nombreAlimento = partes[1];

            boolean alimentoExiste = false;

            for (String linea : alimentosGuardados) {
                String[] partesLinea = linea.split(" ");
                String nombreGuardado = partesLinea[1];
                if (nombreGuardado.equals(nombreAlimento)) {
                    alimentoExiste = true;
                    break;
                }
            }

            if (!alimentoExiste) {
                FileWriter escritura = new FileWriter(rutaArchivo, true);
                escritura.write(contenido + System.lineSeparator());
                escritura.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<String> recuperarContenido(String rutaArchivo) {
        ArrayList<String> contenido = new ArrayList<>();

        try {
            BufferedReader lector = new BufferedReader(new FileReader(rutaArchivo));
            String linea;

            while ((linea = lector.readLine()) != null) {
                contenido.add(linea);
            }

            lector.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return contenido;
    }



}