package com.example.xyntherys.myapp;

public class calculation {
    private double inch;
    private double meter;

    public calculation(double meter){
        inch = meter * 39.37;
    }

    public double getResult(){
        return inch;
    }
}
