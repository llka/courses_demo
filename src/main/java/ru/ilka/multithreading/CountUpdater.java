package ru.ilka.multithreading;

public class CountUpdater implements Runnable {
    private CounterWrapper counterWrapper;
    private int delta;
    private int count;

    public CountUpdater(CounterWrapper counterWrapper, int delta, int count) {
        this.counterWrapper = counterWrapper;
        this.delta = delta;
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 0; i < count; i++) {
            counterWrapper.increment(delta);
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
