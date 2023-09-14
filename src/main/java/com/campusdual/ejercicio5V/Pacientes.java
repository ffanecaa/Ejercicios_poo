package com.campusdual.ejercicio5V;


import java.util.ArrayList;
import java.util.List;

    public class Pacientes {
        private String name;
        private String lastName;
        private Integer weight;
        private Integer height;
        private Integer age;
        private Genre genre;
        private List<DietasPersonalizadas> diets;

        public Pacientes(String name, String lastName, Integer weight, Integer height, Integer age, Genre genre) {
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

        public List<DietasPersonalizadas> getDiets() {
            return diets;
        }

        public void addDiet(DietasPersonalizadas diet) {
            diets.add(diet);
        }

        public void removeDiet(DietasPersonalizadas diet) {
            diets.remove(diet);
        }

        public String getPacientesInfo() {
            return "Nombre: " + name + " " + lastName + ", Peso: " + weight + " kg, Altura: " + height + " cm, Edad: " + age + ", Sexo: " + genre;
        }
    }

