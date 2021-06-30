package ru.ilka.multithreading;

public class CountUpdaterForInt implements Runnable {
    private volatile int val;
    private int delta;
    private int count;

    public CountUpdaterForInt(int value, int delta, int count) {
        this.delta = delta;
        this.count = count;
        this.val = value;
    }

    @Override
    public void run() {
        for (int i = 0; i < count; i++) {
            this.val += delta;
        }
    }
}
