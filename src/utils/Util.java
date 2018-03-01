package utils;

public class Util {

    public static int WIDTH;
    public static int HEIGHT;
    public static int CARS_NO;
    public static int RIDES_NO;
    public static int BONUS;
    public static int MAX_NO_STEPS;


    public static int computeDistance(int xStart, int xFinish, int yStart, int yFinish) {
        return Math.abs(xStart - xFinish) + Math.abs(yStart - yFinish);
    }

}
