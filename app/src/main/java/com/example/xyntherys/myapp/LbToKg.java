package com.example.xyntherys.myapp;

public class LbToKg extends Converter{

    public LbToKg(double lb){
        super(lb);
        this.fromUnit = "Pounds";
        this.toUnit = "Kilograms";
    }

    @Override
    public double calculate(){
        return this.numSource * 0.453592;
    }

}
