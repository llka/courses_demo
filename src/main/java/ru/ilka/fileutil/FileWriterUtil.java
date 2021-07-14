package ru.ilka.fileutil;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterUtil {

    private static FileWriterUtil instance;

    private FileWriterUtil() {
    }

    public static FileWriterUtil getInstance() {
        if (instance == null) {
            instance = new FileWriterUtil();
        }
        return instance;
    }

    public void writeToFileEnd(String path, String message) {
        File file = new File(path);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true))) {
            bufferedWriter.write(message);
            bufferedWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException("Ups, failed to write into file: " + path, e);
        }
    }

    public synchronized void appendInt(int value, String path) {
        File file = new File(path);
        try (FileWriter fileWriter = new FileWriter(file, true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            bufferedWriter.write(String.valueOf(value));
            bufferedWriter.newLine();
        } catch (IOException e) {
            throw new RuntimeException("Ups, failed to write into file: " + path, e);
        }
    }
}
