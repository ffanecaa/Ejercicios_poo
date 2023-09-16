package com.campusdual.ejercicio6;



public class Dietas {

    
        private Integer maxCalories;
        private Integer maxFats;
        private Integer maxCarbs;
        private Integer maxProtein;
        private Integer totalCalories;
        private Integer totalCarbs;
        private Integer totalFats;
        private Integer totalProtein;

        int Id;
         private String nombre;
    private static int IdSiguiente =1;

        public Dietas(String nombre) {
            this.totalCalories = 0;
            this.totalCarbs = 0;
            this.totalFats = 0;
            this.totalProtein = 0;
            this.nombre = nombre;
            Id= IdSiguiente;
            IdSiguiente++;
        }

        public Dietas(Integer maxCalories, String nombre) {
            this();
            this.maxCalories = maxCalories;
            this.nombre = nombre;
        }

        public Dietas(String nombre,Integer maxFats, Integer maxCarbs, Integer maxProtein) {
            this();
            this.maxFats = maxFats;
            this.maxCarbs = maxCarbs;
            this.maxProtein = maxProtein;
            this.nombre = nombre;
        }

    public Dietas() {
        this.totalCalories = 0;
        this.totalCarbs = 0;
        this.totalFats = 0;
        this.totalProtein = 0;
        this.nombre = " ";
        Id= IdSiguiente;
        IdSiguiente++;
    }


    public void addFood(Food Food, Integer foodGrams) {
            if (maxCalories != null && totalCalories + Food.getCalorias(foodGrams) > maxCalories) {
                System.out.println("Error: Se ha superado el límite de calorías.");
                return;
            }

            if (maxFats != null && totalFats + (Food.getGrasas() * foodGrams) / 100 > maxFats) {
                System.out.println("Error: Se ha superado el límite de grasas.");
                return;
            }

            if (maxCarbs != null && totalCarbs + (Food.getCarbos() * foodGrams) / 100 > maxCarbs) {
                System.out.println("Error: Se ha superado el límite de carbohidratos.");
                return;
            }

            if (maxProtein != null && totalProtein + (Food.getProteinas() * foodGrams) / 100 > maxProtein) {
                System.out.println("Error: Se ha superado el límite de proteínas.");
                return;
            }

            totalCalories += Food.getCalorias(foodGrams);
            totalFats += (Food.getGrasas() * foodGrams) / 100;
            totalCarbs += (Food.getCarbos() * foodGrams) / 100;
            totalProtein += (Food.getProteinas() * foodGrams) / 100;

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



    public String obtenerDietas() {
        return Id +" "+ nombre +" "+ "tiene un total de "+ " "+totalCalories+" calorias "+ " un total de grasas: "+totalFats+" gramos "+ " un total proteinas :"+totalProtein+" ";
    }
    }

