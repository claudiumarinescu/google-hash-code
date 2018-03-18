package utils;

public class Util {

    public static int WIDTH;
    public static int HEIGHT;
    public static int CARS_NO;
    public static int RIDES_NO;
    public static int BONUS;
    public static int MAX_NO_STEPS;
    public static final String INPUT_FOLDER = "input\\";
    public static final String OUTPUT_FOLDER = "output\\";
    public static final String[] OUTPUT_FILES = {"a.out", "b.out", "c.out", "d.out", "e.out"};
    public static final String[] INPUT_FILES = {"a_example.in",
                                                "b_should_be_easy.in",
                                                "c_no_hurry.in",
                                                "d_metropolis.in",
                                                "e_high_bonus.in"};


    public static int computeDistance(int xStart, int yStart, int xFinish, int yFinish) {
        return Math.abs(xStart - xFinish) + Math.abs(yStart - yFinish);
    }

}
