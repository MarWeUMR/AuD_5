package com.company;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

        Queue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        heap.addAll(a);


        ArrayList<Integer> l = new ArrayList<>();

        while (k-- > 0) {
            l.add(heap.poll());
        }

        return l;


    }

    public static ArrayList<Integer> linearBE(ArrayList<Integer> a, int k) {
        // Theta (n)
        int j = a.size() - k;

        int x = medianOfMedians(a, j);

        return new ArrayList<>(a.stream()
                .filter(i -> i > x)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList()));
    }


    public static int medianOfMedians(List<Integer> a, int k) {

        int pivot;

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

        if (medians.size() <= 5) {
            pivot = medians.get(medians.size() / 2);
        } else {
            pivot = medianOfMedians(medians, (medians.size()-1)/2);
        }

        // partitionierung
        final int i = pivot;

        List<Integer> low = a.stream()
                .filter(number -> number < i)
                .collect(Collectors.toList());

        List<Integer> high = a.stream()
                .filter(number -> number > i)
                .collect(Collectors.toList());


        if (k <= low.size()) {
            return medianOfMedians((ArrayList) low, k);
        } else if (k > low.size() + 1) {
            return medianOfMedians((ArrayList) high, k - low.size() - 1);
        } else {
            return pivot;
        }

    }

    public static ArrayList<Integer> createSequenceInc(int n) {
        return new ArrayList<>(IntStream.range(1, n + 1).boxed().collect(Collectors.toList()));
    }

    public static ArrayList<Integer> createSequenceDec(int n) {
        return new ArrayList<>(IntStream.range(0, n).map(i -> n - i).boxed().collect(Collectors.toList()));
    }

}
