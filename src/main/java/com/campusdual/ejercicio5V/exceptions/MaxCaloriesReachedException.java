package com.campusdual.ejercicio5V.exceptions;

public class MaxCaloriesReachedException extends MaxValuedReachedException {

    public MaxCaloriesReachedException() {
        super("Max calories reached for the actual diet");
    }
}
