package ru.ilka.furniture;

import java.util.Comparator;

public class WardrobeHeightComparator implements Comparator<Wardrobe> {
    @Override
    public int compare(Wardrobe o1, Wardrobe o2) {
        return o1.getHeight() - o2.getHeight();
    }
}
