package com.company;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BiggestElementsSolver {

    public static ArrayList<Integer> bruteForceBE(ArrayList<Integer> a, int k) {

        Integer[] iRay = new Integer[k];

        for (int i = 0; i < k; i++) { // Äußere Schleife limitiert die Slots

            int lastMax = (i == 0) ? Integer.MAX_VALUE : iRay[i - 1];
            int currentMax = 0;

            for (int j = 0; j < a.size(); j++) { // innere Schleife geht die Liste von anfang bis ende durch

                if (a.get(j) > currentMax & a.get(j) < lastMax) {
                    currentMax = a.get(j);
                }
            }

            iRay[i] = currentMax;
        }

        return new ArrayList<Integer>(Arrays.asList(iRay));
    }

    public static ArrayList<Integer> improvedBE(ArrayList<Integer> a, int k) {

        // Heap Struktur erzeugen
        Queue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        heap.addAll(a);


        ArrayList<Integer> l = new ArrayList<>(); // Liste für größte Elemente

        while (k-- > 0) { // Größte Elemente extrahieren
            l.add(heap.poll());
        }

        return l;
    }

    public static ArrayList<Integer> linearBE(ArrayList<Integer> a, int k) {

        int j = a.size() - k; // Rang konvertieren
        int x = medianOfMedians(a, j); // O(n) Median von rang j finden

        ArrayList<Integer> l = new ArrayList<>(); // liste für größte elemente

        for (int i = 0; i < a.size(); i++) { // Elemente filtern (einmal durch die liste)
            if (a.get(i) > x) {
                l.add(a.get(i));
            }
        }

        ArrayList<Integer> result = new ArrayList<>(l.subList(l.size() - k, l.size())); // subliste erzeugen mit größten elementen

        Collections.sort(result, Collections.reverseOrder());

        return result;
    }


    private static int medianOfMedians(List<Integer> a, int k) {

        int pivot;

        ArrayList<ArrayList<Integer>> chunks = listChunker(a); // Liste in liste mit length = 5 sublists splitten
        ArrayList<Integer> medians = new ArrayList<>(); // liste der mediane der sublisten

        for (List<Integer> sublist : chunks) {
            medians.add(sublist.get(sublist.size() / 2)); // submediane finden
        }

        if (medians.size() <= 5) { // pivot festlegen oder...
            pivot = medians.get(medians.size() / 2);
        } else { // rekursiv weitermachen
            pivot = medianOfMedians(medians, (medians.size() - 1) / 2);
        }

        //Partitionierung
        ArrayList<Integer> low = new ArrayList<>();
        ArrayList<Integer> high = new ArrayList<>();

        for (int j = 0; j < a.size(); j++) { // Aufteilung in die listen um den median herum

            if (a.get(j) > pivot) {
                high.add(a.get(j));
            } else if (a.get(j) < pivot) {
                low.add(a.get(j));
            }
        }

        // Falls Listengröße noch nicht passend, rekursive schritte um weiter zu filtern
        if (k <= low.size()) {
            return medianOfMedians(low, k);
        } else if (k > low.size() + 1) {
            return medianOfMedians(high, k - low.size() - 1);
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

    private static ArrayList<ArrayList<Integer>> listChunker(List<Integer> l) {
        // helper methode um die liste in sublisten zu splitten

        List<ArrayList<Integer>> newList = new ArrayList<>();

        int i = 0;

        while (i < l.size()) {

            ArrayList<Integer> chunk = new ArrayList<>();

            for (int j = 0; j < 5; j++) {

                if (j + i < l.size()) {
                    chunk.add(l.get(j + i));
                } else {
                    break;
                }
            }

            i += 5;
            Collections.sort(chunk, Collections.reverseOrder());
            newList.add(chunk);
        }

        return (ArrayList) newList;
    }

}
