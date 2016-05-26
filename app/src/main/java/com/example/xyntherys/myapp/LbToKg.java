package com.example.xyntherys.myapp;

public class LbToKg {
    private double kg;
    private double lb;

    public LbToKg(double lb){
        kg = lb * 0.453592;
    }

    public double getResult(){
        return kg;
    }
}
