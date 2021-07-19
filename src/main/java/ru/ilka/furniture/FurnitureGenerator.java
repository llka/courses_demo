package ru.ilka.furniture;

import ru.ilka.ObjectGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class FurnitureGenerator implements ObjectGenerator<Wardrobe> {

    @Override
    public List<Wardrobe> generate() {
        List<Wardrobe> collection = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            Wardrobe wardrobe = Wardrobe.builder()
                    .depth(ThreadLocalRandom.current().nextInt(1, 10))
                    .height(ThreadLocalRandom.current().nextInt(1, 10))
                    .width(ThreadLocalRandom.current().nextInt(1, 10))
                    .build();
            collection.add(wardrobe);
        }
        return collection;
    }

    public List<Wardrobe> generateCool(int size) {
        List<Wardrobe> collection = new ArrayList<>(size);
        for (int i = 0; i < 10; i++) {
            Wardrobe wardrobe = Wardrobe.builder()
                    .depth(ThreadLocalRandom.current().nextInt(1, size))
                    .height(ThreadLocalRandom.current().nextInt(1, size))
                    .width(ThreadLocalRandom.current().nextInt(1, size))
                    .build();
            collection.add(wardrobe);
        }
        return collection;
    }


}
