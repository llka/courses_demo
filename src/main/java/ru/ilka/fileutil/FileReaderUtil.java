package ru.ilka.fileutil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderUtil {
    private FileReaderUtil() {

    }

    public static List<String> readFile(String path) {
        File file = new File(path);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line = bufferedReader.readLine();
            List<String> list = new ArrayList<>();
            while (line != null) {
                list.add(line);
                line = bufferedReader.readLine();
            }
            return list;
        } catch (IOException e) {
            throw new RuntimeException("Failed to read lines from file: " + file, e);
        }
    }
}
