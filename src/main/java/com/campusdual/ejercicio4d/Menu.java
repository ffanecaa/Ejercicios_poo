package com.campusdual.ejercicio4d;

import java.util.*;

/*
--Escribe un programa que utilice la clase Dieta y despliegue un menú donde puedas añadir alimentos. El menú tendrá las siguientes opciones.
	-1. Crear/reiniciar dieta: crea o remplaza la dieta inicial
		-a. Sin limite
		-b. Por calorías
		-c. Por macronutrientes
		-d. Por datos personales
	-2. Mostrar información: muestra calorías y macronutrientes de la dieta
	-3. Agregar alimento: agrega un alimento a la dieta actual y añade ese alimento a la lista de alimentos disponible
		-a. Nuevo alimento
		-b. Alimento existente
	-4. Salir
*/
public class Menu {
    private static final List<Ffood> listFood = new ArrayList<>();
    public static void main(String[] args) {
        mainMenu();
    }
    private static void mainMenu(){
        Scanner entry = new Scanner(System.in);
        Integer select;
        Diet fullDiet = null;
        do {
            System.out.println("1.Crear/reiniciar dieta\n"+"2.Mostrar información\n"+"3.Agregar alimento\n"+"4.Salir\n ~~~~~~~~~~~~~~~~~~~~~");
            select = entry.nextInt();
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
                    }
                    else {
                        addFood(fullDiet, listFood);
                    }
                    break;
                case 4:
                    exitMenu();
                    break;
                default:
                    System.out.println("No ha introducido un número valido.");
                    break;
            }
        }
        while (select != 4);
    }
    private static Diet newDiet() {
        Scanner entry = new Scanner(System.in);
        System.out.println("1.Crear/reiniciar dieta: crea o remplaza la dieta inicial\n"+"a.Sin límite\n"+"b.Por calorias\n"+"c.Por macronutrientes\n"+"d.Por datos personales\n");
        String select = entry.next();
        Diet newDiet = null;

        switch (select) {
            case "a":
                newDiet = new Diet();
                break;
            case "b":

                Integer calories = entry.nextInt();
                newDiet = new Diet(calories);
                break;
            case "c":
                System.out.println("Ha elegido 'Por macronutrientes'.\n Ingrese el número máximo de carbohidratos:\n");
                Integer carbs = entry.nextInt();
                System.out.println("Ingrese el número máximo de grasas:\n");
                Integer fats = entry.nextInt();
                System.out.println("Ingrese el número máximo de proteinas:\n");
                Integer proteins = entry.nextInt();

                System.out.println("Has creado una dieta con un máximo de:\n - " + carbs + " gr de carbohidratos.\n - " + fats + " gr de grasas.\n - " + proteins + " gr de proteinas.");

                newDiet = new Diet(carbs, fats, proteins);
                break;
            case "d":
                System.out.println("La dieta va dirigida a un hombre (H) o una mujer (M)?:\n");
                String gender = entry.next();
                Boolean women;
                if (gender.equals("H")){
                    women = false;
                    System.out.println("Ingrese su edad:\n");
                    Integer age = entry.nextInt();
                    System.out.println("Ingrese su altura:\n");
                    Integer height = entry.nextInt();
                    System.out.println("Ingrese su peso:\n");
                    Integer weight = entry.nextInt();
                    System.out.println("Has creado una dieta para un hombre de " + age + " años, " + height + "cm de altura, y " + weight + "kg de peso.");
                    newDiet = new Diet(false, age, height, weight);
                }
                else if (gender.equals("M")){
                    women = true;
                    System.out.println("Ingrese su edad:\n");
                    Integer age = entry.nextInt();
                    System.out.println("Ingrese su altura en centímetros:\n");
                    Integer height = entry.nextInt();
                    System.out.println("Ingrese su peso en kilos:\n");
                    Integer weight = entry.nextInt();
                    newDiet = new Diet(true, age, height, weight);
                }
                else {
                    System.out.println("No ha seleccionado una opción valida. Debes introducir 'H' para Hombre o 'M' para Mujer.");
                }
                break;
            default:
                System.out.println("No ha introducido un valor valido.");
                break;
        }
        return newDiet;
    }
    private static void showData(Diet fullDiet) {
        System.out.println("2. Mostrar información: muestra calorías y macronutrientes de la dieta");
        System.out.println("Numero total de carboshidratos: " + fullDiet.getTotalCarbs());
        System.out.println("Numero total de grasas: " + fullDiet.getTotalFats());
        System.out.println("Numero total de proteinas: " + fullDiet.getTotalProteins());
        System.out.println("Numero total de calorias: " + fullDiet.getTotalCalories());
    }
    public static void addFood(Diet fullDiet, List<Ffood> listFood) {
        Scanner entry = new Scanner(System.in);
        System.out.println("3. Agregar alimento: "+"a.Nuevo alimento\n"+"b.Alimento existente\n");
        String select = entry.next();
        switch (select){
            case "a":
                System.out.println("Ha elegido 'Nuevo alimento'.\n Escriba el nombre del alimento que desea añadir:\n");
                String foodName = entry.next();
                System.out.println("Por cada 100gr:\n Inserte carbohidratos:\n");
                Integer foodCarbs = entry.nextInt();
                System.out.println("añada grasas:\n");
                Integer foodFats = entry.nextInt();
                System.out.println("añada proteinas:\n");
                Integer foodProteins = entry.nextInt();
                System.out.println("añada cantidad en gramos:\n");
                Integer foodWeight = entry.nextInt();
                Ffood storedFood = new Ffood(foodCarbs, foodFats, foodProteins, foodName);
                listFood.add(storedFood);
                FoodWithWeight newFood = new FoodWithWeight(storedFood, foodWeight);
                fullDiet.addFood(newFood);
                break;
            case "b":
                if (listFood.isEmpty()){
                    System.out.println("añadir un alimento nuevo.\n");
                    addFood(fullDiet, listFood);
                }
                else {
                    System.out.println(" Seleccione un alimento.\n");
                    for (int i = 0; i < listFood.size(); i++) {
                        System.out.println(i + ". " + listFood.get(i).getFoodName());
                    }
                    Integer selectFood = null;
                    do {
                        selectFood = entry.nextInt();
                        if (selectFood < 0 || selectFood >= listFood.size()) {
                            System.out.println("Ingrese un numero valido " + (listFood.size() - 1) );
                        }
                    }
                    while (
                            selectFood < 0 || selectFood >= listFood.size()
                    );
                    Ffood alimento = listFood.get(selectFood);
                    System.out.println("Escriba los gramos:\n");
                    Integer selectQuant = entry.nextInt();
                    fullDiet.addFood(new FoodWithWeight(alimento, selectQuant)); //Creamos un nuevo FoodWW desde el propio parametro del metodo.
                }
                break;
            default:
                System.out.println(" valor no valido.");
                break;
        }
    }
    private static void exitMenu() {
        System.out.println("salir");
    }
}
