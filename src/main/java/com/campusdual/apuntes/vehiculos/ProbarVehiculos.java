package com.campusdual.apuntes.vehiculos;
import javax.swing.*;
public class ProbarVehiculos {

    public static void main(String[] args) {
        Coche panda = new Coche(4,120,5,"Panda","Gasolina",5,"rojo");
        panda.getDetails();
        Deportivo porche = new Deportivo(500,100,"porche","Gasolina","rojo",1000);
        porche.getDetails();

        panda.setMarcas(JOptionPane.showInputDialog("pon color"));
        System.out.println( panda.getMarcas());
    }

}
