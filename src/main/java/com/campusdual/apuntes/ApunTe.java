package com.campusdual.apuntes;

public class ApunTe {
    private  char ch;

    public ApunTe(char ch) {
        this.ch = ch;
    }

    public boolean isVowel(){
       if( ch =='a'|| ch =='e'||ch =='i'|| ch =='o'|| ch =='u')
           return true;

        return false;
    }
}
