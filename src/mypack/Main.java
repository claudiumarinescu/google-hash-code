package mypack;


import utils.MyScanner;
import utils.Util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {

    private static List<Ride> rides;
    private static List<Car> cars;


    public static void main(String[] args) {

        int outIdx = 0;
        for (String file : Util.INPUT_FILES) {
            System.out.println("Computing " + file);

            read(Util.INPUT_FOLDER + file);
            computeRides();
            afisare(Util.OUTPUT_FOLDER + Util.OUTPUT_FILES[outIdx++]);
        }

        System.out.println("Results are ready!");
    }

    private static void computeRides() {
        Car emptyCar = new Car(-1, 0, 0);

        PriorityQueue<Ride> queue = new PriorityQueue<>(
                (r1, r2) -> r2.calculateValue(emptyCar).compareTo(r1.calculateValue(emptyCar)) );
        queue.addAll(rides);


        for (Car car : cars) {
            if (!queue.isEmpty()) {
                Ride bestRide = queue.poll();
                car.addRide(bestRide);
                rides.remove(bestRide);
            }
        }

        for (Car car : cars) {
            List<Ride> myRides = new ArrayList<>(rides);


            while (car.hasTime(myRides)) {
                Ride ride;
                Ride bestRide = null;
                long bestScore = Long.MIN_VALUE;
                for (Iterator<Ride> it = myRides.iterator(); it.hasNext(); ) {
                    ride = it.next();

                    if (ride.getThere(car)) {
                        long score = ride.calculateValue(car);
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
        }
    }

    private static void read(String filename) {
        MyScanner scanner = new MyScanner(new File(filename));

        Util.WIDTH = scanner.nextInt();
        Util.HEIGHT = scanner.nextInt();
        Util.CARS_NO = scanner.nextInt();
        Util.RIDES_NO = scanner.nextInt();
        Util.BONUS = scanner.nextInt();
        Util.MAX_NO_STEPS = scanner.nextInt();

        rides = new ArrayList<>(Util.RIDES_NO);

        for (int i = 0; i < Util.RIDES_NO; i++) {
            int startX = scanner.nextInt();
            int startY = scanner.nextInt();
            int finishX = scanner.nextInt();
            int finishY = scanner.nextInt();
            int earliestStart = scanner.nextInt();
            int latestFinish = scanner.nextInt();

            // if there is time to cover the distance
            if (latestFinish - earliestStart >= Util.computeDistance(startX, startY, finishX, finishY)) {
                rides.add(new Ride(i, earliestStart, latestFinish, startX, startY, finishX, finishY));
            }
        }

        cars = new ArrayList<>(Util.CARS_NO);
        for (int i = 0; i < Util.CARS_NO; i++) {
            cars.add(new Car(i + 1, 0, 0));
        }
    }

    private static void afisare(String outFile) {

        BufferedWriter bw = null;
        FileWriter fw = null;

        try {

            fw = new FileWriter(new File(outFile));
            bw = new BufferedWriter(fw);

            StringBuilder content = new StringBuilder();

            for (Car car : cars) {

                content.append(car.getRides().size()).append(" ");

                for (Ride ride : car.getRides()) {
                    content.append(ride.getId()).append(" ");
                }
                content.append("\n");
            }

            bw.write(content.toString());


        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if (bw != null)
                    bw.close();

                if (fw != null)
                    fw.close();

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
