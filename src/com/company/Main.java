package com.company;

import java.util.Scanner;

public class Main {
    //method which calculates the compass bearing between two points.
    //https://www.igismap.com/formula-to-find-bearing-or-heading-angle-between-two-points-latitude-longitude/
    public static double bearingCalculator(double latn1, double longn1, double latn2, double longn2) {

        //degrees on a compass
        double degrees = 360;

        //Take in four inputs being lat, long x 2
        double latd1 = latn1;
        double longd1 = longn1;
        double latd2 = latn2;
        double longd2 = longn2;

        //Calculate absolute difference between longtitude and lattitude
        double longdiffd = longd1 - longd2;

        //Convert from degrees to radians as formula takes in radians
        double longdiffr = Math.toRadians(longdiffd);
        double latr1 = Math.toRadians(latd1);
        double latr2 = Math.toRadians(latd2);

        //
        double part1 = Math.cos(latr2) * Math.sin(longdiffr);
        System.out.println("Part1 " + part1);
        double part2 = Math.cos(latr1) * Math.sin(latr2) - Math.sin(latr1) * Math.cos(latr2) * Math.cos(longdiffr);
        System.out.println("Part2 " + part2);
        double angler = Math.atan2(part1, part2);

        double angle = Math.toDegrees(angler);

        if(angle<0){
            angle = angle * -1;
        }
        else{
            angle = degrees - angle;
        }
        return angle;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double latn1 = sc.nextDouble();
        double longn1 = sc.nextDouble();
        double latn2 = sc.nextDouble();
        double longn2 = sc.nextDouble();

        double angle = bearingCalculator(latn1, longn1, latn2, longn2);

        System.out.println(angle);
    }
}
