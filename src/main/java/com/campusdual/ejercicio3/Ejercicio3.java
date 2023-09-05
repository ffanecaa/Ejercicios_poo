package com.campusdual.ejercicio3;
/*    */
public class Ejercicio3 {

    private Integer numero;
    private String valor;

    /* constructor */

    public Ejercicio3(Integer numero) {
        this.numero = numero;
    }

    public Ejercicio3(String valor) {
        this.valor = valor;
        this.numero = 0;
    }
    public  Ejercicio3( String valor, Integer numero){
        this.valor = valor;
        this.numero = numero;
    }
    /* ya existe segun parametros
    public  Ejercicio3( String valor, Integer numero){
        this.valor = valor;
        this.numero = numero;
    }*/
/* aqui si lo podemos hacer pq altero  los tipos*/
    public  Ejercicio3(  Integer numero, String y){
        this.numero = numero;
        this.valor = "cadena" + y;
    }


    public void printValues() {
        System.out.println( this.numero);
    }
}