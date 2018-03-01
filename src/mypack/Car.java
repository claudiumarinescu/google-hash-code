package mypack;
import utils.Util;

import java.util.ArrayList;
import java.util.List;


public class Car {
    public int x, y;
    public int time;
    public List<Ride> rides;
    int id;

    public Car() {}

    public Car(int id, int x, int y) {
        this.id = id;
        this.x = x;
        this.y = y;
        time = 0;
        rides = new ArrayList<>();
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public List<Ride> getRides() {
        return rides;
    }

    public void setRides(List<Ride> rides) {
        this.rides = rides;
    }

    public boolean hasTime(List<Ride> rides){
        return time < Util.MAX_NO_STEPS &&
               rides.stream().anyMatch(ride -> time + ride.distance < Util.MAX_NO_STEPS); //TODO check if exclusive or inclusive
    }

    public void addRide(Ride ride) {
        time = Math.abs(x - ride.xFinish) + Math.abs(y - ride.yFinish);
        x = ride.xFinish;
        y = ride.yFinish;
        rides.add(ride);
    }

    @Override
    public String toString() {
        return "Car{" +
                "x=" + x +
                ", y=" + y +
                ", time=" + time +
                ", rides=" + rides +
                ", id=" + id +
                '}';
    }
}
