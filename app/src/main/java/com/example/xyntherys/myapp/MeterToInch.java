package com.example.xyntherys.myapp;

public class MeterToInch {
    private double meter;
    private double inch;

    public MeterToInch(double meter){
        inch = meter * 39.372;
    }

    public double getResult(){
        return inch;
    }
}
