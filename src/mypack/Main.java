package mypack;


import utils.MyScanner;
import utils.Util;

import java.io.File;
import java.util.*;

public class Main {

    public static String inputFile = "input.in";

    static List<Ride> rides;
    static List<Car> cars;


    public static void main(String[] args) {


        read();
        Car emptyCar = new Car(-1, 0, 0);

        PriorityQueue<Ride> queue = new PriorityQueue<>(new Comparator<Ride>() {
            @Override
            public int compare(Ride r1, Ride r2) {
                if (r1.calculateValue(emptyCar) < r2.calculateValue(emptyCar)) {
                    return 1;
                }
                return -1;
            }
        });

        queue.addAll(rides);


        for (Car car :cars) {
            if(queue.isEmpty())
                break;
            Ride bestRide = queue.poll();
            car.addRide(bestRide);
            rides.remove(bestRide);
        }



        for (Car car :cars) {
            List<Ride> myRides = new ArrayList<>(rides);


            while(car.hasTime(myRides)) {
                Ride ride = null;
                Ride bestRide = null;
                double bestScore = -Double.MAX_VALUE;
                for (Iterator<Ride> it = myRides.iterator(); it.hasNext(); ) {
                    ride = it.next();

                    if(ride.getThere(car)) {
                        double score = ride.calculateValue(car);
                        if (score > bestScore) {
                            bestScore = score;
                            bestRide = ride;
                        }
                    } else {
                        it.remove();
                    }
                }
                if (bestRide != null) {
                    car.addRide(bestRide);
                    myRides.remove(bestRide);
                    rides.remove(bestRide);
                } else {
                    break;
                }

            }
            System.out.println("Time " + car.time);
        }

        afisare();



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

            if(latestFinish - earliestStart + 1 < Util.computeDistance(startX, startY, finishX, finishY));
                rides.add(new Ride(i, earliestStart, latestFinish, startX, startY, finishX, finishY));
        }

        cars = new ArrayList(Util.CARS_NO);
        for (int i = 0; i < Util.CARS_NO; i++) {
            cars.add(new Car(i, 0,0));
        }
    }

    public static void afisare() {
        for (Car car : cars) {
            System.out.print(car.id + " " );

            for (Ride ride: car.rides) {
                System.out.print(ride.id + " ");
            }
            System.out.println();
        }

    }


}
