

package com.campusdual.ejercicio5;

        import java.util.ArrayList;
        import java.util.List;

public class Patient {
    private String name;
    private String lastName;
    private Integer weight;
    private Integer height;
    private Integer age;
    private String sex;
    private List<Diet> diets;

    public Patient(String name, String lastName, Integer weight, Integer height, Integer age, String sex) {
        this.name = name;
        this.lastName = lastName;
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.sex = sex;
        this.diets = new ArrayList<>();
    }

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

    public String getSex() {
        return sex;
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
        return "Nombre: " + name + " " + lastName + ", Peso: " + weight + " kg, Altura: " + height + " cm, Edad: " + age + ", Sexo: " + sex;
    }
}