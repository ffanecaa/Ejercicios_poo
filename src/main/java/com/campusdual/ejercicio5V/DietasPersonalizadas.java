package com.campusdual.ejercicio5V;



import java.util.*;

public class DietasPersonalizadas {

    private Map<String, Dietas> dietasMap;

    public DietasPersonalizadas() {
        dietasMap = new HashMap<>();
    }
    public void showMenuProgram() {
        System.out.println("########################################################");
        System.out.println("################# Programa de dietas ###################");
        System.out.println("########################################################");
        Integer option;
        do {
            System.out.println("Escriba una opción:");
            System.out.println("===================================");
            System.out.println("1-Gestionar Dietas");
            System.out.println("2-Gestion Pacientes");
            System.out.println("3-Salir del programa");
            option = Kb.getOption(1, 3);
            switch (option) {
                case 1:
                    gestionarDietas();
                    break;
                case 2:
                    CustomerManager();
                    break;
                case 3:
                    System.out.println("Gracias por usar el programa, hasta pronto :)");
                    break;
            }
        } while (option != 3);
    }

    private void CustomerManager() {
    }

    public void gestionarDietas() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Elige una opción:");
        System.out.println("1. Dieta sin restricciones");
        System.out.println("2. Dieta por categorías");
        System.out.println("3. Dieta por carbos, fats, proteínas");
        System.out.println("4. Volver al menú principal");

        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer del salto de línea

        switch (opcion) {
            case 1:
                // Código para gestionar dieta sin restricciones
                break;
            case 2:
                // Código para gestionar dieta por categorías
                break;
            case 3:
                // Código para gestionar dieta por carbos, fats, proteínas
                break;
            case 4:
                return; // Volver al menú principal
            default:
                System.out.println("Opción no válida. Por favor, elige una opción válida.");
                gestionarDietas(); // Volver a pedir una opción válida
        }
    }

    // Método para agregar una dieta al mapa
    public void agregarDieta(String nombreDieta, Dietas dieta) {
        dietasMap.put(nombreDieta, dieta);
    }

    // Método para obtener una dieta del mapa
    public Dietas obtenerDieta(String nombreDieta) {
        return dietasMap.get(nombreDieta);
    }

    public static void main(String[] args) {
        DietasPersonalizadas dietasPersonalizadas = new DietasPersonalizadas();
        dietasPersonalizadas.gestionarDietas();
    }
}






