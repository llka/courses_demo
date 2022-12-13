package ru.ilka;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class FindMaxOccurredLetter {

    private final int lettersCount;

    public FindMaxOccurredLetter(final int lettersCount) {
        this.lettersCount = lettersCount;
    }

    public void generateInput(Path path) {
        File file = path.toFile();
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true))) {
            for (int i = 0; i < lettersCount; i++) {
                String letter = randomString(1);
                bufferedWriter.write(letter + ",");
            }
            bufferedWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException("Ups, failed to write into file: " + path, e);
        }
    }

    public String solution(Path path) {
        File file = path.toFile();

        Map<Character, Long> map = new HashMap<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            int current = bufferedReader.read();
            while (current != -1) {
                Character letter = (char) current;
                map.put(letter, map.getOrDefault(letter, 0L) + 1);
                // skipping comma
                int comma = bufferedReader.read();
                current = bufferedReader.read();
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to read lines from file: " + file, e);
        }

        Long max = -1L;
        char maxLetter = ' ';
        for (Map.Entry<Character, Long> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                maxLetter = entry.getKey();
            }
        }

        return String.valueOf(maxLetter) + ":" + max;
    }

    private String randomString(int length) {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        return ThreadLocalRandom.current().ints(leftLimit, rightLimit + 1)
            .limit(length)
            .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
            .toString();
    }
}
