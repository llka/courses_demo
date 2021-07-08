package ru.ilka.furniture;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class FurnitureGenerator {
    public List<Wardrobe> generateWardrobesList(int count) {
        List<Wardrobe> collection = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            Wardrobe wardrobe = Wardrobe.builder()
                    .depth(ThreadLocalRandom.current().nextInt(1, 10))
                    .height(ThreadLocalRandom.current().nextInt(1, 10))
                    .width(ThreadLocalRandom.current().nextInt(1, 10))
                    .build();
            collection.add(wardrobe);
        }
        return collection;
    }
}
