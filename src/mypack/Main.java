package mypack;


import utils.MyScanner;
import utils.Util;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {

    public static String inputFile = "input.in";

    static List<Ride> rides;
    static List<Car> cars;


    public static void main(String[] args) {


        read();

        for (Car car :cars) {
            while(car.hasTime(rides)) {
                Ride ride = null;
                Ride bestRide = null;
                double bestScore = -Double.MAX_VALUE;
                for (Iterator<Ride> it = rides.iterator(); it.hasNext(); ride = it.next()) {

                    if(getThere(car)) {
                        double score = ride.calculateValue(car);

                        if (score > bestScore) {
                            bestScore = score;
                            bestRide = ride;
                        }
                    }
                }

                car.addRide(bestRide);

            }
        }



    }

    public static void read() {
        MyScanner scanner = new MyScanner(new File(inputFile));

        Util.WIDTH = scanner.nextInt();
        Util.HEIGHT = scanner.nextInt();
        Util.CARS_NO = scanner.nextInt();
        Util.RIDES_NO = scanner.nextInt();
        Util.BONUS = scanner.nextInt();
        Util.MAX_NO_STEPS = scanner.nextInt();

        rides = new ArrayList(Util.RIDES_NO);

        for (int i = 0; i < Util.RIDES_NO; i++) {
            int startX = scanner.nextInt();
            int startY = scanner.nextInt();
            int finishX = scanner.nextInt();
            int finishY = scanner.nextInt();
            int earliestStart = scanner.nextInt();
            int latestFinish = scanner.nextInt();

            if(latestFinish - earliestStart + 1 < )
            rides.add(new Ride(earliestStart, latestFinish, startX, startY, finishX, finishY));
        }

        List<Car> cars = new ArrayList(Util.CARS_NO);
        for (int i = 0; i < Util.CARS_NO; i++) {
            cars.add(new Car(0,0));
        }

    }


}
