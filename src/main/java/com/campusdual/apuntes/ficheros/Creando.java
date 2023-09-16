package com.campusdual.apuntes.ficheros;
import java.io.*;
public class Creando {

    public static void main(String[] args) {

       // File ruta = new File("C:/Users/marti/OneDrive/Documentos/GitHub/ejerci_poo/ejercicios_poo/src/main/java/com/campusdual/apuntes/ficheros/nuevo_directorio");
      /*genero directorio*/
       // ruta.mkdir();
        File ruta = new File("C:/Users/marti/OneDrive/Documentos/GitHub/ejerci_poo/ejercicios_poo/src/main/java/com/campusdual/apuntes/ficheros/nuevo_directorio.txt");

        String archivo_destino = ruta.getAbsolutePath();

        // create new file lo hace solo si no existe
        // genra excepcion IOException la sorteamos try catch
        try {
            ruta.createNewFile();
        } catch (IOException e) {
           e.printStackTrace();
        }

        Escribiendo accede_es = new Escribiendo();
        accede_es.escribir(archivo_destino);
    }
}

class  Escribiendo {
    public void escribir(String ruta_archivo ){
        String frase = "Esto es un ejemplo";
        try {
      FileWriter escritura = new FileWriter(ruta_archivo);

       for(int i=0 ; i< frase.length();i++){
      escritura.write(frase.charAt(i));
       }
       escritura.close();
        } catch(IOException e){
    }

}
}
