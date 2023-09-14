package com.campusdual.ejercicio5V.exceptions;

public class MaxProteinsReachedException extends MaxValuedReachedException {

    public MaxProteinsReachedException() {
        super("Max proteins reached for the actual diet");
    }
}
