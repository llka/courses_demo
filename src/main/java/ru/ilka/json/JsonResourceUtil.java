package ru.ilka.json;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class JsonResourceUtil {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper()
            .enable(DeserializationFeature.READ_ENUMS_USING_TO_STRING);

    private JsonResourceUtil() {
    }

    public static <T> void writeObjectIntoJsonFile(File file, T object) {
        try {
            OBJECT_MAPPER.writeValue(file, object);
        } catch (IOException e) {
            throw new RuntimeException("Failed to write object to file", e);
        }
    }

    public static <T> T readResourceFileObject(String name, Class<T> valueType) {
        try {
            return OBJECT_MAPPER.readValue(readResourceFileAsString(name), valueType);
        } catch (IOException e) {
            throw new RuntimeException("Failed to parse resource file", e);
        }
    }

    public static <T> T readResourceStringAsObject(String jsonString, Class<T> valueType) {
        try {
            return OBJECT_MAPPER.readValue(jsonString, valueType);
        } catch (IOException e) {
            throw new RuntimeException("Failed to parse resource file", e);
        }
    }

    public static String readResourceFileAsString(String name) {
        try {
            //var classLoader = JsonResourceReader.class.getClassLoader();
            var file = new File(name);
            return Files.readString(Path.of(file.getPath()));
        } catch (IOException e) {
            throw new RuntimeException("Failed to read resource file", e);
        }
    }
}
