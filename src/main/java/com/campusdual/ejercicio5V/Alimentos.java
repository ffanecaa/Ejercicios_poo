package com.campusdual.ejercicio5V;

public class Alimentos {
    private Integer carbos;
    private Integer fats;
    private Integer proteins;
    private String name;
    private Integer gramos;
   private int Id;
   private static int IdSiguiente =1;

    public Alimentos(Integer carbos, Integer fats, Integer proteins, String name, Integer gramos) {
        this.carbos = carbos;
        this.fats = fats;
        this.proteins = proteins;
        this.name = name;
        this.gramos = gramos;
        Id= IdSiguiente;
        IdSiguiente++;
    }

    public Integer getCalories(Integer weight){
        return(((carbos*4)+(fats*9)+(proteins*4))*weight/100);
    }

    public Integer getCarbos() {
        return carbos;
    }

    public void setCarbos(Integer carbos) {
        this.carbos = carbos;
    }

    public Integer getFats() {
        return fats;
    }

    public void setFats(Integer fats) {
        this.fats = fats;
    }

    public Integer getProteins() {
        return proteins;
    }

    public void setProteins(Integer proteins) {
        this.proteins = proteins;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGramos() {
        return gramos;
    }

    public void setGramos(Integer gramos) {
        this.gramos = gramos;
    }
}
