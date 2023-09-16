package com.campusdual.ejercicio6;

public class ListaAlimentos extends Food{

        private Integer gramos;

        public ListaAlimentos(String nombre, Integer calorias, Integer carbos, Integer proteinas, Integer grasas, Integer gramos) {
            super(nombre, calorias, carbos, proteinas, grasas);
            this.gramos = gramos;
        }

    public ListaAlimentos(Integer gramos) {
        this.gramos = gramos;
    }

    public Integer getGramos() {
            return gramos;
        }

        public void setGramos(Integer gramos) {
            this.gramos = gramos;
        }
    }


