package com.campusdual.ejercicio5V;



public class Asociacion {
    private Pacientes paciente;
    private Dietas dieta;

    public Asociacion(Pacientes paciente, Dietas dieta) {
        this.paciente = paciente;
        this.dieta = dieta;
    }

    public Pacientes getPaciente() {
        return paciente;
    }

    public Dietas getDieta() {

        return dieta;
    }
}
