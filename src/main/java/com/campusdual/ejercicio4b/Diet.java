package com.campusdual.ejercicio4b;

public class Diet {
    private Integer maxCalories;
    private Integer maxFats;
    private Integer maxCarbs;
    private Integer maxProtein;
    private Integer totalCalories;
    private Integer totalCarbs;
    private Integer totalFats;
    private Integer totalProtein;
    private Integer grams;

    public Diet() {
        this.totalCalories = 0;
        this.totalCarbs = 0;
        this.totalFats = 0;
        this.totalProtein = 0;
        this.grams = 0;
    }

    public Diet(Integer maxCalories) {
        this();
        this.maxCalories = maxCalories;
    }

    public Diet(Integer maxFats, Integer maxCarbs, Integer maxProtein) {
        this();
        this.maxFats = maxFats;
        this.maxCarbs = maxCarbs;
        this.maxProtein = maxProtein;
    }

    public Diet(Boolean women, Integer age, Integer height, Integer weight) {
        int maxCalories = calculateTMB(women, age, height, weight);
        this.maxCalories = maxCalories;
    }

    private int calculateTMB(Boolean women, Integer age, Integer height, Integer weight) {
        if (women) {
            return (int) (10 * weight + 6.25 * height - 5 * age - 161);
        } else {
            return (int) (10 * weight + 6.25 * height - 5 * age + 5);
        }
    }

    public void addFood(Food food, Integer foodGrams) {
        totalCalories += food.getCalories(foodGrams);
        totalFats += (food.getFats() * foodGrams) / 100; // Corregido el cálculo de grasas
        totalCarbs += (food.getCarbos() * foodGrams) / 100; // Corregido el cálculo de carbohidratos
        totalProtein += (food.getProteins() * foodGrams) / 100; // Corregido el cálculo de proteínas
        grams += foodGrams;
    }

    public Integer getTotalCalories() {
        return totalCalories;
    }

    public Integer getTotalCarbs() {
        return totalCarbs;
    }

    public Integer getTotalFats() {
        return totalFats;
    }

    public Integer getTotalProteins() {
        return totalProtein;
    }

    public Integer getTotalGrams() {
        return grams;
    }
}
