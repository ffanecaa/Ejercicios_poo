package com.campusdual.apuntes.vehiculos;

public class Coche extends  Vehiculos{
   private String combustible;
   private Integer puertas;
   private String color;

    public Coche(Integer pasajeros, Integer velocidadMax, Integer potencia, String marcas, String combustible, Integer puertas, String color) {
        super(pasajeros, velocidadMax, potencia);
        this.combustible = combustible;
        this.puertas = puertas;
        this.color = color;
    }

    @Override
    public void getDetails() {
        System.out.println("Este coche tiene "+puertas+" puertas");
    }
}