package ru.ilka.list;

import java.util.Collection;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Stream;

public abstract class CollectionMock<T> implements Collection<T> {

    @Override
    public int size() {
        throw new NotImplementedException();
    }

    @Override
    public boolean isEmpty() {
        throw new NotImplementedException();
    }

    @Override
    public boolean contains(Object o) {
        throw new NotImplementedException();
    }

    @Override
    public Iterator<T> iterator() {
        throw new NotImplementedException();
    }

    @Override
    public Object[] toArray() {
        throw new NotImplementedException();
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        throw new NotImplementedException();
    }

    @Override
    public boolean add(T t) {
        throw new NotImplementedException();
    }

    @Override
    public boolean remove(Object o) {
        throw new NotImplementedException();
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new NotImplementedException();
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        throw new NotImplementedException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new NotImplementedException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new NotImplementedException();
    }

    @Override
    public void clear() {
        throw new NotImplementedException();
    }

    @Override
    public <T1> T1[] toArray(IntFunction<T1[]> generator) {
        throw new NotImplementedException();
    }

    @Override
    public boolean removeIf(Predicate<? super T> filter) {
        throw new NotImplementedException();
    }

    @Override
    public Spliterator<T> spliterator() {
        throw new NotImplementedException();
    }

    @Override
    public Stream<T> stream() {
        throw new NotImplementedException();
    }

    @Override
    public Stream<T> parallelStream() {
        throw new NotImplementedException();
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        throw new NotImplementedException();
    }
}
