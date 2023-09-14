package com.campusdual.ejercicio5;

public enum Genre { FEMALE, MALE;

    public static Genre getByString(String genreName){

      if("m".equals(genreName.trim().toLowerCase()))
      return FEMALE;
        else if("h".equals(genreName.trim().toLowerCase())){
      return MALE;

        } return null;
    }
}
