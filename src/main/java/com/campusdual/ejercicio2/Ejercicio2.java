package com.campusdual.ejercicio2;
import java.util.Scanner;


/*  switch escrir un progrma si es primo o no entre 1-20 */
public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println( "escribe un numero del 1 al 20");
        Integer numero = teclado.nextInt();


        switch (numero) {

             case 1:
                System.out.println("no es primo");
             case 2:
                System.out.println("no es primo");
            case 4:
                System.out.println("no es primo");
            case 6:
                System.out.println("no es primo");
            case 8:
                System.out.println("no es primo");

            case 9:
                System.out.println(" no es primo");

            case 10:
                System.out.println("no es primo");

            case 12:
                System.out.println("no es primo");
            case 14:
                System.out.println("no es primo");

            case 15:
                System.out.println("no es primo");

            case 16:
                System.out.println("no es primo");
            case 18:
                System.out.println("no es primo");
            case 20:
                System.out.println("no es primo");
                break;

            case 3:
                System.out.println(" es primo");

            case 5:
                System.out.println(" es primo");


            case 7:
                System.out.println(" es primo");

            case 11:
                System.out.println(" es primo");


            case 13:
                System.out.println(" es primo");


            case 17:
                System.out.println(" es primo");


            case 19:
                System.out.println(" es primo");
                break;


            default:
                System.out.println("no esta entre 1 y 20.");
        }
    }
}
