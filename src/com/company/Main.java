package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        ArrayList<Integer> ray = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 9, 5, 8, 7, 4, 12, 6, 13, 17, 14, 19, 100, 22, 33));


        BiggestElementsSolver.quickSort(ray, 0, ray.size() - 1);

        ray.forEach(System.out::println);

        //System.out.println(BiggestElementsSolver.mom(ray, 3));
        //var x = BiggestElementsSolver.medianOfMedians(ray);


        System.out.println(BiggestElementsSolver.bruteForceBE(ray, 4));


        // write your code here
    }
}
