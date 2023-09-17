package com.campusdual.ejercicio6;
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

    /*
        public static void escribirEnArchivo(String rutaArchivo, String contenido) {
            try {
                FileWriter escritura = new FileWriter(rutaArchivo, true);
                escritura.write(contenido + System.lineSeparator());
                escritura.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/
    public static void escribirEnArchivoFood(String rutaArchivo, String contenido) {
        try {
          //  Set<String> alimentosGuardados = recuperarContenidoComoSet(rutaArchivo);
            ArrayList<String> alimentosGuardados = recuperarContenidoComoArrayList(rutaArchivo);
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

 public static void escribirEnArchivoPaciente(String rutaArchivo, String contenido) {
        try {
          //  Set<String> pacientesGuardados = recuperarContenidoComoSet(rutaArchivo);
            ArrayList<String> pacientesGuardados = recuperarContenidoComoArrayList(rutaArchivo);
            // Obtener el nombre del paciente del contenido
            String[] partes = contenido.split(" ");
            String nombrePaciente = partes[1];

            boolean pacienteExiste = false;

            for (String linea : pacientesGuardados) {
                String[] partesLinea = linea.split(" ");
                String nombreGuardado = partesLinea[1];
                if (nombreGuardado.equals(nombrePaciente)) {
                    pacienteExiste = true;
                    break;
                }
            }

            if (!pacienteExiste) {
                FileWriter escritura = new FileWriter(rutaArchivo, true);
                escritura.write(contenido + System.lineSeparator());
                escritura.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    } public static void escribirEnArchivoDieta(String rutaArchivo, String contenido) {
        try {
            Set<String> dietasGuardadas = recuperarContenidoComoSet(rutaArchivo);

            // Obtener el nombre de la dieta del contenido
            String[] partes = contenido.split(" ");
            String nombreDieta = partes[1];

            boolean dietaExiste = false;

            for (String linea : dietasGuardadas) {
                String[] partesLinea = linea.split(" ");
                String nombreGuardado = partesLinea[1];
                if (nombreDieta.equals(nombreGuardado)) {
                    dietaExiste = true;
                    break;
                }
            }

            if (!dietaExiste) {
                FileWriter escritura = new FileWriter(rutaArchivo, true);
                escritura.write(contenido + System.lineSeparator());
                escritura.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<String> recuperarContenidoComoArrayList(String rutaArchivo) {
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



    public static Set<String> recuperarContenidoComoSet(String rutaArchivo) {
        Set<String> contenido = new HashSet<>();

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

    public static void borrarPacientePorNombre(String rutaArchivo, String nombrePaciente) {
        try {
            File archivoEntrada = new File(rutaArchivo);
            File archivoTemporal = new File("temp.txt");

            BufferedReader lector = new BufferedReader(new FileReader(archivoEntrada));
            BufferedWriter escritor = new BufferedWriter(new FileWriter(archivoTemporal));

            String linea;

            while ((linea = lector.readLine()) != null) {
                if (!linea.contains(nombrePaciente)) {
                    escritor.write(linea + System.lineSeparator());
                }
            }

            lector.close();
            escritor.close();

            if (!archivoEntrada.delete()) {
                System.out.println("No se pudo eliminar el archivo original.");
                return;
            }

            if (!archivoTemporal.renameTo(archivoEntrada)) {
                System.out.println("No se pudo renombrar el archivo temporal.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }







    public static void main(String[] args) {

        String rutaArchivo1 = "C:/Users/marti/OneDrive/Documentos/GitHub/ejerci_poo/ejercicios_poo/src/main/java/com/campusdual/alimentos.txt";
        // String contenido1 = "escribir";
        // String rutaArchivo2 = "C:/ruta/archivo2.txt";
        Food alimento1 = new Food("arroz", 25, 10, 10, 30);
        Food alimento2 = new Food("oliva", 25, 10, 10, 30);
        Food alimento = new Food("oliva", 30, 10, 10, 30);
        Food alimento4 = new Food("oliva", 30, 10, 10, 30);
        Food alimento5 = new Food("patatas", 30, 10, 10, 30);
        Food alimento6 = new Food("Cebolla", 30, 10, 10, 30);

        String rutaArchivo2 = "C:/Users/marti/OneDrive/Documentos/GitHub/ejerci_poo/ejercicios_poo/src/main/java/com/campusdual/pacientes.txt";
        Pacientes paciente1 = new Pacientes("pepe", "caam", 80, 120, 45, "h");
        Pacientes paciente2 = new Pacientes("pedro", "lopez", 60, 180, 45, "h");


        String rutaArchivo3 = "C:/Users/marti/OneDrive/Documentos/GitHub/ejerci_poo/ejercicios_poo/src/main/java/com/campusdual/dietas.txt";
        Dietas dieta1 = new Dietas("para gordos");

        String contenidoFood = alimento1.dameDatosFood();
        String contenidoFood1 = alimento2.dameDatosFood();
        String contenidoFood2 = alimento4.dameDatosFood();
        String contenidoFood3 = alimento5.dameDatosFood();
        String contenidoFood4 = alimento6.dameDatosFood();

        crearArchivo(rutaArchivo1);

        String contenidoPaciente = paciente1.obtenerContenido();
        String contenidoPaciente1 = paciente2.obtenerContenido();
        escribirEnArchivoPaciente(rutaArchivo2, contenidoPaciente);
        escribirEnArchivoPaciente(rutaArchivo2, contenidoPaciente1);

        String contenidodieta1 = dieta1.obtenerDietas();
        escribirEnArchivoDieta(rutaArchivo3, contenidodieta1);


        escribirEnArchivoFood(rutaArchivo1, contenidoFood);
        escribirEnArchivoFood(rutaArchivo1, contenidoFood1);
        escribirEnArchivoFood(rutaArchivo1, contenidoFood2);
        escribirEnArchivoFood(rutaArchivo1, contenidoFood3);
        escribirEnArchivoFood(rutaArchivo1, contenidoFood4);



        String rutaArchivo = rutaArchivo1;
        ArrayList<String> contenido = recuperarContenidoComoArrayList(rutaArchivo);

        for (String linea : contenido) {
            System.out.println(linea);
        }


    }}
