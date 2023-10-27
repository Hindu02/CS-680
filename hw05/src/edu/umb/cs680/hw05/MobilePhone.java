package edu.umb.cs680.hw05;

public class MobilePhone implements Observer<Float> {

    public void update(Observable<Float> sender, Float value) {
        email(value);
    }

    public void email(Float value) {
        if (value < 18) {
            System.out.println("Warining: Room temperature is lower than 18 Celsius");
        } else if (value > 28) {
            System.out.println("Warining: Room temperature is greate than 88 Celsius");
        }
    }

}
