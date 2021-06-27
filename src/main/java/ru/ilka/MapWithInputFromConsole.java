package ru.ilka;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class MapWithInputFromConsole {
    private static final String DELIMETER = "_";
    private static final char EXIT_COMMAND = '0';
    private static final char ADD_COMMAND = '1';
    private static final char GET_BY_KEY_COMMAND = '2';
    private static final char GET_ALL_COMMAND = '3';

    private static final String AVAILABLE_COMMANDS = new StringBuilder()
            .append("Available commands list: ")
            .append("\n\tExit: 0")
            .append("\n\tAdd key value pair: 1_key_value")
            .append("\n\tGet value by key: 2_key")
            .append("\n\tGet all key values set: 3")
            .toString();


    public void run() {

        Map<String, String> map = new HashMap<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(AVAILABLE_COMMANDS);
        while (true) {
            System.out.println("Type next command please.");

            String line = null;
            try {
                line = reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException("Cannpt read line from console");
            }
            if (!line.matches("(0)" +
                    "|(1_[a-zA-Z0-9]{1,10}_[a-zA-Z0-9]{1,10})" +
                    "|(2_[a-zA-Z0-9]{1,10})" +
                    "|(3)")) {
                System.out.println("Command is invalid!");
                System.out.println(AVAILABLE_COMMANDS);
                continue;
            }

            char command = line.charAt(0);
            switch (command) {
                case EXIT_COMMAND: {
                    System.out.println("Goodbye.");
                    return;
                }
                case ADD_COMMAND: {
                    String[] splittedLine = line.split(DELIMETER);
                    String key = splittedLine[1];
                    String value = splittedLine[2];
                    map.put(key, value);
                    break;
                }
                case GET_BY_KEY_COMMAND: {
                    String[] splittedLine = line.split(DELIMETER);
                    String key = splittedLine[1];
                    System.out.println(map.get(key));
                    break;
                }
                case GET_ALL_COMMAND: {
                    System.out.println(map);
                    break;
                }
                default: {
                    System.out.println("No such command!");
                }
            }
        }
    }
}
