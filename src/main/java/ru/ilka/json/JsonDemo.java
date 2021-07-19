package ru.ilka.json;

import ru.ilka.json.model.Guitar;
import ru.ilka.json.model.GuitarBodyType;

import java.io.File;

public class JsonDemo {
    public static void demo() {
        Guitar guitar = new Guitar("Fender", "ASD-250", GuitarBodyType.TELECASTER);

        JsonResourceUtil.writeObjectIntoJsonFile(new File("data/json/asd-250.json"), guitar);

//        Guitar[] guitars = JsonResourceUtil.readResourceFileObject("data/json/guitars.json", Guitar[].class);
//
//        System.out.println("Result:");
//        Arrays.stream(guitars).forEach(System.out::println);

//        Guitar testRead = JsonResourceUtil.readResourceFileObject("data/json/test_write.json", Guitar.class);
//        System.out.println(testRead);
    }
}
