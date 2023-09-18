package com.campusdual.ejercicio6_;

public enum DiasSemana {
 
        L(1,"Lunes"),
        M(2,"Martes"),
        X(3,"Míercoles"),
        J(4,"Jueves"),
        V(5,"Viernes"),
        S(6,"Sábado"),
        D(7,"Domingo");

        private Integer position;
        private String name;

        DiasSemana(Integer position, String name) {
            this.position = position;
            this.name = name;
        }

        public String getName(){
            return name;
        }

        public Integer getPosition(){
            return position;
        }

        public static DiasSemana getDayFromPosition(Integer position){
            for(DiasSemana day : values()){
                if(day.getPosition()==position){
                    return day;
                }
            }
            return null;
        }
    }

