package mypack;


import utils.MyScanner;
import utils.Util;

import java.io.File;

public class Main {

    public static String inputFile = "input.txt";


    public static void main(String[] args) {


        read();

    }

    public static void read() {
        MyScanner scanner = new MyScanner(new File(inputFile));

        Util.WIDTH = scanner.nextInt();
        Util.HEIGHT = scanner.nextInt();
        Util.CARS_NO = scanner.nextInt();
        Util.RIDES_NO = scanner.nextInt();
        Util.BONUS = scanner.nextInt();
        Util.MAX_NO_STEPS = scanner.nextInt();

    }


}
