package com.campusdual.apuntes.programciongenerica;

public class ArrayList2 {
    // contructor recibe numero entero
    // si al constructor le pasamos un 3 le pasamos eso al array
    public ArrayList2(int z ){
        datosElemento = new Object[z];
    }

    // metodo devuelve un elemento en concreto
    public Object get (int i){
        return datosElemento[i];

    }

    // se almacena en la posicion el objeto
    public void add(Object o){
        datosElemento[i]=o;
        i++;
    }
    // array datoselemento
    private Object[] datosElemento;
    private  int i=0;
}
