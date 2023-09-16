package com.campusdual.ejercicio6;

import com.campusdual.ejercicio5V.DietasPersonalizadas;

import java.util.*;

public class Gestor {
    public static void main(String[] args) {
        String rutaArchivo = "C:/Users/marti/OneDrive/Documentos/GitHub/ejerci_poo/ejercicios_poo/src/main/java/com/campusdual/alimentos.txt";

        // Paso 1: Recuperar contenido como un conjunto
        Set<String> contenidoSet = ArchivoGestor.recuperarContenidoComoSet(rutaArchivo);
        ArrayList<String> contenidoList = new ArrayList<>(contenidoSet);

        for (int i = 0; i < contenidoList.size(); i++) {
            String linea = contenidoList.get(i);
            System.out.println((i + 1) + ". " + linea);
        }

        // Leer la opción del usuario
        Scanner scanner = new Scanner(System.in);
        System.out.print("Elige un número: ");
        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
              System.out.println( opcion);
                break;
            case 2:
                // Acciones para la segunda línea
                break;
            // ... y así sucesivamente
            default:
                System.out.println("Opción inválida.");
        }
    }
}



