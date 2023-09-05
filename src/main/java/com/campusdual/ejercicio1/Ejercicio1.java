package com.campusdual.ejercicio1;


import java.util.Scanner;

public class Ejercicio1 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Escriba un año");
        Integer numero = teclado.nextInt();

        if(numero%4==0){
            if(numero % 100 == 0 && numero % 400 != 0){
                System.out.println("El año no es bisiesto");
            }else{
                System.out.println("El año es bisiesto");
            }
        }else{
            System.out.println("El año no es bisiesto");
        }
    }
}


