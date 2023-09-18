package com.campusdual.ejercicio6b;

import com.campusdual.ejercicio6_.ArchivoGestor;
import com.campusdual.ejercicio6_.Food;
import com.campusdual.ejercicio6_.ListaAlimentos;


import java.util.ArrayList;

public class Dietas {

    String ruta = "C:/Users/marti/OneDrive/Documentos/GitHub/ejerci_poo/ejercicios_poo/src/main/java/com/campusdual/alimentos.txt";

    private Integer maxCalories;
    private Integer maxFats;
    private Integer maxCarbs;
    private Integer maxProtein;
    private Integer totalCalories;
    private Integer totalCarbs;
    private Integer totalFats;
    private Integer totalProtein;
    private Integer gramos;
    ArrayList<String> alimentosGuardados = ArchivoGestor.recuperarContenidoComoArrayList(ruta);

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

        totalCalories += Food.getCalorias(ListaAlimentos.asociarGramosyFood().getGramos());
        totalFats += (Food.getGrasas() * ListaAlimentos.asociarGramosyFood().getGrasas()) / 100;
        totalCarbs += (Food.getCarbos() * ListaAlimentos.asociarGramosyFood().getCarbos()) / 100;
        totalProtein += (Food.getProteinas() * ListaAlimentos.asociarGramosyFood().getProteinas()) / 100;

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