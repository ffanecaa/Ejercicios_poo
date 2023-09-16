package com.campusdual.apuntes.programciongenerica.clases_propias;
/* le indicamos q va a manejar una clase generica <T>
* por convencion T,U,K*/
public class Pareja <T>{

    public Pareja(){
        primero= null;
    }

    // setter
public void setPrimero(T nuevoValor){

        primero = nuevoValor;
    }
    public T getPrimero(){
        return primero;
    }
    private T primero;
}
