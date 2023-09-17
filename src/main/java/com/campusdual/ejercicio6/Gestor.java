package com.campusdual.ejercicio6;


import java.util.*;

public class Gestor {
    public static void main(String[] args) {
     /*
        ListaAlimentos.agregarNuevoAlimento();
        String rutaArchivoPacientes = "C:/Users/marti/OneDrive/Documentos/GitHub/ejerci_poo/ejercicios_poo/src/main/java/com/campusdual/pacientes.txt";
        String rutaArchivoDietas = "C:/Users/marti/OneDrive/Documentos/GitHub/ejerci_poo/ejercicios_poo/src/main/java/com/campusdual/dietas.txt";

// Paso 1: Recuperar contenido como ArrayList para pacientes y dietas
        ArrayList<String> pacientesGuardados = ArchivoGestor.recuperarContenidoComoArrayList(rutaArchivoPacientes);
        ArrayList<String> dietasGuardados = ArchivoGestor.recuperarContenidoComoArrayList(rutaArchivoDietas);

// Mostrar lista de pacientes
        System.out.println("Lista de Pacientes:");
        for (int i = 0; i < pacientesGuardados.size(); i++) {
            String linea = pacientesGuardados.get(i);
            System.out.println((i + 1) + ". " + linea);
        }

// Seleccionar un paciente (por ejemplo, el primer paciente)
        int numeroPacienteElegido = 1; // Cambia el número según tu elección
        String pacienteElegido = pacientesGuardados.get(numeroPacienteElegido - 1);

// Mostrar lista de dietas
        System.out.println("\nLista de Dietas:");
        for (int i = 0; i < dietasGuardados.size(); i++) {
            String linea = dietasGuardados.get(i);
            System.out.println((i + 1) + ". " + linea);
        }

// Seleccionar una dieta (por ejemplo, la primera dieta)
        int numeroDietaElegida = 1; // Cambia el número según tu elección
        String dietaElegida = dietasGuardados.get(numeroDietaElegida - 1);

// Asociar la dieta al paciente
        String pacienteConDieta = pacienteElegido + " Dieta: " + dietaElegida;

// Mostrar el paciente con la dieta asociada
        System.out.println("\nEl paciente seleccionado tiene la siguiente dieta asociada:");
        System.out.println(pacienteConDieta);


        // agrega alimento nuevo
        ListaAlimentos.agregarNuevoAlimento();

    }}
    // seleccionamos alimentos de archivo y asociamos gramos */
/*
        ListaAlimentos alimentosSeleccionados = ListaAlimentos.asociarGramosyFood();

        if (alimentosSeleccionados != null) {
            System.out.println("Alimento seleccionado: " + alimentosSeleccionados.getNombre());
            System.out.println("Gramos: " + alimentosSeleccionados.getGramos());
            System.out.println("carbos: " + alimentosSeleccionados.getCarbos());
            System.out.println("proteinas: " + alimentosSeleccionados.getProteinas());
            System.out.println("Grasas: " + alimentosSeleccionados.getGrasas());
        }
    }*/

    // generamos nuevo alimento
    // Agregar la nueva línea al archivo
   // ListaAlimentos.agregarNuevoAlimento()
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Elija una opción:");
            System.out.println("1. Gestionar Menús");
            System.out.println("2. Gestionar Pacientes");
            System.out.println("3. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    gestionarMenus(scanner);
                    break;
                case 2:
                    gestionarPacientes();
                    break;
                case 3:
                    System.out.println("Hasta luego!");
                    System.exit(0); // Salir del programa
                default:
                    System.out.println("Opción no válida. Por favor, elija nuevamente.");
            }
        }
    }

    public static void gestionarMenus(Scanner scanner) {
        System.out.println("Elija un tipo de dieta:");
        System.out.println("1. Sin restricciones");
        System.out.println("2. Por calorías");
        System.out.println("3. Por carbohidratos");
        System.out.println("4. Por proteínas");
        System.out.println("5. Por calorías y grasas");

        int tipoDieta = scanner.nextInt();
        scanner.nextLine();

        switch (tipoDieta) {
            case 1:
                // Implementar lógica para dieta sin restricciones
                break;
            case 2:
                // Implementar lógica para dieta por calorías
                break;
            case 3:
                // Implementar lógica para dieta por carbohidratos
                break;
            case 4:
                // Implementar lógica para dieta por proteínas
                break;
            case 5:
                // Implementar lógica para dieta por calorías y grasas
                break;
            default:


                System.out.println("Opción no válida. Por favor, elija nuevamente.");





        }
    }

    public static void gestionarPacientes() {
        // Implementar lógica para gestionar pacientes
    }

    public static void gestionarAlimentos(Scanner scanner) {
        while (true) {
            System.out.println("Elija una opción:");
            System.out.println("1. Añadir Food");
            System.out.println("2. Listar Food");
            System.out.println("3. Volver al menú principal");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    ListaAlimentos.agregarNuevoAlimento();
                    break;
                case 2:
                    ListaAlimentos.asociarGramosyFood();
                    break;
                case 3:
                    return; // Volver al menú principal
                default:
                    System.out.println("Opción no válida. Por favor, elija nuevamente.");
            }
        }
    }
}







