package ru.ilka.animal;

public interface CanEat {
    public static int COUNT = 100;

    default void eat() {
        System.out.println("default eat");
    }
}
