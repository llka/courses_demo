package ru.ilka.multithreading;

public class CounterWrapper {
    private int value;

    public CounterWrapper(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void increment(int delta) {
        synchronized (this) {
            this.value = this.value + delta;
        }
    }

    @Override
    public String toString() {
        return "ConuterWrapper{" +
                "value=" + value +
                '}';
    }
}
