package com.example.xyntherys.myapp;

public class InchToMeter {
    private double meter;
    private double inch;

    public InchToMeter(double inch){
        meter = inch * 0.0254;
    }

    public double getResult(){
        return meter;
    }
}
