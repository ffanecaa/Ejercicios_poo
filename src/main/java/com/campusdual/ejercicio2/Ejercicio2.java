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

             case 2:

            case 4:

            case 6:

            case 8:


            case 9:


            case 10:

            case 12:

            case 14:


            case 15:


            case 16:

            case 18:

            case 20:
                System.out.println("no es primo");
                break;

            case 3:


            case 5:


            case 7:


            case 11:


            case 13:



            case 17:



            case 19:
                System.out.println(" es primo");
                break;


            default:
                System.out.println("no esta entre 1 y 20.");
        }
    }
}
