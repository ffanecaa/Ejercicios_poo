package com.campusdual.apuntes.arraylist;
import java.util.*;
public class UsoEmpelado {

    public static void main(String[] args) {
// sustituiremo el array de abajo por un array list en el q no necesitamos
    //    indicar numero de elementos
   /*     Empleado listaEmpleado[] = new Empleado[3];
        listaEmpleado[0]= new Empleado("ana",45,2500);
        listaEmpleado[1]= new Empleado("antonio",55,2000);
        listaEmpleado[2]= new Empleado("Maria",25,2600);*/

        // ARRAY LIST 3 CONSTRUCTORES
        // EL 1 SIN PARAMETROS Y CREA UN ARRAYL DE 10 ELEMENTOS VACIO*/
// IMP JAVA UTIL
        //no permiten datos primitivos => nedd clase envoltorio
  // ArrayList <tipoDato> nombre lista = new ArrayList<tipoDato>
     ArrayList <Empleado> listaEmpleado = new ArrayList<Empleado>();
//   metodo añadir elementos .add()
// indicamos numero elementos por eficiencia
        listaEmpleado.ensureCapacity(16);
System.out.println("infooo////////////////////////////////////" );
        listaEmpleado.add(new Empleado("ana",45,2500));
        listaEmpleado.add(new Empleado("antonio",55,2000));
        listaEmpleado.add(new Empleado("Maria",25,2600));listaEmpleado.add(new Empleado("ana",45,2500));
        listaEmpleado.add(new Empleado("antonio",55,2000));
        listaEmpleado.add(new Empleado("Maria",25,2600));listaEmpleado.add(new Empleado("ana",45,2500));
        listaEmpleado.add(new Empleado("antonio",55,2000));
        listaEmpleado.add(new Empleado("Maria",25,2600));listaEmpleado.add(new Empleado("ana",45,2500));
        listaEmpleado.add(new Empleado("antonio",55,2000));
        listaEmpleado.add(new Empleado("Maria",25,2600));listaEmpleado.add(new Empleado("ana",45,2500));
        listaEmpleado.add(new Empleado("antonio",55,2000));
        listaEmpleado.add(new Empleado("Maria",25,2600));
        listaEmpleado.trimToSize();
        /* si sabemos que hemos acabado de meter datos
        * lo q podemos hacer es
        *  listaEmpleado.trimToSize();  mata excesos memoria */

/* SE incluyen ORDENADAMENTE por order de inclusion
si queremos altera o acceder a ellos usaremos
METODO GET Y SET
 */
   //     listaEmpleado.add(new Empleado("Marta",46,3600))
    // usaremos metodod SET que tiene 2 argumentos
  // posisico y objeto
    listaEmpleado.set(1,new Empleado("Marta",46,3600));

//acceder 5 elemenoto por ejemplo
        System.out.println(listaEmpleado.get(4));
        // asi solo nos daria posicion memoria
System.out.println( "info*******************************");
        System.out.println(listaEmpleado.get(4).dameDatos());


/* decia la toria que solo 10 pero no es asi
el motivo es que hay metodo interno :
    reserva en memoria 10
    si aumentamos hace una copia ampliada en memoria para elnuevo numero de
    elementos
    porlo q podemos indicarle cuantos elementos son
    listaElementos.ensureCapacity(16);
*
*  usaremos metood para contar elementos .size()
*  */
        System.out.println(listaEmpleado.size() );




        /* metodo reccore arraylist */

        for(int i= 0; i <listaEmpleado.size();i++){
            Empleado lista = listaEmpleado.get(i);
            System.out.println(lista.dameDatos() );
        }

        for(Empleado e: listaEmpleado){
            System.out.println(e.dameDatos() );
        }


        //tb podemos cambiar el arraylist a un array para recorrerlo
        Empleado arrayEmpleados[] = new Empleado[listaEmpleado.size()];
        listaEmpleado.toArray(arrayEmpleados);
        // convertido en array podemos recorrerlo
        for(int i=0; i<arrayEmpleados.length;i++){
            System.out.println( arrayEmpleados[i].dameDatos()+"holaa");
        }

       //ITERADOR   JAVA UTIL
       // iterador<tipo> monbreqqremos= arraylist.iterato()
        Iterator<Empleado>mi_iterador = listaEmpleado.iterator();
//metodo hashnext si hay mas usamos while

        while(mi_iterador.hasNext()){
            System.out.println(mi_iterador.next().dameDatos()+"iterator" );
        }


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