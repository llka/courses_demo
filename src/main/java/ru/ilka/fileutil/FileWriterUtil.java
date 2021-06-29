package ru.ilka.fileutil;

import lombok.experimental.UtilityClass;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@UtilityClass
public class FileWriterUtil {
    public void writeToFileEnd(String path, String message) {
        File file = new File(path);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            bufferedWriter.write(message);
            bufferedWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException("Ups, failed to write into file: " + path, e);
        }
    }
}
