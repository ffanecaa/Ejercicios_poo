package com.campusdual.ejercicio5;

import java.util.ArrayList;
import java.util.List;

public class tiposDieta {

    private static final List<Food> listFood = new ArrayList<>();
    private static Diet diet = null;

    public static void main(String[] args) {
        mainMenu();
    }

    private static void mainMenu() {
        Integer select;
        Diet fullDiet = null;

        do {
            System.out.println("1. Crear/reiniciar dieta\n" + "2. Mostrar información\n" + "3. Agregar alimento\n" + "4. Salir\n");
            select = Kb.forceNextInt();

            switch (select) {
                case 1:
                    fullDiet = newDiet();
                    break;
                case 2:
                    if (fullDiet != null) {
                        showData(fullDiet);
                    } else {
                        System.out.println("Primero debe crear una dieta.");
                    }
                    break;
                case 3:
                    if (fullDiet == null) {
                        System.out.println("Primero debe crear una dieta.");
                    } else {
                        addFood(fullDiet, listFood);
                    }
                    break;
                case 4:
                    exitMenu();
                    break;
                default:
                    System.out.println("No ha introducido un número válido.");
                    break;
            }
        } while (select != 4);
    }

    private static Diet newDiet() {
        System.out.println("1. Crear/reiniciar dieta: crea o reemplaza la dieta inicial\n" + "a. Sin límite\n" + "b. Por calorías\n" + "c. Por macronutrientes\n" + "d. Por datos personales\n");
        String select = Kb.nextLine();
        Diet newDiet = null;

        switch (select) {
            case "a":
                newDiet = new Diet();
                break;
            case "b":
                System.out.println("Ingrese el número máximo de calorías:");
                Integer calories = Kb.forceNextInt();
                newDiet = new Diet(calories);
                break;
            case "c":
                System.out.println("Ha elegido 'Por macronutrientes'.\nIngrese el número máximo de carbohidratos:");
                Integer carbs = Kb.forceNextInt();
                System.out.println("Ingrese el número máximo de grasas:");
                Integer fats = Kb.forceNextInt();
                System.out.println("Ingrese el número máximo de proteínas:");
                Integer proteins = Kb.forceNextInt();

                System.out.println("Has creado una dieta con un máximo de:\n - " + carbs + " gr de carbohidratos.\n - " + fats + " gr de grasas.\n - " + proteins + " gr de proteínas.");

                newDiet = new Diet(carbs, fats, proteins);
                break;
            case "d":
                System.out.println("La dieta va dirigida a un hombre (H) o una mujer (M)?:");
                String gender = Kb.nextLine();
                Boolean women;

                if (gender.equals("H")) {
                    women = false;
                    System.out.println("Ingrese su edad:");
                    Integer age = Kb.forceNextInt();
                    System.out.println("Ingrese su altura:");
                    Integer height = Kb.forceNextInt();
                    System.out.println("Ingrese su peso:");
                    Integer weight = Kb.forceNextInt();
                    System.out.println("Has creado una dieta para un hombre de " + age + " años, " + height + " cm de altura, y " + weight + " kg de peso.");
                    newDiet = new Diet(false, age, height, weight);
                } else if (gender.equals("M")) {
                    women = true;
                    System.out.println("Ingrese su edad:");
                    Integer age = Kb.forceNextInt();
                    System.out.println("Ingrese su altura en centímetros:");
                    Integer height = Kb.forceNextInt();
                    System.out.println("Ingrese su peso en kilos:");
                    Integer weight = Kb.forceNextInt();
                    newDiet = new Diet(true, age, height, weight);
                } else {
                    System.out.println("No ha seleccionado una opción válida. Debe introducir 'H' para Hombre o 'M' para Mujer.");
                }
                break;
            default:
                System.out.println("No ha introducido un valor válido.");
                break;
        }
        return newDiet;
    }

    private static void showData(Diet fullDiet) {
        System.out.println("2. Mostrar información: muestra calorías y macronutrientes de la dieta");
        System.out.println("Número total de carbohidratos: " + fullDiet.getTotalCarbs());
        System.out.println("Número total de grasas: " + fullDiet.getTotalFats());
        System.out.println("Número total de proteínas: " + fullDiet.getTotalProteins());
        System.out.println("Número total de calorías: " + fullDiet.getTotalCalories());
    }

    public static void addFood(Diet fullDiet, List<Food> listFood) {
        System.out.println("3. Agregar alimento: " + "a. Nuevo alimento\n" + "b. Alimento existente\n");
        String select = Kb.nextLine();

        switch (select) {
            case "a":
                System.out.println("Ha elegido 'Nuevo alimento'.\nEscriba el nombre del alimento que desea añadir:");
                String name = Kb.nextLine();
                System.out.println("Por cada 100gr:\nInserte carbohidratos:");
                Integer carbs = Kb.forceNextInt();
                System.out.println("Añada grasas:");
                Integer fats = Kb.forceNextInt();
                System.out.println("Añada proteínas:");
                Integer proteins = Kb.forceNextInt();
                System.out.println("Añada cantidad en gramos:");
                Integer foodWeight = Kb.forceNextInt();
                Food storedFood = new Food(name, carbs, fats, proteins);
                listFood.add(storedFood);

                break;
            case "b":
                if (listFood.isEmpty()) {
                    System.out.println("Añadir un alimento nuevo.");
                    addFood(fullDiet, listFood);
                } else {
                    System.out.println("Seleccione un alimento.");
                    for (int i = 0; i < listFood.size(); i++) {
                        System.out.println(i + ". " + listFood.get(i).getName());
                    }
                    Integer selectFood = null;
                    do {
                        selectFood = Kb.forceNextInt();
                        if (selectFood < 0 || selectFood >= listFood.size()) {
                            System.out.println("Ingrese un número válido entre 0 y " + (listFood.size() - 1));
                        }
                    } while (selectFood < 0 || selectFood >= listFood.size());

                    Food alimento = listFood.get(selectFood);
                    System.out.println("Escriba los gramos:");
                    Integer selectQuant = Kb.forceNextInt();

                    fullDiet.addFood(alimento, selectQuant);
                }
                break;
            default:
                System.out.println("Valor no válido.");
                break;
        }
    }

    private static void exitMenu() {
        System.out.println("Salir");
    }
}
