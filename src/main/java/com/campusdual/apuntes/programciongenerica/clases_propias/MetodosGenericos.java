package com.campusdual.apuntes.programciongenerica.clases_propias;



public class MetodosGenericos {
    public static void main(String[] args) {
//creamoa array
String nombres []={"jose","maria","pepe"};
System.out.println(MisMatrices.getMenor(nombres) );
/*
String elementos = MisMatrices.getElementos(nombres);
        System.out.println(elementos);

        Empleado listaEmpleados[]= {new Empleado("ana", 45, 2500),
        new Empleado("ana", 45, 2500),
        new Empleado("ana", 45, 2500)
        };

        System.out.println( MisMatrices.getElementos(listaEmpleados)+"MetodoGenerico");

*/





    }
}

// metodo generico

/*
    public  static <T> String getElementos(T[]a){
        return  "el array tiene "+ a.length+ " elementos";*/
    //ahora le digo q yano recibo string sino metodo gent T
class MisMatrices{
    //comparable es lo que perimrte usar compareTo()
        public  static <T extends Comparable > T getMenor(T[]a) {
            if (a == null || a.length == 0) {
                return null;
            }
            //metodo compareTo compara arrays
            // genero variable generica
            T elementoMenor = a[0];
            for (int i = 1; i < a.length; i++) {
                if (elementoMenor.compareTo(a[i]) > 0) {
                    elementoMenor = a[i];
                }
            }
            return elementoMenor;
        }
}




class Empleado{


    public Empleado(String nombre, Integer edad, double salario) {
        this.nombre = nombre;
        this.edad = edad;
        this.salario = salario;
    }

    public String dameDatos(){
        return "el empleado se llama"+ " "+ nombre +" " + "tiene"+ " "+edad+" "+ "y un salario de "+salario;
    }

    private String nombre;
    private Integer edad;
    private double salario;
}