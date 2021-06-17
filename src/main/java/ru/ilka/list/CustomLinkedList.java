package ru.ilka.list;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.function.Predicate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomLinkedList<T> extends CollectionMock<T> {
    LinkedNode<T> head;
    LinkedNode<T> tail;
    int size = 0;

    @Override
    public boolean add(T value) {
        LinkedNode<T> node = new LinkedNode<>();
        node.setValue(value);
        if (head == null) {
            head = node;
        }
        if (size == 1) {
            head.setNext(node);
        }
        if (tail != null) {
            tail.setNext(node);
            node.setPrev(tail);
        }
        tail = node;
        size++;

        return true;
    }

    public void remove(LinkedNode<T> node) {
        LinkedNode<T> prev = node.getPrev();
        LinkedNode<T> next = node.getNext();

        if (node == head) {
            head = next;
            if (next != null) {
                next.setPrev(null);
            }
        }
        if (node == tail && prev != null) {
            tail = prev;
            prev.setNext(null);
        }

        if (prev != null) {
            prev.setNext(next);
        }
        if (next != null) {
            next.setPrev(prev);
        }
        size--;
    }

    @Override
    public boolean removeIf(Predicate<? super T> predicate) {
        LinkedNode<T> curr = head;
        while (curr != null) {
            LinkedNode<T> next = curr.getNext();
            if (predicate.test(curr.getValue())) {
                remove(curr);
            }
            curr = next;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public String getAllNodesValuesAsString() {
        LinkedNode<T> curr = head;
        StringBuilder stringBuilder = new StringBuilder("{");
        while (curr != null) {
            if (curr != head) {
                stringBuilder.append(" ");
            }
            stringBuilder.append(curr.getValue());
            if (curr != tail) {
                stringBuilder.append(", ");
            }
            curr = curr.getNext();
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }


    @Override
    public String toString() {
        return "CustomLinkedList{" +
                "head=" + head +
                ", tail=" + tail +
                ", size=" + size +
                '}';
    }
}
