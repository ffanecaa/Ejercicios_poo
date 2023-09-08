package com.campusdual.apuntes.vehiculos;

public abstract class Vehiculos {
    private Integer pasajeros;
    private Integer velocidadMax;
    private Integer potencia;
    private String marcas;

    public Vehiculos(Integer pasajeros, Integer velocidadMax, Integer potencia) {
        this.pasajeros = pasajeros;
        this.velocidadMax = velocidadMax;
        this.potencia = potencia;

    }

    public String getMarcas() {

        return marcas;
    }

    public void setMarcas(String  marcas) {

        this.marcas = marcas;
    }

    public abstract void getDetails();


    public Integer calcularMovimiento(Integer segundos){
        return ((velocidadMax*segundos)*(potencia/pasajeros));
    }
}