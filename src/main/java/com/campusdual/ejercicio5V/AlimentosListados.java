package com.campusdual.ejercicio5V;

import java.util.HashMap;
import java.util.Map;

public class AlimentosListados {
    private Map<String, Alimentos> alimentosMap;

    public AlimentosListados() {
        this.alimentosMap = new HashMap<>();
    }

    public void agregarAlimento(Alimentos alimento) {
        alimentosMap.put(alimento.getName(), alimento);
    }

    public Alimentos obtenerAlimento(String nombre) {
        return alimentosMap.get(nombre);
    }

    public void mostrarAlimentos() {
        System.out.println("Listado de Alimentos:");
        for (Map.Entry<String, Alimentos> entry : alimentosMap.entrySet()) {
            String nombre = entry.getKey();
            Alimentos alimento = entry.getValue();
            System.out.println("Nombre: " + nombre + ", Carbos: " + alimento.getCarbos() +
                    ", Grasas: " + alimento.getFats() + ", Proteínas: " + alimento.getProteins());
        }
    }
}
