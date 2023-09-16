package com.campusdual.apuntes.ficheros;
import java.io.*;
public class Acceso_Ficheros {
    public static void main(String[] args) {
        File ruta = new File("C:/Users/marti/OneDrive/Escritorio/clusterClic");
        System.out.println(ruta.getAbsolutePath() );

        /* metodo list devuelve string en una rray
         de todos los archivos y lo recorremos for */
        String[] nombre_archivos = ruta.list();
    for(int i=0; i<nombre_archivos.length;i++){
        System.out.println( nombre_archivos[i]);

 File f = new File(ruta.getAbsolutePath(),nombre_archivos[i]);
  if(f.isDirectory()){
      String[]archivos_subcarpeta=f.list();
      for(int j=0; j<archivos_subcarpeta.length;j++){
          System.out.println( archivos_subcarpeta[j]);
      }}
  }
/* por compatibilidad de rutas todos sistemas
C:/Users/marti/OneDrive/Escritorio/clusterClic
*  new File("C"+File.separator +"marti"+File.separator+...
 */

    }
}
