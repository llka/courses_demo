package ru.ilka.building;

import java.util.Collection;

public interface BuildingContainer<T extends BuildingContainer> {

    default void print() {
        System.out.println(this.toString());
    }

    Collection<T> getChildren();
}
