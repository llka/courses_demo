package ru.ilka.flower;

public class FlowerFilter {

    public void filterFlowersByColor(Flower[] array, Color targetColor) {
        System.out.println("Flowers with color: " + targetColor);
        for (int i = 0; i < array.length; i++) {
            if (array[i].getColor() == targetColor) {
                System.out.println(array[i]);
            }
        }
        System.out.println("--------");
    }

}
