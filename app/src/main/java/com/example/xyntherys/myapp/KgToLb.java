package com.example.xyntherys.myapp;

public class KgToLb extends Converter{

    public KgToLb(double kg){
        super(kg);
        this.fromUnit = "Kilograms";
        this.toUnit = "Pounds";
    }

    @Override
    public double calculate(){
        return this.numSource * 2.20462;
    }

}
