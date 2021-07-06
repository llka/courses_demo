package ru.ilka.multithreading;

public class TalkThread extends Thread {
    private final int counter;
    private final String name;

    public TalkThread(int counter, String name) {
        this.counter = counter;
        this.name = name;
    }

    public TalkThread() {
        this.counter = 100;
        this.name = "default";
    }

    @Override
    public void run() {
        for (int i = 0; i < counter; i++) {
            System.out.println(name + " Talking " + i);
        }
        System.out.println("Thread: " + name + " is finished");
    }
}
