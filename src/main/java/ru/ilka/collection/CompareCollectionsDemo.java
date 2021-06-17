package ru.ilka.collection;

import ru.ilka.list.CustomLinkedList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;

public class CompareCollectionsDemo {
    public static void compareRemoveIfExecutionTime_customLinkedList_vs_ArrayList(int listSize) {
        final CustomLinkedList<Integer> customLinkedList = collectionWithRandomValues(CustomLinkedList::new, listSize);
        final ArrayList<Integer> arrayList = collectionWithRandomValues(ArrayList::new, listSize);

        countExecutionTime("customLinkedList removeIf", () -> customLinkedList.removeIf(val -> val < 4));
        countExecutionTime("arrayList removeIf", () -> arrayList.removeIf(val -> val < 4));
    }

    public static void compareRemoveOneByOneViaGetByIndexExecutionTime_LinkedList_vs_ArrayList(int listSize) {
        final LinkedList<Integer> linkedList = collectionWithRandomValues(LinkedList::new, listSize);
        final ArrayList<Integer> arrayList = collectionWithRandomValues(ArrayList::new, listSize);

        countExecutionTime("LinkedList remove one by one via get(index)", () -> {
            for (int i = 0; i < linkedList.size(); i++) {
                if (linkedList.get(i) < 4) {
                    linkedList.remove(i);
                    i--;
                }
            }
        });
        countExecutionTime("ArrayList remove one by one via get(index)", () -> {
            for (int i = 0; i < arrayList.size(); i++) {
                if (arrayList.get(i) < 4) {
                    arrayList.remove(i);
                    i--;
                }
            }
        });
    }

    public static void compareRemoveOneByOneViaIteratorExecutionTime_LinkedList_vs_ArrayList(int listSize) {
        final LinkedList<Integer> linkedList = collectionWithRandomValues(LinkedList::new, listSize);
        final ArrayList<Integer> arrayList = collectionWithRandomValues(ArrayList::new, listSize);

        countExecutionTime("LinkedList remove one by one via iterator", () -> {
            Iterator<Integer> iterator = linkedList.iterator();
            while (iterator.hasNext()) {
                if (iterator.next() < 5) {
                    iterator.remove();
                }
            }
        });
        countExecutionTime("ArrayList remove one by one via iterator", () -> {
            Iterator<Integer> iterator = arrayList.iterator();
            while (iterator.hasNext()) {
                if (iterator.next() < 5) {
                    iterator.remove();
                }
            }
        });
    }

    public static void compareRemoveOneByOneExecutionTime_customLinkedList_vs_LinkedListIterator(int listSize) {
        final CustomLinkedList<Integer> customLinkedList = collectionWithRandomValues(CustomLinkedList::new, listSize);
        final LinkedList<Integer> linkedList = collectionWithRandomValues(LinkedList::new, listSize);

        countExecutionTime("customLinkedList removeIf", () -> customLinkedList.removeIf(val -> val < 4));
        countExecutionTime("LinkedList remove one by one via iterator", () -> {
            Iterator<Integer> iterator = linkedList.iterator();
            while (iterator.hasNext()) {
                if (iterator.next() < 5) {
                    iterator.remove();
                }
            }
        });
    }

    private static void countExecutionTime(String message, Runnable runnable) {
        System.out.println(message);
        long start = System.currentTimeMillis();
        runnable.run();
        System.out.println(message + " execution time in millis: " + (System.currentTimeMillis() - start));
    }

    private static <T extends Collection<Integer>> T collectionWithRandomValues(Supplier<T> collectionSupplier,
                                                                                final int size) {
        T collection = collectionSupplier.get();
        for (int i = 0; i < size; i++) {
            collection.add(ThreadLocalRandom.current().nextInt(1, 10));
        }
        return collection;
    }
}
