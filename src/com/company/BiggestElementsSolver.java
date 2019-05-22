package com.company;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class BiggestElementsSolver {

    public static ArrayList<Integer> bruteForceBE(ArrayList<Integer> a, int k) {
        // Theta (n*k)

        Integer[] iRay = new Integer[k];

        for (int i = 0; i < k; i++) {
            int lastMax = (i == 0) ? Integer.MAX_VALUE : iRay[i-1];
            int currentMax = 0;
            for (int j = 0; j < a.size(); j++) {
                if (a.get(j) > currentMax & a.get(j) < lastMax) {
                    currentMax = a.get(j);
                }
            }
            iRay[i] = currentMax;
        }

        return new ArrayList<Integer>(Arrays.asList(iRay));
    }

    public static ArrayList<Integer> improvedBE(ArrayList<Integer> a, int k) {
        // Theta (n log n)
        // heap sort

        return new ArrayList<>();
    }

    public static ArrayList<Integer> linearBE(ArrayList<Integer> a, int k) {
       // Theta (n)

        if (a.size() < 5) {
            // return median direkt
        }

        // Chunked Liste
        var chunks = splitList(a);





       return new ArrayList<>() ;
    }

    public static ArrayList<Integer> splitList(ArrayList<Integer> l) {

        AtomicInteger counter = new AtomicInteger(0);
        int size = 5;

        final Collection<List<Integer>> partitioned = l
                .stream()
                // #####################################################################
                // Hier steckt die lineare Laufzeit der Sortierung von T(n/q) drin
                .sorted()
                .collect(Collectors.groupingBy(it -> counter.getAndIncrement() / size))
                // #####################################################################
                .values();

        ArrayList<Integer> x = new ArrayList(partitioned);

        return x;

    }




}
