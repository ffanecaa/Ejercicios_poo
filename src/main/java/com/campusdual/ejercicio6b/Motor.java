package com.campusdual.ejercicio6b;
import java.util.*;
import java.util.Scanner;
/*public class Motor {

      /*  public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            int opcion;

            do {
                System.out.println("1. Gestionar dietas");
                System.out.println("2. Gestionar pacientes"); // Pendiente
                System.out.println("3. Salir");
                System.out.print("Elige una opción: ");
                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        gestionarDietas();
                        break;
                    case 2:
                        // ... (opción pendiente)
                        break;
                    case 3:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opción no válida");
                        break;
                }
            } while (opcion != 3);
        }

        public static void gestionarDietas() {
            Scanner scanner = new Scanner(System.in);

            int opcion;

            do {
                System.out.println("1. Dieta sin restricciones");
                System.out.println("2. Dieta por calorías");
                // Agrega las demás opciones de dieta
                System.out.println("0. Volver al menú principal");
                System.out.print("Elige una opción: ");
                opcion = scanner.nextInt();

                switch (opcion) {

                    case 1:
                        Scanner scanner1 = new Scanner(System.in);

                        // Pedir nombre de la dieta
                        System.out.print("Ingresa el nombre de la dieta: ");
                        String nombreDieta = scanner1.nextLine();

                        Dietas dietaSinRestricciones = new Dietas(nombreDieta);

                        System.out.println("Añade alimentos a la dieta (escribe 'salir' para terminar)");

                        while (true) {
                            System.out.print("Ingresa el nombre del alimento: ");
                            String nombreAlimento = scanner1.nextLine();

                            if (nombreAlimento.equalsIgnoreCase("salir")) {
                                break;
                            }

                            // Pide los datos del alimento al usuario (calorías, carbos, etc.)
                            System.out.print("Ingresa las calorías del alimento: ");
                            Integer calorias = scanner.nextInt();

                            System.out.print("Ingresa los carbohidratos del alimento: ");
                            Integer carbos = scanner.nextInt();

                            System.out.print("Ingresa las proteínas del alimento: ");
                            Integer proteinas = scanner.nextInt();

                            System.out.print("Ingresa las grasas del alimento: ");
                            Integer grasas = scanner.nextInt();

                            System.out.print("Ingresa los gramos del alimento: ");
                            Integer gramos = scanner.nextInt();

                            // Crea el alimento y añádelo a la dieta
                         //   Gramos alimento = new Gramos(nombreAlimento, calorias, carbos, proteinas, grasas, gramos);
                        /*    dietaSinRestricciones.addFood( gramos);

                            // Guardar el alimento en el archivo alimentos.txt
                            String contenido = alimento.toString();
                            ArchivoGestor.escribirEnArchivo("alimentos.txt", contenido);

                            scanner.nextLine(); // Limpia el buffer del scanner
                        }

                        // Guarda la dieta en el archivo
                        dietaSinRestricciones.guardarDietaEnArchivo();
                        break;*/
/*
                    break;
                    case 2:
                        // Implementar dieta por calorías
                        break;
                    // Implementa las demás opciones de dieta
                    case 0:
                        System.out.println("Volviendo al menú principal...");
                        break;
                    default:
                        System.out.println("Opción no válida");
                        break;
                }
            } while (opcion != 0);
        }
    }*/