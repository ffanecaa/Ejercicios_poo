package com.campusdual.apuntes.array;

import com.sun.source.tree.UsesTree;

import java.util.ArrayList;
import java.util.HashSet;

public class Array {
    public static void main(String[] args) {
        Integer[] array = {1,2,3,4,5};
        for (int i = 0; i < array.length; i++) {
            System.out.println( "valor"+i+":"+array[i]);
        }

        for(Integer elemento:array){
            System.out.println( "valor"+ elemento);
        }

        ArrayList<Integer> arrayL = new ArrayList<>();
        arrayL.add(1);
        arrayL.add(2);
        ArrayList<Integer> arrayL2 = new ArrayList<>();
        arrayL2.addAll(arrayL);
        arrayL2.add(4);
        for(Integer elemento:arrayL2){
            System.out.println("valor:"+elemento );



            // con split si que usamos arrays sino arrayl

            String frase ="tres tristes tigres tomaban trigo";
            String[] fraseSplit = frase.split( " ");


            /*colecciones ArrayL
            padre coleccion
            conjuntos : no admiten objectos iguales
            */
/*
            Set<Integer> colecion = new HashSet<>();
            colecion.add(1);
            colecion.add(2);
            colecion.add(1);*/



        }
    }
}
