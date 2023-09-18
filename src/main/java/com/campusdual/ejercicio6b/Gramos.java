package com.campusdual.ejercicio6b;



import java.util.ArrayList;
import java.util.Scanner;


    


    public class Gramos extends Food {

        private Integer gramos;

        public Gramos(String nombre, Integer calorias, Integer carbos, Integer proteinas, Integer grasas, Integer gramos) {
            super(nombre, calorias, carbos, proteinas, grasas);
            this.gramos = gramos;
        }

        public Gramos(Integer gramos) {
            this.gramos = gramos;
        }


        public Integer getGramos() {
            return gramos;
        }

        public void setGramos(Integer gramos) {
            this.gramos = gramos;
        }

        @Override
        public String toString() {
            return "Alimento: " + this.nombre + ", Gramos: " + this.gramos;
        }



        public static void agregarNuevoAlimento() {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Ingresa el nombre del nuevo alimento: ");
            String nuevoAlimento = scanner.nextLine();

            // Verificar si el alimento ya existe en el archivo
            String ruta = "C:/Users/marti/OneDrive/Documentos/GitHub/ejerci_poo/ejercicios_poo/src/main/java/com/campusdual/alimentos.txt";
            ArrayList<String> alimentosGuardados = com.campusdual.ejercicio6_.ArchivoGestor.recuperarContenidoComoArrayList(ruta);

            boolean alimentoYaExiste = false;
            for (String linea : alimentosGuardados) {
                if (linea.contains(nuevoAlimento)) {
                    alimentoYaExiste = true;
                    //funcion llamada elegir
                    break;
                }
            }

            if (alimentoYaExiste) {
                System.out.println("El alimento ya existe en la lista.");
                //llamar funcion elegir
            } else {
                System.out.print("Ingresa el nombre nuevo alimento: ");
                String nombre = scanner.nextLine();

                System.out.print("Ingresa las calorías del nuevo alimento: ");
                Integer calorias = scanner.nextInt();

                System.out.print("Ingresa los carbohidratos del nuevo alimento: ");
                Integer carbos = scanner.nextInt();

                System.out.print("Ingresa las proteínas del nuevo alimento: ");
                Integer proteinas = scanner.nextInt();

                System.out.print("Ingresa las grasas del nuevo alimento: ");
                Integer grasas = scanner.nextInt();

                System.out.print("Ingresa los gramos del nuevo alimento: ");
                Integer gramos = scanner.nextInt();


                Food ali = new Food(nombre,calorias,carbos,proteinas,grasas);

                String contenido = ali.dameDatosFood();


               ArchivoGestor.escribirEnArchivo  (ruta, contenido);

                System.out.println("El alimento ha sido agregado correctamente.");
            }
        }


        public static Gramos asociarGramosyFood() {
            String ruta = "C:/Users/marti/OneDrive/Documentos/GitHub/ejerci_poo/ejercicios_poo/src/main/java/com/campusdual/alimentos.txt";

            ArrayList<String> FoodArray = ArchivoGestor.recuperarContenido(ruta);

            System.out.println("Lista de Alimentos:");
            for (int i = 0; i < FoodArray.size(); i++) {
                String linea = FoodArray.get(i);
                System.out.println((i + 1) + ". " + linea);
            }

            Scanner scanner = new Scanner(System.in);
            System.out.print("Elige un alimento (número): ");
            int seleccion = scanner.nextInt();

            if (seleccion >= 1 && seleccion <= FoodArray.size()) {
                String alimentoSeleccionado = FoodArray.get(seleccion - 1);

                // Extraer el nombre del alimento
                String[] partes = alimentoSeleccionado.split("\\s+");
                String nombreAlimento = partes[1];

                String cantidadCalorias = partes[2];

                String cantidadProteinas = partes[5];

                String cantidadGrasas = partes[8];
                String cantidadCarbos = partes[12];
                Integer calorias = Integer.parseInt(cantidadCalorias);
                Integer proteinas = Integer.parseInt(cantidadProteinas);
                Integer grasas = Integer.parseInt(cantidadGrasas);
                Integer carbos = Integer.parseInt(cantidadCarbos);
                System.out.print("Introduce los gramos para " + nombreAlimento + ": ");
                Integer gramos = scanner.nextInt();

              Gramos alimentosSeleccionados = new Gramos(nombreAlimento,calorias,carbos,proteinas,grasas,gramos);


                return alimentosSeleccionados;

            } else {
                System.out.println("Selección no válida.");
                return null;
            }
        }

        public String dameDatosGramos(Food alimentoSeleccionados, Integer gramos) {
            return "Optas por " + gramos + " gramos de " + alimentoSeleccionados.getNombre() +
                    " que tiene " + /*alimentoSeleccionado.getCalorias() */  " gramos de calorías, " +
                    alimentoSeleccionados.getProteinas() + " gramos de proteínas, " +
                    alimentoSeleccionados.getGrasas() + " gramos de grasas y " +
                    alimentoSeleccionados.getCarbos() + " gramos de carbohidratos por cada 100 gramos.";
        }
    }






