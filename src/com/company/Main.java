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
                        BiggestElementsSolver.bruteForceBE(a, len / 2);
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
    }
}
/*
========================================
        Array Size: 1000
        Order: Decreasing
        --------------
        Brute Force
        Time: 19951667 ns (2.00e-02 s)

        Improved
        Time: 3216387 ns (3.22e-03 s)

        Linear
        Time: 3140568 ns (3.14e-03 s)

        Order: Increasing
        --------------
        Brute Force
        Time: 8540581 ns (8.54e-03 s)

        Improved
        Time: 361044 ns (3.61e-04 s)

        Linear
        Time: 1450980 ns (1.45e-03 s)

        ========================================
        Array Size: 10000
        Order: Decreasing
        --------------
        Brute Force
        Time: 153160776 ns (1.53e-01 s)

        Improved
        Time: 3311704 ns (3.31e-03 s)

        Linear
        Time: 6088116 ns (6.09e-03 s)

        Order: Increasing
        --------------
        Brute Force
        Time: 64593773 ns (6.46e-02 s)

        Improved
        Time: 2459669 ns (2.46e-03 s)

        Linear
        Time: 7616144 ns (7.62e-03 s)

        ========================================
        Array Size: 100000
        Order: Decreasing
        --------------
        Brute Force
        Time: 13257835016 ns (1.33e+01 s)

        Improved
        Time: 22398273 ns (2.24e-02 s)

        Linear
        Time: 41544517 ns (4.15e-02 s)

        Order: Increasing
        --------------
        Brute Force
        Time: 11034940946 ns (1.10e+01 s)

        Improved
        Time: 13717907 ns (1.37e-02 s)

        Linear
        Time: 12882311 ns (1.29e-02 s)

        ========================================
        Array Size: 200000
        Order: Decreasing
        --------------
        Brute Force
        Time: 51594391980 ns (5.16e+01 s)

        Improved
        Time: 21051318 ns (2.11e-02 s)

        Linear
        Time: 15409484 ns (1.54e-02 s)

        Order: Increasing
        --------------
        Brute Force
        Time: 44752371856 ns (4.48e+01 s)

        Improved
        Time: 36224711 ns (3.62e-02 s)

        Linear
        Time: 15981170 ns (1.60e-02 s)

*/
