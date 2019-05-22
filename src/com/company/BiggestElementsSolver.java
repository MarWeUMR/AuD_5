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

        if (a.size() < 5) {
            // return median direkt
        }

        // Chunked Liste
        var chunks = splitList(a);


        return new ArrayList<>();
    }

    public static int splitList(ArrayList<Integer> l) {

        ArrayList<Integer> medians = new ArrayList<>();

        for (int i = 0; i < (l.size() / 5) * 5; i += 5) {

            Integer[] iRay = new Integer[5];

            iRay[i % 5] = l.get(i);
            iRay[i % 5 + 1] = l.get(i + 1);
            iRay[i % 5 + 2] = l.get(i + 2);
            iRay[i % 5 + 3] = l.get(i + 3);
            iRay[i % 5 + 4] = l.get(i + 4);

            Arrays.sort(iRay);
            medians.add(iRay[2]);
        }


        return medians.get(medians.size() / 2);
    }

    public static void quickSort(ArrayList<Integer> a, int low, int high) {

        if (low < high) {
            int pivot = partition(a, 0, a.size() - 1);
            quickSort(a, low, pivot - 1);
            quickSort(a, pivot + 1, high);
        }


    }

    public static int partition(ArrayList<Integer> a, int low, int high) {

        int x = a.get(high);
        int i = low - 1;

        for (int j = low; j < high - 1; j++) {
            if (a.get(j) <= x) {
                i = i + 1;
                Collections.swap(a, i, j);
            }
        }

        Collections.swap(a, i + 1, high);
        return i + 1;


    }

    public void selection(ArrayList<Integer> a, int k) {

        if (a.size() < 5) {
            // sort, return median
        }

    }

    public static void quickSort(int[] arr, int low, int high) {
        if (arr.length <= 0) return;
        if (low >= high) return;
        int left = low;
        int right = high;

        int temp = arr[left];    // dig 1: save the value of the reference
        while (left < right) {
            while (left < right && arr[right] >= temp) {   // Pit 2: find backwards and forwards An element smaller than the reference, inserted into the reference position pit 1 in the
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= temp) {    // Pit 3: Find the element larger than the baseline from the way of going, and put it in the pit 2 just dug
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = temp;    //The reference value is filled into pit 3, ready to divide and recursively fast
        System.out.println(" Sorting: " + Arrays.toString(arr));
        quickSort(arr, low, left - 1);
        quickSort(arr, left + 1, high);
    }
}
