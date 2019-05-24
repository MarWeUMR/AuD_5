package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {


        for (int len : new int[]{1000, 10000, 100000, 200000}
        ) {

            System.out.println("========================================");
            System.out.printf("Array Size: %d\n", len);

            for (int order = 0; order < 2; order++) {

                System.out.printf("Order: %s\n", (order == 1) ? "Increasing" : "Decreasing");

                System.out.println("--------------");

                ArrayList<Integer> a = (order == 1)
                        ? BiggestElementsSolver.createSequenceInc(len)
                        : BiggestElementsSolver.createSequenceDec(len);

                for (int method = 0; method < 3; method++) {

                    System.out.println((method == 0)
                            ? "Brute Force"
                            : (method == 1)
                            ? "Improved"
                            : "Linear");


                    long t_start_dec = System.nanoTime();
                    if (method == 0) {
                        //BiggestElementsSolver.bruteForceBE(a, len / 2);
                    } else if (method == 1) {
                        BiggestElementsSolver.improvedBE(a, len / 2);
                    } else {
                        BiggestElementsSolver.linearBE(a, len / 2);
                    }

                    long t_stop_dec = System.nanoTime();

                    long t = t_stop_dec - t_start_dec;

                    System.out.printf("Time: %d ns (%3.2e s)\n\n", t, (double) t / 1000000000);
                }

            }


        }

/*
        var x = BiggestElementsSolver.createSequenceDec(10);
        var y = BiggestElementsSolver.createSequenceInc(10);

        Arrays.stream(x).forEach(System.out::println);
        System.out.println();
        Arrays.stream(y).forEach(System.out::println);


        ArrayList<Integer> ray = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 9, 5, 8, 7, 4, 12, 6, 13, 17, 14, 19, 100, 22, 33));


        System.out.println(BiggestElementsSolver.improvedBE(ray, ray.size()));


        BiggestElementsSolver.quickSort(ray, 0, ray.size() - 1);*/


    }
}
