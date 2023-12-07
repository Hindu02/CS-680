package edu.umb.cs680.hw06;

public class TrackerApp implements LocationObserver, StepCountObserver {

    int latitude, longitude, step;

    public void updateStepCount(StepCount event) {
        System.out.println("StepCount updated: " + event.step);
        this.step = event.step;
    }
    
    public void updateLocation(Location event) {
        System.out.println("Location updated: " + event.latitude +  ", " + event.longitude);
        this.latitude = event.latitude;
        this.longitude = event.longitude;
    }
       
}
