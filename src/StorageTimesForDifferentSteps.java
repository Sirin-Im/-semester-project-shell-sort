package ru.kpfu.itis.group101.imamov.c2.asd.shellSort;

public class StorageTimesForDifferentSteps {
    private double[] time;
    private int ind;
    private int size;

    public StorageTimesForDifferentSteps(int size) {
        this.size = size;
        this.time = new double[lengthForTime()-1];
        this.ind = 0;
    }

    public int lengthForTime() {
        int newSize = 0;
        while (size > 0) {
            newSize++;
            size /= 2;
        }
        return newSize;
    }

    public void add(double num) {
        time[ind] = num;
        ind++;
    }

    public double[] getResult() {
        return time;
    }
}
