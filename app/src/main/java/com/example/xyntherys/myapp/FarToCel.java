package com.example.xyntherys.myapp;

public class FarToCel extends Converter {

    public FarToCel(double far) {
        super(far);
        this.fromUnit = "Farenheit";
        this.toUnit = "Celsius";
    }

    @Override
    public double calculate() {
        return ((this.numSource * 5.0) - 160.0) / 9.0;
    }
}
