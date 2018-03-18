package mypack;


import utils.Util;

public class Ride {
    private int tStart, tFinish;
    private int xStart, yStart, xFinish, yFinish;
    private int distance;
    private int id;

    public Ride(int id, int tStart, int tFinish, int xStart, int yStart, int xFinish, int yFinish) {
        this.id = id;
        this.tStart = tStart;
        this.tFinish = tFinish;
        this.xStart = xStart;
        this.yStart = yStart;
        this.xFinish = xFinish;
        this.yFinish = yFinish;
        this.distance = Util.computeDistance(xStart, yStart, xFinish, yFinish);
    }

    // heuristic for choosing best ride
    Long calculateValue(Car car) {

        Long scor = Long.MIN_VALUE;
        if(getThere(car)) {

            int distanceToStart = Util.computeDistance(car.getX(), car.getY(), this.xStart, this.yStart);
            scor = (long) this.distance / 10 - 2 * distanceToStart;

            if(car.getTime() + distanceToStart <= this.tStart) {
                scor -= (this.tStart - car.getTime() - distanceToStart) / 2;
                scor += Util.BONUS * 10;
            }
        }

        return scor;
    }

    boolean getThere(Car car) {
        int distanceToStart = Util.computeDistance(car.getX(), car.getY(), this.xStart, this.yStart);
        return ((car.getTime() + distanceToStart + this.distance) < Util.MAX_NO_STEPS)
                && ((car.getTime() + distanceToStart + this.distance) < this.tFinish);
    }


    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
