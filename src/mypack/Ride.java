package mypack;


public class Ride {
    public int tStart, tFinish;
    public int xStart, yStart, xFinish, yFinish;
    public int distance;

    public Ride() {}


    public Ride(int tStart, int tFinish, int xStart, int yStart, int xFinish, int yFinish) {
        this.tStart = tStart;
        this.tFinish = tFinish;
        this.xStart = xStart;
        this.yStart = yStart;
        this.xFinish = xFinish;
        this.yFinish = yFinish;
        this.distance = computeDistance();
    }

    public int computeDistance() {
        return Math.abs(xStart - xFinish) + Math.abs(yStart - yFinish);
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


        if(getThere(car))
        int scor = distance - computeDistance(car.x, car.y, xStart, yStart);

        return 0;
    }

    private boolean getThere(Car car) {
    }
}
