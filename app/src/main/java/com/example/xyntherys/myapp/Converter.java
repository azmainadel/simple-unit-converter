package com.example.xyntherys.myapp;

public abstract class Converter {

    protected String fromUnit;
    protected String toUnit;

    protected double numSource;

    public Converter(double number) {
        this.numSource = number;
    }

    public abstract double calculate();

    public String toFormattedString() {
        double result = this.calculate();

        return String.valueOf(this.numSource) + " "
                + this.fromUnit + " = " + String.valueOf(result)
                + " " + this.toUnit;
    }
}
