package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        ArrayList<Integer> ray = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 9, 5, 8, 7, 4, 12, 6, 13, 17, 14, 19, 100, 22, 33));

        BiggestElementsSolver.linearBE(ray, 2);
        var x = BiggestElementsSolver.splitList(ray);


        System.out.println(BiggestElementsSolver.bruteForceBE(ray, 4));


        // write your code here
    }
}
