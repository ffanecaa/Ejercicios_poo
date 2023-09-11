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

        if (maxCalories != null && totalCalories + food.getCalories(foodGrams) > maxCalories) {
            System.out.println("Error: Se ha superado el límite de calorías.");
            return;
        }

        if (maxFats != null && totalFats + (food.getFats() * foodGrams) / 100 > maxFats) {
            System.out.println("Error: Se ha superado el límite de grasas.");
            return;
        }

        if (maxCarbs != null && totalCarbs + (food.getCarbos() * foodGrams) / 100 > maxCarbs) {
            System.out.println("Error: Se ha superado el límite de carbohidratos.");
            return;
        }

        if (maxProtein != null && totalProtein + (food.getProteins() * foodGrams) / 100 > maxProtein) {
            System.out.println("Error: Se ha superado el límite de proteínas.");
            return;
        }
        totalCalories += food.getCalories(foodGrams);
        totalFats += (food.getFats() * foodGrams) / 100;
        totalCarbs += (food.getCarbos() * foodGrams) / 100;
        totalProtein += (food.getProteins() * foodGrams) / 100;
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
