package com.campusdual.ejercicio5V;

import java.util.*;

public class DietasPersonalizadas {
    private Map<String, Dietas> dietasMap;

    public DietasPersonalizadas() {
        dietasMap = new HashMap<>();
    }

    public void showMenuProgram() {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;
        String nombreDieta = "";

        while (!salir) {
            System.out.println("===================================");
            System.out.println("1-Gestión de Dietas");
            System.out.println("2-Gestión de Pacientes (por hacer)");
            System.out.println("3-Salir del programa");
            System.out.println("===================================");
            int opcion = scanner.nextInt();
            scanner.nextLine();

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
                        scanner.nextLine();

                        switch (opcionDietas) {
                            case 1:
                                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                                System.out.println("Crear dieta");
                                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                                System.out.println("Escriba un nombre para la dieta:");
                                nombreDieta = scanner.nextLine();
                                Dietas dietas = new Dietas();

                                System.out.println("Escriba una opción:");
                                System.out.println("===================================");
                                System.out.println("a. Sin límite de calorías");
                                System.out.println("b. Por calorías");
                                System.out.println("c. Por macronutrientes");
                                System.out.println("d. Por datos personales");
                                System.out.println("===================================");
                                char tipoDieta = scanner.next().charAt(0);
                                scanner.nextLine();

                                switch (tipoDieta) {
                                    case 'a':
                                        dietasMap.put(nombreDieta, dietas);
                                        break;
                                    case 'b':
                                        System.out.println("Ingrese el máximo de calorías:");
                                        int maxCalorias = scanner.nextInt();
                                        scanner.nextLine();
                                        dietasMap.put(nombreDieta, new Dietas(maxCalorias));
                                        break;
                                    case 'c':
                                        System.out.println("Ingrese el máximo de grasas:");
                                        int maxGrasas = scanner.nextInt();
                                        System.out.println("Ingrese el máximo de carbohidratos:");
                                        int maxCarbos = scanner.nextInt();
                                        System.out.println("Ingrese el máximo de proteínas:");
                                        int maxProteinas = scanner.nextInt();
                                        dietasMap.put(nombreDieta, new Dietas(maxGrasas, maxCarbos, maxProteinas));
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
                                        scanner.nextLine();

                                        int maxCaloriasPorDatos = calcularMetabolismoBasal(sexo, edad, altura, peso);
                                        dietasMap.put(nombreDieta, new Dietas(maxCaloriasPorDatos));
                                        break;
                                    default:
                                        System.out.println("Opción no válida");
                                        break;
                                }

                                List<Alimentos> alimentosSeleccionados = new ArrayList<>();
                                boolean agregarAlimentos = true;
                                while (agregarAlimentos) {
                                    System.out.println("Escriba una opción:");
                                    System.out.println("===================================");
                                    System.out.println("1-Añadir alimento");
                                    System.out.println("2-Seleccionar alimento");
                                    System.out.println("===================================");
                                    int opcionAlimentos = scanner.nextInt();
                                    scanner.nextLine();

                                    switch (opcionAlimentos) {
                                        case 1:
                                            System.out.println("Ingrese el nombre del nuevo alimento:");
                                            String nombre = scanner.next();
                                            System.out.println("Ingrese los gramos de carbohidratos por 100 gramos:");
                                            int carbos = scanner.nextInt();
                                            System.out.println("Ingrese los gramos de grasas por 100 gramos:");
                                            int grasas = scanner.nextInt();
                                            System.out.println("Ingrese los gramos de proteínas por 100 gramos:");
                                            int proteinas = scanner.nextInt();

                                            Alimentos nuevoAlimento = new Alimentos(carbos, grasas, proteinas, nombre, 0);
                                            alimentosSeleccionados.add(nuevoAlimento);

                                            System.out.println("Ingrese la cantidad en gramos de " + nombre + ":");
                                            int gramos = scanner.nextInt();
                                            dietas.addAlimentos(nuevoAlimento, gramos);

                                            System.out.println(nombre + " agregado a la dieta.");
                                            break;
                                        case 2:
                                            if (alimentosSeleccionados.isEmpty()) {
                                                System.out.println("No hay alimentos ");
                                            } else {
                                                System.out.println("Lista de alimentos seleccionados:");
                                                for (int i = 0; i < alimentosSeleccionados.size(); i++) {
                                                    System.out.println(i + " " + alimentosSeleccionados.get(i).getName());
                                                }
                                                System.out.print("Seleccione un alimento existente (ingrese el índice): ");
                                                int indiceAlimento = scanner.nextInt();

                                                if (indiceAlimento >= 0 && indiceAlimento < alimentosSeleccionados.size()) {
                                                    Alimentos alimentoExistente = alimentosSeleccionados.get(indiceAlimento);

                                                    System.out.println("Ingrese la cantidad en gramos de " + alimentoExistente.getName() + ":");
                                                    int gramosAlimentoExistente = scanner.nextInt();

                                                    dietas.addAlimentos(alimentoExistente, gramosAlimentoExistente);
                                                } else {
                                                    System.out.println("Índice erróneo");
                                                }
                                            }
                                            break;
                                        default:
                                            System.out.println("Opción no válida");
                                            break;
                                    }

                                    System.out.println("¿Desea agregar otro alimento? (s/n):");
                                    String respuesta = scanner.next();
                                    scanner.nextLine();
                                    if (respuesta.equalsIgnoreCase("n")) {
                                        agregarAlimentos = false;
                                    }
                                }
                                break;

                            case 2:/*
                                if (dietas != null) {
                                    System.out.println("Listado de Dietas:");
                                    for (Map.Entry<String, Dietas> entry : dietasMap.entrySet()) {
                                        String key = entry.getKey();
                                        Dietas value = entry.getValue();
                                        System.out.println("- " + key);
                                        System.out.println(value);
                                    }
                                    dietasMap.put(nombreDieta, dietas);
                                    dietas = null;
                                } else {
                                    System.out.println("No se ha seleccionado ninguna dieta.");
                                }*/
                                break;

                            case 3:
                                System.out.println("Listado de Dietas:");
                                for (String nombre : dietasMap.keySet()) {
                                    System.out.println("- " + nombre);
                                }
                                System.out.println("Escriba el nombre de la dieta a eliminar:");
                                String nombreDietaEliminar = scanner.nextLine();
                                dietasMap.remove(nombreDietaEliminar);
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
