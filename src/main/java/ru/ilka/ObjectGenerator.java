package ru.ilka;

import java.util.Collection;

public interface ObjectGenerator<T> {
    Collection<T> generate();
}
