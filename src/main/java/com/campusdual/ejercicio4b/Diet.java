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

    /*public void addFood(Food food, Integer foodGrams) {
        if (totalCalories + (food.getCalories(foodGrams)) > maxCalories) {
            throw new IllegalArgumentException("Se superó el límite de calorías permitidas.");
        }
        if (totalFats + (food.getFats() * foodGrams) > maxFats) {
            throw new IllegalArgumentException("Se superó el límite de grasas permitidas.");
        }
        if (totalCarbs + (food.getCarbos() * foodGrams) > maxCarbs) {
            throw new IllegalArgumentException("Se superó el límite de carbohidratos permitidos.");
        }
        if (totalProtein + (food.getProteins() * foodGrams) > maxProtein) {
            throw new IllegalArgumentException("Se superó el límite de proteínas permitidas.");
        }


*/  /* para el 3 caso tengo max  limitantes que jj lo soluciona con excepciones */
    public void addFood(Food food, Integer foodGrams) {
        totalCalories += food.getCalories(foodGrams);
        totalFats += food.getFats() * foodGrams;
        totalCarbs += food.getCarbos() * foodGrams;
        totalProtein += food.getProteins() * foodGrams;
        grams += foodGrams;
      /*  public void addFood(Food food, Integer foodGrams) {
            if (totalCalories + (food.getCalories(foodGrams)) > maxCalories) {
                throw new IllegalArgumentException("Se superó el límite de calorías permitidas.");
            } else{
        totalCalories += food.getCalories(foodGrams);
        totalFats += food.getFats() * foodGrams;
        totalCarbs += food.getCarbos() * foodGrams;
        totalProtein += food.getProteins() * foodGrams;
        grams += foodGrams;*/
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
