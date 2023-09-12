package com.campusdual.ejercicio5b;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Map<String, Diet> dietas = new HashMap<>();
        List<Food> alimentosDisponibles = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        boolean salir = false;
        while (!salir) {
            System.out.println("===================================");
            System.out.println("1-Gestión de Dietas");
            System.out.println("2-Gestión de Pacientes (por hacer)");
            System.out.println("3-Salir del programa");
            System.out.println("===================================");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    boolean salirDietas = false;
                    while (!salirDietas) {
                        System.out.println("########################################################");
                        System.out.println("################# Gestión de Dietas ###################");
                        System.out.println("########################################################");
                        System.out.println("===================================");
                        System.out.println("1-Agregar nueva dieta");
                        System.out.println("2-Listar dietas");
                        System.out.println("3-Eliminar dieta");
                        System.out.println("4-Salir");
                        System.out.println("===================================");
                        int opcionDietas = scanner.nextInt();
                        scanner.nextLine(); // Consumir la nueva línea

                        switch (opcionDietas) {
                            case 1:
                                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                                System.out.println("Crear dieta");
                                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                                System.out.println("Escriba un nombre para la dieta:");
                                String nombreDieta = scanner.nextLine();

                                System.out.println("Escriba una opción:");
                                System.out.println("===================================");
                                System.out.println("a. Sin límite de calorías");
                                System.out.println("b. Por calorías");
                                System.out.println("c. Por macronutrientes");
                                System.out.println("d. Por datos personales");
                                System.out.println("===================================");
                                char tipoDieta = scanner.next().charAt(0);
                                scanner.nextLine(); // Consumir la nueva línea

                                switch (tipoDieta) {
                                    case 'a':
                                        dietas.put(nombreDieta, new Diet());
                                        break;
                                    case 'b':
                                        System.out.println("Ingrese el máximo de calorías:");
                                        int maxCalorias = scanner.nextInt();
                                        scanner.nextLine(); // Consumir la nueva línea
                                        dietas.put(nombreDieta, new Diet(maxCalorias));
                                        break;
                                    case 'c':
                                        System.out.println("Ingrese el máximo de grasas:");
                                        int maxGrasas = scanner.nextInt();
                                        System.out.println("Ingrese el máximo de carbohidratos:");
                                        int maxCarbos = scanner.nextInt();
                                        System.out.println("Ingrese el máximo de proteínas:");
                                        int maxProteinas = scanner.nextInt();
                                        dietas.put(nombreDieta, new Diet(maxGrasas, maxCarbos, maxProteinas));
                                        break;
                                    case 'd':
                                        System.out.println("Ingrese el sexo (h/m):");
                                        char sexo = scanner.next().charAt(0);
                                        System.out.println("Ingrese la edad:");
                                        int edad = scanner.nextInt();
                                        System.out.println("Ingrese la altura en centímetros:");
                                        int altura = scanner.nextInt();
                                        System.out.println("Ingrese el peso en kilos:");
                                        int peso = scanner.nextInt();
                                        scanner.nextLine(); // Consumir la nueva línea

                                        int maxCaloriasPorDatos = calcularMetabolismoBasal(sexo, edad, altura, peso);
                                        dietas.put(nombreDieta, new Diet(maxCaloriasPorDatos));
                                        break;
                                    default:
                                        System.out.println("Opción no válida");
                                        break;
                                }

                                // Preguntar por los alimentos
                                boolean agregarAlimentos = true;
                                while (agregarAlimentos) {
                                    System.out.println("Escriba una opción:");
                                    System.out.println("===================================");
                                    System.out.println("1-Agregar alimento");
                                    System.out.println("2-Terminar de agregar alimentos");
                                    System.out.println("===================================");
                                    int opcionAlimentos = scanner.nextInt();
                                    scanner.nextLine(); // Consumir la nueva línea

                                    switch (opcionAlimentos) {
                                        case 1:
                                            System.out.println("Lista de alimentos disponibles:");
                                            for (int i = 0; i < alimentosDisponibles.size(); i++) {
                                                System.out.println(i + " " + alimentosDisponibles.get(i).getName());
                                            }
                                            System.out.print("Seleccione un alimento disponible (ingrese el índice): ");
                                            int indiceAlimento = scanner.nextInt();
                                            if (indiceAlimento >= 0 && indiceAlimento < alimentosDisponibles.size()) {
                                                Food alimentoExistente = alimentosDisponibles.get(indiceAlimento);
                                                System.out.println("Ingrese la cantidad en gramos de " + alimentoExistente.getName() + ":");
                                                int gramosAlimentoExistente = scanner.nextInt();
                                                scanner.nextLine(); // Consumir la nueva línea

                                                dietas.get(nombreDieta).addFood(alimentoExistente, gramosAlimentoExistente);
                                                System.out.println(alimentoExistente.getName() + " agregado a la dieta.");
                                            } else {
                                                System.out.println("Índice incorrecto");
                                            }
                                            break;

                                        case 2:
                                            agregarAlimentos = false;
                                            break;

                                        default:
                                            System.out.println("Opción no válida");
                                            break;
                                    }
                                }
                                break;

                            case 2:
                                System.out.println("Listado de Dietas:");
                                for (String nombre : dietas.keySet()) {
                                    System.out.println("- " + nombre);
                                }
                                break;

                            case 3:
                                System.out.println("Listado de Dietas:");
                                for (String nombre : dietas.keySet()) {
                                    System.out.println("- " + nombre);
                                }
                                System.out.println("Escriba el nombre de la dieta a eliminar:");
                                String nombreDietaEliminar = scanner.nextLine();
                                dietas.remove(nombreDietaEliminar);
                                System.out.println("Dieta eliminada.");
                                break;

                            case 4:
                                salirDietas = true;
                                break;

                            default:
                                System.out.println("Opción no válida");
                                break;
                        }
                    }
                    break;

                case 2:
                    // Gestión de Pacientes (por hacer)
                    System.out.println("Esta opción está por implementar.");
                    break;

                case 3:
                    salir = true;
                    System.out.println("Saliendo del programa.");
                    break;

                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }
        scanner.close();
    }

    private static int calcularMetabolismoBasal(char sexo, int edad, int altura, int peso) {
        int tmb;
        if (sexo == 'h') {
            tmb = (int) (10 * peso + 6.25 * altura - 5 * edad + 5);
        } else if (sexo == 'm') {
            tmb = (int) (10 * peso + 6.25 * altura - 5 * edad - 161);
        } else {
            throw new IllegalArgumentException("El sexo debe ser 'h' o 'm'.");
        }
        return tmb;
    }
}
