

package com.campusdual.ejercicio5;

        import java.util.*;

public class Patient {
    private String name;
    private String lastName;
    private Integer weight;
    private Integer height;
    private Integer age;
    private Genre genre;
    private List<Diet> diets;

    public Patient(String name, String lastName, Integer weight, Integer height, Integer age, Genre genre) {
        this.name = name;
        this.lastName = lastName;
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.genre =genre;
        this.diets = new ArrayList<>();
    }
// jj tiene hasmap
    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getWeight() {
        return weight;
    }

    public Integer getHeight() {
        return height;
    }

    public Integer getAge() {
        return age;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public List<Diet> getDiets() {
        return diets;
    }

    public void addDiet(Diet diet) {
        diets.add(diet);
    }

    public void removeDiet(Diet diet) {
        diets.remove(diet);
    }

    public String getPatientInfo() {
        return "Nombre: " + name + " " + lastName + ", Peso: " + weight + " kg, Altura: " + height + " cm, Edad: " + age + ", Sexo: " + genre;
    }
}