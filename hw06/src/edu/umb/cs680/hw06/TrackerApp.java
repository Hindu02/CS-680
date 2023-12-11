package edu.umb.cs680.hw06;

public class TrackerApp implements LocationObserver, StepCountObserver {

    private int latitude, longitude, step;

    public void updateStepCount(StepCount event) {
        System.out.println("StepCount updated: " + event.step);
        this.step = event.step;
    }
    
    public void updateLocation(Location event) {
        System.out.println("Location updated: " + event.getLatitude() +  ", " + event.getLongitude());
        this.latitude = event.getLatitude();
        this.longitude = event.getLongitude();
    }

    public int getLatitude() {
        return latitude;
    }

    public int getLongitude() {
        return longitude;
    }

    public int getStep() {
        return step;
    }
       
}
