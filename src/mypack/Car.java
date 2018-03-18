package mypack;
import utils.Util;

import java.util.ArrayList;
import java.util.List;


public class Car {
    private int x, y;
    private int time;
    private List<Ride> rides;
    private int id;

    public Car(int id, int x, int y) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.time = 0;
        this.rides = new ArrayList<>();
    }

    public boolean hasTime(List<Ride> rides){
        return (this.time < Util.MAX_NO_STEPS)
                && rides.stream().anyMatch(ride -> time + ride.getDistance() < Util.MAX_NO_STEPS);
    }

    public void addRide(Ride ride) {
        int distanceToStart = Math.abs(x - ride.getxStart()) + Math.abs(y - ride.getyStart());
        int timeWhenAtStart = time + distanceToStart;
        int waitTime = timeWhenAtStart < ride.gettStart() ? ride.gettStart() - timeWhenAtStart : 0;

        /* update car fields */
        time += distanceToStart + waitTime + ride.getDistance();
        x = ride.getxFinish();
        y = ride.getyFinish();
        rides.add(ride);
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

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Ride> getRides() {
        return rides;
    }

    public void setRides(List<Ride> rides) {
        this.rides = rides;
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
