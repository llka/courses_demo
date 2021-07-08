package ru.ilka.lambdasrseams;

import java.util.Collection;

@FunctionalInterface
public interface CollectionObserver<T> {
    void observe(Collection<T> collection);
}
