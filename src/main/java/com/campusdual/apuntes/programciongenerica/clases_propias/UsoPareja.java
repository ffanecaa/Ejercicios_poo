package com.campusdual.apuntes.programciongenerica.clases_propias;

public class UsoPareja {
    public static void main(String[] args) {

        // instanciar classe pareja

        Pareja<String> una = new Pareja<String>();

        // inicialmente indicamos null
        // ahora con el metodo setter cambiamos valor

      una.setPrimero("mRTA");

        System.out.println(una.getPrimero());

//ej 2 instancia clase perosna

        Persona person1 =new Persona("ana");
        Pareja<Persona> otra =new Pareja<Persona>();
    otra.setPrimero(person1);
        System.out.println(otra.getPrimero());
    }

    }





    class Persona{
        public Persona(String nombre){
            this.nombre = nombre;
        }

        private String nombre;

        // metodo object para que un objeto devuelva string
     //   sino devuelve memoria
    public String toString(){
        return nombre;
    }

    }





