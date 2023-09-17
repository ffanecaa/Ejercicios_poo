package com.campusdual.ejercicio6;
import com.campusdual.ejercicio6b.Gramos;

import java.util.*;

public class motorr {
    //private static ArrayList<Pacientes> listaPacientes = new ArrayList<>();
    public static void main(String[] args) {

        String rutaArchivoDietas = "C:/Users/marti/OneDrive/Documentos/GitHub/ejerci_poo/ejercicios_poo/src/main/java/com/campusdual/dietas.txt";
        String rutaArchivoFood = "C:/Users/marti/OneDrive/Documentos/GitHub/ejerci_poo/ejercicios_poo/src/main/java/com/campusdual/Alimentos.txt";
       ArchivoGestor.crearArchivo(rutaArchivoFood);
        String rutaArchivoPacientes = "C:/Users/marti/OneDrive/Documentos/GitHub/ejerci_poo/ejercicios_poo/src/main/java/com/campusdual/Pacientes.txt";
        ArchivoGestor.crearArchivo(rutaArchivoPacientes);
      // ArchivoGestor.crearArchivo(rutaArchivoDietas);
      //  ArrayList<String> dietasGuardados = ArchivoGestor.recuperarContenidoComoArrayList(rutaArchivoDietas);

        // paciientes




                Scanner scanner = new Scanner(System.in);

                while (true) {
                    System.out.println("Menu:");
                    System.out.println("1. Gestor de Dietas");
                    System.out.println("2. Gestor de Pacientes");
                    System.out.println("3. Salir");
                    System.out.print("Seleccione una opción: ");

                    int opcion = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer del scanner

                    switch (opcion) {
                        case 1:
                            gestorDietas(scanner);
                            break;
                        case 2:
                            gestorPacientes(scanner);
                            break;
                        case 3:
                            return;
                        default:
                            System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                            break;
                    }
                }
            }

            private static void gestorDietas(Scanner scanner) {
                while (true) {
                    System.out.println("\nGestor de Dietas:");
                    System.out.println("1. Agregar Dieta");
                    System.out.println("2. Agregar Alimentos");
                    System.out.println("3. Listar Dietas");
                    System.out.println("4. Listar Alimentos");
                    System.out.println("5. Salir");
                    System.out.print("Seleccione una opción: ");

                    int opcion = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer del scanner

                    switch (opcion) {
                        case 1:
                            System.out.println("Opción para Agregar Dieta seleccionada.");
                            // Aquí debes implementar la lógica para agregar una dieta
                            break;
                        case 2:
                            System.out.println("Opción para Agregar Alimentos seleccionada.");
                            System.out.println("1. Agregar Nuevo Alimento");
                            System.out.println("2. Asociar Gramos y Food");
                            System.out.println("3. borrar Alimentos");
                            System.out.print("Seleccione una subopción: ");

                            int subopcionAlimentos = scanner.nextInt();
                            scanner.nextLine(); // Limpiar el buffer del scanner

                            switch (subopcionAlimentos) {
                                case 1:
                                    ListaAlimentos.agregarNuevoAlimento();
                                    break;

                                case 2:
                                    ListaAlimentos.asociarGramosyFood();
                                    break;
                                    case 3:
                                    //borrar
                                    break;
                                default:
                                    System.out.println("Subopción no válida. Por favor, seleccione una subopción válida.");
                                    break;
                            }
                            break;

                       case 3:
                            System.out.println("Opción para Listar Dietas seleccionada.");
                            // Aquí debes implementar la lógica para listar dietas
                            break;
                        case 4:
                            System.out.println("Opción para Listar Alimentos seleccionada.");
                            String rutaArchivoDietas = "C:/Users/marti/OneDrive/Documentos/GitHub/ejerci_poo/ejercicios_poo/src/main/java/com/campusdual/Alimentos.txt";

                            ArrayList<String> contenido =  ArchivoGestor.recuperarContenidoComoArrayList(rutaArchivoDietas);


                            for (String linea : contenido) {
                                System.out.println(linea);
                            }
                            break;
                        case 5:
                            return;
                        default:
                            System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                            break;
                    }
                }
            }

            private static void gestorPacientes(Scanner scanner) {
                // Implementa el gestor de pacientes aquí




            while (true) {
                System.out.println("1. Agregar paciente");
                System.out.println("2. Listar y mostrar detalles de un paciente");
                System.out.println("3. Dar de baja un paciente");
                System.out.println("4. Salir");
                System.out.print("Seleccione una opción: ");

                int opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        agregarPaciente(scanner);
                        break;
                    case 2:
                        listarDetalles(scanner);
                        break;
                    case 3:
                        darDeBaja(scanner);
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                        break;
                }
            }
        }

    private static void agregarPaciente(Scanner scanner) {
        System.out.println("Ingrese el nombre del paciente:");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese el apellido del paciente:");
        String apellido = scanner.nextLine();

        System.out.println("Ingrese el peso del paciente (en kg):");
        int peso = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer del scanner

        System.out.println("Ingrese la altura del paciente (en cm):");
        int altura = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer del scanner

        System.out.println("Ingrese la edad del paciente:");
        int edad = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer del scanner

        System.out.println("Ingrese el género del paciente (h/m):");
        String genero = scanner.nextLine();


        Pacientes paciente = new Pacientes(nombre, apellido, peso, altura, edad, genero);

        String rutaArchivoPacientes = "C:/Users/marti/OneDrive/Documentos/GitHub/ejerci_poo/ejercicios_poo/src/main/java/com/campusdual/Pacientes.txt";

        String contenido = paciente.obtenerContenido();

        ArchivoGestor.escribirEnArchivoPaciente(rutaArchivoPacientes, contenido);
        System.out.println("Paciente añadido correctamente.");
    }


    private static void listarDetalles(Scanner scanner) {

         /*   System.out.println("Ingrese el índice del paciente que desea ver:");
            for (int i = 0; i < listaPacientes.size(); i++) {
                System.out.println((i + 1) + ". " + listaPacientes.get(i).getNombre());
            }

            int indice = scanner.nextInt();
            scanner.nextLine();
            if (indice >= 1 && indice <= listaPacientes.size()) {
                Pacientes paciente = listaPacientes.get(indice - 1);
                // Aquí debes mostrar los detalles del paciente y sus dietas
            } else {
                System.out.println("Índice inválido. Por favor, seleccione un índice válido.");
            }*/
        String rutaArchivoPacientes = "C:/Users/marti/OneDrive/Documentos/GitHub/ejerci_poo/ejercicios_poo/src/main/java/com/campusdual/Pacientes.txt";
        ArrayList<String> contenido =    ArchivoGestor.recuperarContenidoComoArrayList(rutaArchivoPacientes);


        for (String linea : contenido) {
            System.out.println(linea);
        }


    }

        private static void darDeBaja(Scanner scanner) {
          /*  System.out.println("Ingrese el índice del paciente que desea dar de baja:");
            for (int i = 0; i < .size(); i++) {
                System.out.println((i + 1) + ". " + listaPacientes.get(i).getNombre());
            }
*/    System.out.println("Ingrese el nombre del paciente:");

            String nombre = scanner.nextLine();
            ; // Limpiar el buffer del scanner
/*
            if (indice >= 1 && indice <= listaPacientes.size()) {
                listaPacientes.remove(indice - 1);
                System.out.println("Paciente dado de baja correctamente.");
            } else {
                System.out.println("Índice inválido. Por favor, seleccione un índice válido.");
            }*/
            String rutaArchivoPacientes = "C:/Users/marti/OneDrive/Documentos/GitHub/ejerci_poo/ejercicios_poo/src/main/java/com/campusdual/Pacientes.txt";
            ArchivoGestor.borrarPacientePorNombre(rutaArchivoPacientes,nombre);

        }
    }













/*
            // Mostrar lista de dietas
        System.out.println("\nLista de Dietas:");
        for (int i = 0; i < dietasGuardados.size(); i++) {
            String linea = dietasGuardados.get(i);
            System.out.println((i + 1) + ". " + linea);
        }

// Seleccionar una dieta (por ejemplo, la primera dieta)
        int numeroDietaElegida = 1; // Cambia el número según tu elección
        String dietaElegida = dietasGuardados.get(numeroDietaElegida - 1);


    }
}
*/