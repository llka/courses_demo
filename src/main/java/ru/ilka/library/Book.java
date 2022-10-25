package ru.ilka.library;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Book implements Comparable<Book> {

    private int year;
    private int pages;
    private int authorsCount;

    @Override
    public String toString() {
        return "Book{" +
            "authorsCount=" + authorsCount +
            ", pages=" + pages +
            '}';
    }

    @Override
    public int compareTo(final Book o) {
        return this.pages - o.pages;
    }
}
