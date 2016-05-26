package com.example.xyntherys.myapp;

public class MeterToInch extends Converter {

    public MeterToInch(double meter){
        super(meter);
        this.fromUnit = "Meters";
        this.toUnit = "Inches";
    }

    @Override
    public double calculate() {
        return this.numSource * 39.372;
    }

}
