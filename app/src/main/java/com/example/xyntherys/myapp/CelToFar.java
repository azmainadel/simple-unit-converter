package com.example.xyntherys.myapp;

public class CelToFar {
    private double far;
    private double cel;

    public CelToFar(double cel){
        far = ( ( cel * 9.0 ) / 5.0 ) + 32.0;
    }

    public double getResult(){
        return far;
    }
}
