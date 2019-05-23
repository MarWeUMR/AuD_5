package com.company;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class BiggestElementsSolver {

    public static ArrayList<Integer> bruteForceBE(ArrayList<Integer> a, int k) {
        // Theta (n*k)

        Integer[] iRay = new Integer[k];

        for (int i = 0; i < k; i++) {
            int lastMax = (i == 0) ? Integer.MAX_VALUE : iRay[i - 1];
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

        return new ArrayList<>();
    }

    public static void quickSort(ArrayList<Integer> a, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(a, low, high);
            quickSort(a, low, pivotIndex - 1);  //sort left of pivot
            quickSort(a, pivotIndex, high);  //sort right of pivot
        }
    }


    private static int partition(ArrayList<Integer> a, int low, int high) {
        int pivot = mom(a.subList(low, high), (high - low + 1) / 2);
        int i = low - 1;
        for (int j = low; j < high; ++j) {
            if (a.get(j) <= pivot) {
                Collections.swap(a, ++i, j);
            }
        }
        Collections.swap(a, ++i, high);
        return i;
    }

    public static int mom(List<Integer> a, int k) {

        if (a.size() <= 5) {
            return a.get(a.size() / 2);
        }

        int chunkSize = 5;
        AtomicInteger counter = new AtomicInteger();

        Collection<List<Integer>> chunks = a.stream()
                .sorted()
                .collect(Collectors.groupingBy(it -> counter.getAndIncrement() / chunkSize))
                .values();


        ArrayList<Integer> medians = new ArrayList<>();

        for (List<Integer> sublist : chunks) {

            medians.add(sublist.get(sublist.size() / 2));

        }

        return mom(medians, a.size()/10);


    }
}
