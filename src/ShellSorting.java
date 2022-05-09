package ru.kpfu.itis.group101.imamov.c2.asd.shellSort;

import java.util.Arrays;

public class ShellSorting {
    private int[] array;

    public ShellSorting(int[] array) {
        this.array = array;
    }

    public int[] sort() {
        for (int i = array.length; i > 0; i /= 2) {
            for (int move = i / 2; move > 0; move /= 2) {
                for (int k = move; k < i; k++) {
                    for (int j = k - move; j >= 0 && array[j] > array[j + move]; j -= move) {
                        int x = array[j];
                        array[j] = array[j + move];
                        array[j + move] = x;
                    }
                }
            }
        }
        return Arrays.copyOf(array,array.length);
    }
}
