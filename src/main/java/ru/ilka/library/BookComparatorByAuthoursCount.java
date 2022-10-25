package ru.ilka.library;

import java.util.Comparator;

public class BookComparatorByAuthoursCount implements Comparator<Book> {

    @Override
    public int compare(final Book o1, final Book o2) {
        return o1.getAuthorsCount() - o2.getAuthorsCount();
    }
}
