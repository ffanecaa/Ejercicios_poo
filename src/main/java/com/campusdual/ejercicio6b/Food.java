package com.campusdual.ejercicio6b;



public class Food {
    Integer calorias;
    Integer carbos;
    Integer proteinas;
    Integer grasas;
    String nombre;
    int Id;
    private static int IdSiguiente =1;

    public Food() {
    }

    public Food(String nombre,Integer calorias, Integer carbos, Integer proteinas, Integer grasas) {
        this.calorias = calorias;
        this.carbos = carbos;
        this.proteinas = proteinas;
        this.grasas = grasas;
        this.nombre = nombre;
        Id= IdSiguiente;
        IdSiguiente++;

    }

    public Integer getCalorias(Integer weight){

        return(((carbos*4)+(grasas*9)+(proteinas*4))*weight/100);
    }

    public void setCalorias(Integer calorias) {
        this.calorias = calorias;
    }

    public Integer getCarbos() {
        return carbos;
    }

    public void setCarbos(Integer carbos) {
        this.carbos = carbos;
    }

    public Integer getProteinas() {
        return proteinas;
    }

    public void setProteinas(Integer proteinas) {
        this.proteinas = proteinas;
    }

    public Integer getGrasas() {
        return grasas;
    }

    public void setGrasas(Integer grasas) {
        this.grasas = grasas;
    }

    public String dameDatosFood(){
        return Id +" "+ nombre +"  "+ calorias+" gramos "+ "calorias"+" "+ proteinas+" gramos  "+" "+ "proteinas: "+" "+grasas+" gramos "+ " grasas: "+" "+ "y "+carbos +" gramos "+" carbos"+" "+ "por cada 100 gramos:";
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


}

