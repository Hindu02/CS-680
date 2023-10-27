package edu.umb.cs680.hw04;

public interface State {
    
    public abstract void ignitionPressed();

    public abstract void brakePressed();

    public abstract void acceleratePressed();

}
