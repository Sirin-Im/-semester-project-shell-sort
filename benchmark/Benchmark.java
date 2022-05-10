package ru.kpfu.itis.group101.imamov.c2.asd.shellSort.benchmark;

import ru.kpfu.itis.group101.imamov.c2.asd.shellSort.StorageTimesForDifferentSteps;
import ru.kpfu.itis.group101.imamov.c2.asd.shellSort.ShellSorting;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Benchmark {
    private double[] timeOnDifferentSteps;

    public double testing(String nameOfFile, int size) {
        int[] values = new int[size];
        int index = 0;

        try(BufferedReader reader = new BufferedReader(new FileReader(nameOfFile))){
            String line = reader.readLine();
            line = reader.readLine();

            //чтение данных из файла и добавление в массив
            while (line != null) {
                String[] data = line.split(",");
                values[index] = Integer.parseInt(data[1]);
                line = reader.readLine();
                index++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //замер времени в миллисекундах
        StorageTimesForDifferentSteps time = new StorageTimesForDifferentSteps(size);

        ShellSorting shellSort = new ShellSorting(values,time);
        long timeBefore = System.nanoTime();
        shellSort.sort();
        long timeAfter = System.nanoTime();

        //в timeOnDifferentSteps каждый раз записывается массив, содержащий время работы файли при каждом различном шаге
        timeOnDifferentSteps = time.getResult();

        return (double)(timeAfter - timeBefore)/1000000;
    }

    public double[] getTimeOnDifferentSteps() {
        return timeOnDifferentSteps;
    }
}
