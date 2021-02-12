package com.example.saifkhan.distancetimeandfairofaroot;

public class point {
    String Name;
    Double latitude;
    Double longitude;

    point(String Name, Double latitude, Double longitude){
        this.Name = Name;
        this.latitude = latitude;
        this.longitude = longitude;
    }
    String getName() {
        return this.Name;
    }
    Double getlatitude() {
        return this.latitude;
    }
    Double getlongitude() {
        return this.longitude;
    }
    void setName(String Name) {
        this.Name = Name;
    }
    void setlatitude(Double latitude) {
        this.latitude = latitude;
    }

    void setlongitude(Double longitude) {
        this.longitude = longitude;
    }

}
