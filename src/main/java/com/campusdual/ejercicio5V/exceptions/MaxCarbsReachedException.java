package com.campusdual.ejercicio5V.exceptions;

public class MaxCarbsReachedException extends MaxValuedReachedException {

    public MaxCarbsReachedException() {
        super("Max carbs reached for the actual diet");
    }
}
