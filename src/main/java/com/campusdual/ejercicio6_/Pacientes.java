package com.campusdual.ejercicio6_;

/*
* -Se pueden dar de alta personas: Las personas tendrán los siguientes atributos:
*  nombre, apellidos, peso,
 altura, edad y sexo.
//    -Las personas podrán tener asignadas una lista de dietas que se
* catalogarán de lunes a domingo sacadas de
la lista de dietas anterior.
//    -Se agregara un apartado nuevo al menú de "Gestión de pacientes" con las
* siguientes funcionalidades:
//      1- Dar de alta un paciente : Agregará un paciente nuevo a la lista de pacientes
//      2- Listar y Mostrar detalles de un paciente : Mostrará el detalle de un paciente así
*  como todas
 sus dietas listadas de Lunes a domingo y permite modificar sus datos y asignar dietas
//      3- Dar de baja un paciente: Elimina los datos de un paciente(No borra sus dietas asignadas
*  dado que
pueden estar asignadas a otro paciente)*/

public class Pacientes {
    /*-Se pueden dar de alta personas: Las personas tendrán los siguientes atributos:
*  nombre, apellidos, peso,
 altura, edad y sexo.*/

     private String nombre;
     private String apellido;
     private Integer peso;
     private Integer altura;
     private Integer edad;
     private String genero;
    int Id;
    private static int IdSiguiente =1;

    public Pacientes(String nombre, String apellido, Integer peso,
                     Integer altura, Integer edad, String genero) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.peso = peso;
        this.altura = altura;
        this.edad = edad;
        this.genero = genero;
        Id= IdSiguiente;
        IdSiguiente++;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    public Integer getAltura() {
        return altura;
    }

    public void setAltura(Integer altura) {
        this.altura = altura;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }



    public String obtenerContenido() {
        return Id +" "+ nombre +" "+ apellido+" "+ "tiene"+ " "+edad+" "+ "peso: "+peso+" "+ "altura:"+altura+" "+"edad"+edad+" "+ "genero:"+genero;
    }
/*  1- Dar de alta un paciente : Agregará un paciente nuevo a la lista de pacientes
//      2- Listar y Mostrar detalles de un paciente : Mostrará el detalle de un paciente así
*  como todas
 sus dietas listadas de Lunes a domingo y permite modificar sus datos y asignar dietas
//      3- Dar de baja un paciente: Elimina los datos de un paciente(No borra sus dietas asignadas
*  dado que
pueden estar asignadas a otro paciente)  */
}
