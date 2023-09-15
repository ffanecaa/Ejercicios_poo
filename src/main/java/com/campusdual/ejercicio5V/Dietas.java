package com.campusdual.ejercicio5V;

public class Dietas {
    private Integer maxCalories;
    private Integer maxFats;
    private Integer maxCarbs;
    private Integer maxProtein;
    private Integer totalCalories;
    private Integer totalCarbs;
    private Integer totalFats;
    private Integer totalProtein;
    private Integer grams;

    public Dietas() {
        this.totalCalories = 0;
        this.totalCarbs = 0;
        this.totalFats = 0;
        this.totalProtein = 0;
        this.grams = 0;
    }

    public Dietas(Integer maxCalories) {
        this();
        this.maxCalories = maxCalories;
    }

    public Dietas(Integer maxFats, Integer maxCarbs, Integer maxProtein) {
        this();
        this.maxFats = maxFats;
        this.maxCarbs = maxCarbs;
        this.maxProtein = maxProtein;
    }

    public Dietas(Boolean women, Integer age, Integer height, Integer weight) {
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

    public void addAlimentos(Alimentos alimento, Integer foodGrams) {
        if (maxCalories != null && totalCalories + alimento.getCalories(foodGrams) > maxCalories) {
            System.out.println("Error: Se ha superado el límite de calorías.");
            return;
        }

        if (maxFats != null && totalFats + (alimento.getFats() * foodGrams) / 100 > maxFats) {
            System.out.println("Error: Se ha superado el límite de grasas.");
            return;
        }

        if (maxCarbs != null && totalCarbs + (alimento.getCarbos() * foodGrams) / 100 > maxCarbs) {
            System.out.println("Error: Se ha superado el límite de carbohidratos.");
            return;
        }

        if (maxProtein != null && totalProtein + (alimento.getProteins() * foodGrams) / 100 > maxProtein) {
            System.out.println("Error: Se ha superado el límite de proteínas.");
            return;
        }

        totalCalories += alimento.getCalories(foodGrams);
        totalFats += (alimento.getFats() * foodGrams) / 100;
        totalCarbs += (alimento.getCarbos() * foodGrams) / 100;
        totalProtein += (alimento.getProteins() * foodGrams) / 100;
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
