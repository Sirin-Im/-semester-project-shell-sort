package ru.kpfu.itis.group101.imamov.c2.asd.shellSort.dataset;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;

public class GenerateCSVDataset {
    private int[] size;
    private String[] folderNames;
    private Path currentFolder;

    public GenerateCSVDataset(Path currentFolder, String[] folderNames, int[] size){
        this.currentFolder = currentFolder;
        this.size = size;
        this.folderNames = folderNames;
    }

    public void writeValues() {
        for (String folderName : folderNames) {
            for (int value : size) {
                String newFolder = currentFolder.toString() + "\\" + folderName + "\\" + value + ".csv";

                //создание файла для сохранения тестовых данных
                try {
                    new File(currentFolder.toString() + "\\" + folderName).mkdir();
                    new File(newFolder).createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                //запись данных в файл
                try (PrintWriter writer = new PrintWriter(newFolder)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("id");
                    sb.append(',');
                    sb.append("value");
                    sb.append('\n');

                    //генерация рандомных чисел в диапазоне от 0 до 1000000
                    for (int k = 0; k < value; k++) {
                        sb.append(k);
                        sb.append(',');
                        sb.append((long) (Math.random() * 1000000));
                        sb.append('\n');
                    }

                    writer.write(sb.toString());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
