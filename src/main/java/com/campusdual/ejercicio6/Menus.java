package com.campusdual.ejercicio6;


import java.util.ArrayList;
import java.util.List;

public class Menus {

    private List<Food> alimentos;
    private Dietas dieta;

    public Menus(Dietas dieta) {
        this.alimentos = new ArrayList<>();
        this.dieta = dieta;
    }



    public void imprimirMenu() {
        System.out.println("----- Menú -----");
        for (Food alimento : alimentos) {
            System.out.println(alimento.dameDatosFood());
        }
        System.out.println("----------------");
        System.out.println("Totales:");
        System.out.println("Calorías: " + dieta.getTotalCalories());
        System.out.println("Carbohidratos: " + dieta.getTotalCarbs());
        System.out.println("Grasas: " + dieta.getTotalFats());
        System.out.println("Proteínas: " + dieta.getTotalProteins());
    }
}
