package ru.kpfu.itis.group101.imamov.c2.asd.shellSort;

import ru.kpfu.itis.group101.imamov.c2.asd.shellSort.benchmark.Benchmark;
import ru.kpfu.itis.group101.imamov.c2.asd.shellSort.dataset.GenerateCSVDataset;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private Scanner sc;
    private Path currentFolder;
    private String[] folderNames;
    private int[] size;
    private ArrayList<double[]> timesForDifferentSteps;
    private GenerateCSVDataset generateCSVDataset;
    private Benchmark benchmark;

    public void init() {
        sc = new Scanner(System.in);
        currentFolder = Paths.get(sc.nextLine());    //ввод пути до папки, где нужно создать файлы для тестовых данных
        folderNames = new String[]{"set-1","set-2","set-3","set-4","set-5"};
        size = new int[]{100,500,1000,5000,10000,25000,50000,100000,250000,500000,750000,1000000};
        timesForDifferentSteps = new ArrayList<>();
        generateCSVDataset = new GenerateCSVDataset(currentFolder,folderNames,size);
        benchmark = new Benchmark();
    }

    public void start() {
        //генерация файлов с тестовыми данными
        generateCSVDataset.writeValues();

        //тестирование данных каждого файла
        for (String folderName : folderNames) {
            for (int value : size) {
                String fileForTesting = currentFolder.toString() + "\\" + folderName + "\\" + value + ".csv";
                String str = String.valueOf(benchmark.testing(fileForTesting, value));
                System.out.println(str.replace('.',','));

                //массив,содержащий время работы файли при каждом различном шаге
                timesForDifferentSteps.add(benchmark.getTimeOnDifferentSteps());
            }
        }

        //вывод массива,содержащий время работы файли при каждом различном шаге
        for (double[] elem : timesForDifferentSteps) {
            System.out.println(Arrays.toString(elem));
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.init();
        main.start();
    }
}
