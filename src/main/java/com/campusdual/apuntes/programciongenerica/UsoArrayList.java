package com.campusdual.apuntes.programciongenerica;
import java.io.*;
public class UsoArrayList {
    public static void main(String[] args) {

        // uso clase para almanezar

    ArrayList2 archivos = new ArrayList2(4); // le decimos array 4 elementos

        // almacenamos
        archivos.add("juan");
        archivos.add("pedro");
        archivos.add("pablo");
        archivos.add("pepe");
        archivos.add(new File("loqueando"));

        // falla pq no puede pasar obj a string
        // nos obliga a hacer casteo
     // NO   String nombrePersona = archivos.get(2);

        String nombrePersona = (String) archivos.get(2);

        System.out.println( nombrePersona);


        // si queremos manejar datos de tipo file
/*
        archivos.add(new File("C:/Users/marti/OneDrive/Documentos/GitHub/ejerci_poo/ejercicios_poo/src/main/java/com/campusdual/apuntes/ficheros/nuevo_directorio.txt"));
        File nombrePersonas = (File)archivos.get(0);
        System.out.println( nombrePersonas);
*/
    }
}
