package com.campusdual.apuntes.ficheros;
import java.io.*;
public class Pruebas_rutas {
    public static void main(String[] args) {

        File archivo = new File("ejemplo_archivo");
       /* getAbP => imprime ruta absoluta archivo*/
        System.out.println( archivo.getAbsolutePath());
        /*verifica si el archivo existe*/
        System.out.println(archivo.exists() );
      /* tb verifica directorios */





    }
}
