package com.campusdual.ejercicio5V;

import java.util.*;

public class DietasPersonalizadas {
    private Map<String, Dietas> dietasMap;
    List<Pacientes> pacientesList = new ArrayList<>();
    private List<Asociacion> asociaciones;

    public DietasPersonalizadas() {
        dietasMap = new HashMap<>();
        List<AlimentosListados> alimentosSeleccionados = new ArrayList<>();
        asociaciones = new ArrayList<>();
    }

    public void showMenuProgram() {
        boolean salir = false;
        String nombreDieta = "";

        while (!salir) {
            System.out.println("===================================");
            System.out.println("1-Gestión de Dietas");
            System.out.println("2-Gestión de Pacientes (por hacer)");
            System.out.println("3-Salir del programa");
            System.out.println("===================================");
            int opcion = Kb.forceNextInt();

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
                        int opcionDietas = Kb.forceNextInt();

                        switch (opcionDietas) {
                            case 1:
                                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                                System.out.println("Crear dieta");
                                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                                System.out.println("Escriba un nombre para la dieta:");
                                nombreDieta = Kb.nextLine();
                                Dietas nuevaDieta = new Dietas();

                                System.out.println("Escriba una opción:");
                                System.out.println("===================================");
                                System.out.println("a. Sin límite de calorías");
                                System.out.println("b. Por calorías");
                                System.out.println("c. Por macronutrientes");
                                System.out.println("d. Por datos personales");
                                System.out.println("===================================");
                                char tipoDieta = Kb.nextLine().charAt(0);

                                switch (tipoDieta) {
                                    case 'a':
                                        dietasMap.put(nombreDieta, nuevaDieta);
                                        break;
                                    case 'b':
                                        System.out.println("Ingrese el máximo de calorías:");
                                        int maxCalorias = Kb.forceNextInt();
                                        dietasMap.put(nombreDieta, new Dietas(maxCalorias));
                                        break;
                                    case 'c':
                                        System.out.println("Ingrese el máximo de grasas:");
                                        int maxGrasas = Kb.forceNextInt();
                                        System.out.println("Ingrese el máximo de carbohidratos:");
                                        int maxCarbos = Kb.forceNextInt();
                                        System.out.println("Ingrese el máximo de proteínas:");
                                        int maxProteinas = Kb.forceNextInt();
                                        dietasMap.put(nombreDieta, new Dietas(maxGrasas, maxCarbos, maxProteinas));
                                        break;
                                    case 'd':
                                        System.out.println("Ingrese el sexo (h/m):");
                                        char sexo = Kb.nextLine().charAt(0);
                                        System.out.println("Ingrese la edad:");
                                        int edad = Kb.forceNextInt();
                                        System.out.println("Ingrese la altura en centímetros:");
                                        int altura = Kb.forceNextInt();
                                        System.out.println("Ingrese el peso en kilos:");
                                        int peso = Kb.forceNextInt();

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
                                    int opcionAlimentos = Kb.forceNextInt();

                                    switch (opcionAlimentos) {
                                        case 1:
                                            System.out.println("Ingrese el nombre del nuevo alimento:");
                                            String nombre = Kb.nextLine();
                                            System.out.println("Ingrese los gramos de carbohidratos por 100 gramos:");
                                            int carbos = Kb.forceNextInt();
                                            System.out.println("Ingrese los gramos de grasas por 100 gramos:");
                                            int grasas = Kb.forceNextInt();
                                            System.out.println("Ingrese los gramos de proteínas por 100 gramos:");
                                            int proteinas = Kb.forceNextInt();

                                            Alimentos nuevoAlimento = new Alimentos(carbos, grasas, proteinas, nombre, 0);
                                            alimentosSeleccionados.add(nuevoAlimento);

                                            System.out.println("Ingrese la cantidad en gramos de " + nombre + ":");
                                            int gramos = Kb.forceNextInt();
                                            nuevaDieta.addAlimentos(nuevoAlimento, gramos);

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
                                                int indiceAlimento = Kb.forceNextInt();

                                                if (indiceAlimento >= 0 && indiceAlimento < alimentosSeleccionados.size()) {
                                                    Alimentos alimentoExistente = alimentosSeleccionados.get(indiceAlimento);

                                                    System.out.println("Ingrese la cantidad en gramos de " + alimentoExistente.getName() + ":");
                                                    int gramosAlimentoExistente = Kb.forceNextInt();

                                                    nuevaDieta.addAlimentos(alimentoExistente, gramosAlimentoExistente);
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
                                    String respuesta = Kb.nextLine();
                                    if (respuesta.equalsIgnoreCase("n")) {
                                        agregarAlimentos = false;
                                    }
                                }
                                break;

                            case 2:
                                if (dietasMap != null) {
                                    System.out.println("Listado de Dietas:");
                                    for (Map.Entry<String, Dietas> entry : dietasMap.entrySet()) {
                                        String key = entry.getKey();
                                        Dietas value = entry.getValue();
                                        System.out.println("- " + key);
                                        System.out.println(value);
                                    }
                                } else {
                                    System.out.println("No se ha seleccionado ninguna dieta.");
                                }
                                break;

                            case 3:
                                System.out.println("Listado de Dietas:");
                                for (String nombre : dietasMap.keySet()) {
                                    System.out.println("- " + nombre);
                                }
                                System.out.println("Escriba el nombre de la dieta a eliminar:");
                                String nombreDietaEliminar = Kb.nextLine();
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
                    gestorPaciente();
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
    }

    private void gestorPaciente() {

        System.out.println("Ingrese el nombre del paciente:");
        String nombre = Kb.nextLine();

        System.out.println("Ingrese el apellido del paciente:");
        String apellido = Kb.nextLine();

        System.out.println("Ingrese el peso del paciente (en kg):");
        int peso = Kb.forceNextInt();

        System.out.println("Ingrese la altura del paciente (en cm):");
        int altura = Kb.forceNextInt();

        System.out.println("Ingrese la edad del paciente:");
        int edad = Kb.forceNextInt();

        System.out.println("Ingrese el género del paciente (h/m):");
        char genero = Kb.nextLine().charAt(0);
        Genre genre;
        if (genero == 'h') {
            genre = Genre.MALE;
        } else if (genero == 'm') {
            genre = Genre.FEMALE;
        } else {
            throw new IllegalArgumentException("El género debe ser 'h' o 'm'.");
        }

        Pacientes paciente = new Pacientes(nombre,apellido,peso,altura,edad,genre);
        System.out.println("Paciente añadido correctamente.");
        System.out.println("Nombre del paciente: " + paciente.getPacientesInfo());

        asociarPacienteDieta(paciente);

    }
    private void asociarPacienteDieta(Pacientes paciente) {
        if (dietasMap.isEmpty()) {
            System.out.println("No hay dietas disponibles. Por favor, cree una nueva dieta primero.");
            return;
        }

        System.out.println("Seleccione una dieta para asociar con el paciente:");
        int index = 1;
        for (Map.Entry<String, Dietas> entry : dietasMap.entrySet()) {
            System.out.println(index + ". " + entry.getKey());
            index++;
        }

        System.out.println(index + ". Crear nueva dieta");

        int opcionDieta = Kb.getOption(1, index);

        if (opcionDieta == index) {
            System.out.println("Creando nueva dieta...");
            // Aquí puedes incluir código para crear una nueva dieta, si lo deseas
        } else {
            Dietas dietaAsociada = new ArrayList<>(dietasMap.values()).get(opcionDieta - 1);
            asociaciones.add(new Asociacion(paciente, dietaAsociada));
            System.out.println("Paciente asociado a la dieta correctamente.");
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
