package com.campusdual.ejercicio6_;


import java.util.ArrayList;
import java.util.List;

public class Menus {

    private List<Food> alimentos;
    private Dietas dieta;

    public Menus(Dietas dieta) {
        this.alimentos = new ArrayList<>();
        this.dieta = dieta;
    }


/*
    public static void imprimirMenu() {
        System.out.println("----- Menú -----");
        for (Food alimento : Food.) {
            System.out.println(alimento.dameDatosFood());
        }

        System.out.println("----------------");
        System.out.println("Totales:");
        System.out.println("Calorías: " + Dietas.getTotalCalories());
        System.out.println("Carbohidratos: " + Dietas.getTotalCarbs());
        System.out.println("Grasas: " + Dietas.getTotalFats());
        System.out.println("Proteínas: " + Dietas.getTotalProteins());
    }
*/}
