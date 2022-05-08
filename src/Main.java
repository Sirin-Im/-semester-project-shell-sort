package ru.kpfu.itis.group101.komissarov.course1.term2.ASD.sem2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] a = new int[]{1,4,6,-2,-5,13,-1,0};
        ShellSorting sort = new ShellSorting(a);
        int[] b = sort.sort();
        System.out.println(Arrays.toString(b));
    }
}
