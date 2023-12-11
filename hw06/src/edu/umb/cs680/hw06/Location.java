package edu.umb.cs680.hw06;

public class Location {

    private int latitude, longitude;
    
    public Location(int latitude, int longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }
    
    public int getLatitude() {
        return latitude;
    }

    public int getLongitude() {
        return longitude;
    }

}
