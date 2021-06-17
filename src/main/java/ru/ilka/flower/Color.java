package ru.ilka.flower;

public enum Color {
    WHITE(1),
    RED(2),
    BLACK(3),
    YELLOW(4);

    private final long number;

    Color(long number) {
        this.number = number;
    }
}
