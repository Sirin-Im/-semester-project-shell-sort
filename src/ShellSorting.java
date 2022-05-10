package ru.kpfu.itis.group101.imamov.c2.asd.shellSort;

import java.util.Arrays;

public class ShellSorting {
    private int[] array;
    private StorageTimesForDifferentSteps timeTest;

    public ShellSorting(int[] array, StorageTimesForDifferentSteps timeTest) {
        this.array = array;
        this.timeTest = timeTest;
    }

    public int[] sort() {
        for (int move = array.length / 2; move > 0; move /= 2) {
            long timeBefore = System.nanoTime();
            for (int k = move; k < array.length; k++) {
                for (int j = k - move; j >= 0 && array[j] > array[j + move]; j -= move) {
                    int x = array[j];
                    array[j] = array[j + move];
                    array[j + move] = x;
                }
            }
            long timeAfter = System.nanoTime();
            timeTest.add((double)(timeAfter - timeBefore)/1000000);   //добавления времени работы алгоритма в класс теста
        }
        return Arrays.copyOf(array,array.length);
    }
}
