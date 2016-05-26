package com.example.xyntherys.myapp;

public class FarToCel {
    private double far;
    private double cel;

    public FarToCel(double far){
        cel = ( ( far * 5.0 ) - 160.0 ) / 9.0;
    }

    public double getResult(){
        return cel;
    }
}
