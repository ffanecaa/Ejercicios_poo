package com.campusdual.ejercicio4d;
import java.util.ArrayList;
import java.util.List;

/*
Escribe una clase dieta, que teniendo en cuenta una serie de alimentos, vaya sumando cantidades en gramos y calcule cuantas calorías, carbohidratos, proteinas y grasas genera la ingesta
La clase dieta tiene que tener las siguientes funcionalidades:
	-Diet(): crea una dieta sin límite de calorías
	-Diet(Integer maxCalories): crea una dieta con un máximo de calorías, en cuanto se supera ese máximo cuando se adjunta un alimento se despliega un error
	-Diet(Integer maxFats, Integer maxCarbs, Integer maxProtein): crea una dieta con un máximo de estos tres valores, si se supera alguno de ellos cuando se adjunta un alimento se indicara cual y desplegará un error
	-Diet(Boolean women, Integer age, Integer height, Integer weight): Calcula el metabolismo basal de la persona y lo asigna como máximo de calorías en la dieta
		--CALCULAR METABOLISMO BASAL
			E = edad
			A = altura en centímetros
			P = peso en kilos

			Fórmula Hombres: TMB = 10P + 6,25A – 5E + 5
			Fórmula Mujeres: TMB = 10P + 6,25A – 5E – 161
	-addFood(Food,Integer): agrega un alimento y una cantidad en gramos X
	-getTotalCalories(): devuelve el total de calorías
	-getTotalCarbs(): devuelve el total de carbohidratos
	-getTotalFats(): devuelve el total de grasas
	-getTotalProteins(): devuelve el total de proteinas
*/
public class Diet {
    Integer maxCalories;
    Double maxBasalCalories;
    Integer maxFats;
    Integer maxCarbs;
    Integer maxProteins;
    List<FoodWithWeight> listFood;


    public Diet() {
        listFood = new ArrayList<>();
    }

    public Diet(Integer maxCalories) {
        this.maxCalories = maxCalories;
        listFood = new ArrayList<>();
    }

    public Diet(Integer maxFats, Integer maxCarbs, Integer maxProteins) {
        this.maxFats = maxFats;
        this.maxCarbs = maxCarbs;
        this.maxProteins = maxProteins;
        listFood = new ArrayList<>();
    }

    public Diet(Boolean women, Integer age, Integer height, Integer weight) {
//        this.women = women;
//        this.age = age;
//        this.height = height;
//        this.weight = weight;
        maxBasalCalories = null;
        if (!women) {
            maxBasalCalories = (10 * weight) + (6.25 * height) - (5 * age) + 5;
            System.out.println(" calorias máximas : " + maxBasalCalories);

        }
        else if (women){
            maxBasalCalories = (10 * weight) + (6.25 * height) - (5 * age) - 161;
            System.out.println(" calorias máximas : " + maxBasalCalories);

        }
        listFood = new ArrayList<>();
    }
    public List<FoodWithWeight> getListFood() {
        return listFood;
    }

    public void setListFood(List<FoodWithWeight> listFood) {
        this.listFood = listFood;
    }

    public void addFood(FoodWithWeight food) {
//        listFood.add(food);
        if (maxCalories != null && maxCalories < (getTotalCalories() + food.calculatedCalories())) {
            System.out.println("Ha superado el límite de calorias establecido.");
        }
        else {
            listFood.add(food);
        }
        if (maxCarbs != null && maxFats != null && maxProteins != null) {
            if (maxCarbs < (getTotalCarbs() + food.calculatedCarbs()) || maxFats < (getTotalFats() + food.calculatedFats()) || maxProteins < (getTotalProteins() + food.calculatedProteins())) {
                System.out.println(" superado el límite de macronutrientes establecido.");
            }
        }
        else {
            listFood.add(food);
        }
        if (maxBasalCalories != null && maxBasalCalories < (getTotalCalories() + food.calculatedCalories())) {
            System.out.println(" superado el límite de calorias establecido según tu metabolismo basal.");
        }
        else {
            listFood.add(food);
        }
    }

    public Integer getTotalCalories() {
        Integer resultCalories = 0;
        for (FoodWithWeight actualFood :
                listFood) {
            Integer calories = actualFood.calculatedCalories();
            resultCalories = resultCalories + calories;
        }
        return resultCalories;
    }

    public Integer getTotalCarbs() {
        Integer resultCarbs = 0;
        for (FoodWithWeight actualFood :
                listFood) {
            Integer carbs = actualFood.calculatedCarbs();
            resultCarbs = resultCarbs + carbs;
        }
        return resultCarbs;
    }

    public Integer getTotalFats() {
        Integer resultFats = 0;
        for (FoodWithWeight actualFood :
                listFood) {
            Integer fats = actualFood.calculatedFats();
            resultFats = resultFats + fats;
        }
        return resultFats;
    }

    public Integer getTotalProteins() {
        Integer resultProteins = 0;
        for (FoodWithWeight actualFood :
                listFood) {
            Integer proteins = actualFood.calculatedProteins();
            resultProteins = resultProteins + proteins;
        }
        return resultProteins;
    }
}