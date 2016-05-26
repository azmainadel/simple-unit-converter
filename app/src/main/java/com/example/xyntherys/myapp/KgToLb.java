package com.example.xyntherys.myapp;

public class KgToLb {
    private double kg;
    private double lb;

    public KgToLb(double kg){
        lb = kg * 2.20462;
    }

    public double getResult(){
        return lb;
    }
}
