package com.campusdual.ejercicio4b;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Diet dieta = null;
        List<Food> alimentosDisponibles = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        boolean salir = false;
        while (!salir) {
            System.out.println("Menú de la Dieta:");
            System.out.println("1. Crear/reiniciar dieta");
            System.out.println("2. Agregar alimento");
            System.out.println("3. Mostrar información");
            System.out.println("4. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    System.out.println("Seleccione el tipo de dieta:");
                    System.out.println("a. Sin límite de calorías");
                    System.out.println("b. Por calorías");
                    System.out.println("c. Por macronutrientes");
                    System.out.println("d. Por datos personales");
                    char tipoDieta = scanner.next().charAt(0);
                    switch (tipoDieta) {
                        case 'a':
                            dieta = new Diet();
                            break;
                        case 'b':
                            System.out.println("Ingrese el máximo de calorías:");
                            int maxCalorias = scanner.nextInt();
                            dieta = new Diet(maxCalorias);
                            break;
                        case 'c':
                            System.out.println("Ingrese el máximo de grasas:");
                            int maxGrasas = scanner.nextInt();
                            System.out.println("Ingrese el máximo de carbohidratos:");
                            int maxCarbos = scanner.nextInt();
                            System.out.println("Ingrese el máximo de proteínas:");
                            int maxProteinas = scanner.nextInt();
                            dieta = new Diet(maxGrasas, maxCarbos, maxProteinas);
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

                            int maxCaloriasPorDatos = calcularMetabolismoBasal(sexo, edad, altura, peso);
                            dieta = new Diet(maxCaloriasPorDatos);
                            break;
                        default:
                            System.out.println("Opción no válida");
                            break;
                    }
                    break;

                case 2:
                    if (dieta != null) {
                        System.out.println("Seleccione el tipo de alimento:");
                        System.out.println("a. Nuevo alimento");
                        System.out.println("b. Alimento existente");
                        char tipoAlimento = scanner.next().charAt(0);
                        switch (tipoAlimento) {
                            case 'a':
                                System.out.println("Ingrese el nombre del nuevo alimento:");
                                String nombre = scanner.next();
                                System.out.println("Ingrese los gramos de carbohidratos por 100 gramos:");
                                int carbos = scanner.nextInt();
                                System.out.println("Ingrese los gramos de grasas por 100 gramos:");
                                int grasas = scanner.nextInt();
                                System.out.println("Ingrese los gramos de proteínas por 100 gramos:");
                                int proteinas = scanner.nextInt();
                                // genero obj
                                Food nuevoAlimento = new Food(carbos, grasas, proteinas, nombre);
                                alimentosDisponibles.add(nuevoAlimento);
                                System.out.println("Ingrese la cantidad en gramos de " + nombre + ":");
                                int gramos = scanner.nextInt();
                                dieta.addFood(nuevoAlimento, gramos);
                                System.out.println(nombre + " agregado a la dieta.");
                                break;
                            case 'b':
                                if (!alimentosDisponibles.isEmpty()) {
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

                                        dieta.addFood(alimentoExistente, gramosAlimentoExistente);
                                    } else {
                                        System.out.println("Índice incorrecto");
                                    }
                                } else {
                                    System.out.println("No hay alimentos disponibles.");
                                }
                                break;

                            default:
                                System.out.println("Opción no válida");
                                break;
                        }
                    } else {
                        System.out.println("Primero debe crear la dieta.");
                    }
                    break;

                case 3:
                    if (dieta != null) {
                        System.out.println("Total de calorías: " + dieta.getTotalCalories());
                        System.out.println("Total de carbohidratos: " + dieta.getTotalCarbs());
                        System.out.println("Total de grasas: " + dieta.getTotalFats());
                        System.out.println("Total de proteínas: " + dieta.getTotalProteins());
                        System.out.println("Total de gramos: " + dieta.getTotalGrams());
                    } else {
                        System.out.println("Primero debe crear la dieta.");
                    }
                    break;

                case 4:
                    salir = true;
                    System.out.println("Saliendo del programa.");
                    scanner.close();
                    break;

                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }
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
