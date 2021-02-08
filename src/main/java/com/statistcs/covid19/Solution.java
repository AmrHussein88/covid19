package com.statistcs.covid19;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static String checkNumber(int N) {
        if ((N % 2) == 1) {
            return "weird";
        } else if ((N % 2) == 0) {
            if (N >= 2 && N <= 5) {
                return "Not weird";
            } else if (N >= 6 && N <= 20) {
                return "weird";
            } else if (N > 20) {
                return "Not weird";
            }
        }
        return null;
    }

    public static int getCapacity(List<Integer> used, List<Integer> total) {
        Long cap = 0L;
        for (int i = 0; i < used.size(); i++) {
            for (int j = i + 1; j < used.size(); j++) {

                if (used.get(i) == total.get(i)) {
                    break;
                } else if (used.get(i) + used.get(j) <= total.get(i) && (used.get(j) > 0 && used.get(j) < total.get(i))) {
                    used.set(i, used.get(i) + used.get(j));
                    used.set(j, 0);
                }
            }
        }
        cap = used.stream().filter(u -> u > 0).count();


        return cap.intValue();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<Integer> used = new ArrayList<>();
        used.add(1);
        used.add(1);
        used.add(1);
        used.add(2);
        used.add(2);
        used.add(2);
        used.add(1);
        used.add(1);

        List<Integer> total = new ArrayList<>();
        total.add(10);
        total.add(3);
        total.add(3);
        total.add(3);
        total.add(3);
        total.add(3);
        total.add(3);
        total.add(3);

        System.out.println(getCapacity(used, total));
    }
}
