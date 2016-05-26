package com.example.xyntherys.myapp;

public class InchToMeter extends Converter {

    public InchToMeter(double inch) {
        super(inch);
        this.fromUnit = "Inches";
        this.toUnit = "Meters";
    }

    @Override
    public double calculate() {
        return this.numSource * 0.0254;
    }

}
