package mypack;


import utils.Util;

public class Ride {
    public int tStart, tFinish;
    public int xStart, yStart, xFinish, yFinish;
    public int distance;
    public int id;

    public Ride() {}


    public Ride(int id, int tStart, int tFinish, int xStart, int yStart, int xFinish, int yFinish) {
        this.id = id;
        this.tStart = tStart;
        this.tFinish = tFinish;
        this.xStart = xStart;
        this.yStart = yStart;
        this.xFinish = xFinish;
        this.yFinish = yFinish;
        this.distance = computeDistance();
    }

    public int computeDistance() {
        return Util.computeDistance(xStart, xFinish, yStart, yFinish);
    }

    public int computeDistance(int xa, int ya, int xb, int yb) {
        return Math.abs(xa - xb) + Math.abs(ya - yb);
    }


    public int gettStart() {
        return tStart;
    }

    public void settStart(int tStart) {
        this.tStart = tStart;
    }

    public int gettFinish() {
        return tFinish;
    }

    public void settFinish(int tFinish) {
        this.tFinish = tFinish;
    }

    public int getxStart() {
        return xStart;
    }

    public void setxStart(int xStart) {
        this.xStart = xStart;
    }

    public int getyStart() {
        return yStart;
    }

    public void setyStart(int yStart) {
        this.yStart = yStart;
    }

    public int getxFinish() {
        return xFinish;
    }

    public void setxFinish(int xFinish) {
        this.xFinish = xFinish;
    }

    public int getyFinish() {
        return yFinish;
    }

    public void setyFinish(int yFinish) {
        this.yFinish = yFinish;
    }

    public double calculateValue(Car car) {

        double scor = -Double.MAX_VALUE;
        if(getThere(car)) {

            scor = distance - computeDistance(car.x, car.y, xStart, yStart);

            if(car.time + computeDistance(car.x, car.y, xStart, yStart) <= tStart) {
                scor -= (tStart - car.time - computeDistance(car.x, car.y, xStart, yStart));
                scor += Util.BONUS;
            }
        }

        return scor;
    }

    public boolean getThere(Car car) {
        int distanceToStart = Math.abs(car.x - xStart) + Math.abs(car.y - yStart);
        return (car.time + distanceToStart + this.distance) < Util.MAX_NO_STEPS;
    }

    @Override
    public String toString() {
        return "Ride{" +
                "tStart=" + tStart +
                ", tFinish=" + tFinish +
                ", xStart=" + xStart +
                ", yStart=" + yStart +
                ", xFinish=" + xFinish +
                ", yFinish=" + yFinish +
                ", distance=" + distance +
                ", id=" + id +
                '}';
    }
}
