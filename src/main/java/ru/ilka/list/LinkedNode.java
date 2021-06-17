package ru.ilka.list;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LinkedNode<T> {
    T value;
    LinkedNode<T> prev;
    LinkedNode<T> next;

    @Override
    public String toString() {
        return "LinkedNode{" +
                "value=" + value +
                '}';
    }
}
