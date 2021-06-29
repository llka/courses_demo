package ru.ilka.fileutil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderUtil {
    private FileReaderUtil() {

    }

    public static int readIntFromFile(String path) {
        File file = new File(path);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            return Integer.parseInt(bufferedReader.readLine());
        } catch (IOException e) {
            throw new RuntimeException("Failed to read lines from file: " + file, e);
        } catch (NumberFormatException e1) {
            throw new RuntimeException("Failed to cast string to int!");
        }
    }

    public static void printFilesHierarchy(String path) {
        printFilesHierarchy(new File(path), 0);
    }

    private static void printFilesHierarchy(File directory, int tab) {
        if (directory == null) {
            throw new IllegalArgumentException("No such directory!");
        }
        String shift = " " .repeat(Math.max(0, tab));
        if (directory.isDirectory()) {
            for (File file : directory.listFiles()) {
                if (file.isFile()) {
                    System.out.println(shift + file.getName());
                } else {
                    System.out.println(shift + file.getName());
                    printFilesHierarchy(file, tab + 3);
                }
            }
        } else {
            System.out.println(shift + directory.getName());
        }

    }
}
