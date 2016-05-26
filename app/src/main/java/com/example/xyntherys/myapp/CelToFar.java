package com.example.xyntherys.myapp;

public class CelToFar extends Converter {

    public CelToFar(double cel) {
        super(cel);
        this.fromUnit = "Celsius";
        this.toUnit = "Farenheit";
    }

    @Override
    public double calculate() {
        return (this.numSource * 9.0 / 5.0) + 32.0;
    }
}
