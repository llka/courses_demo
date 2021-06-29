package ru.ilka.multithreading;

public class WalkRunnable implements Runnable {
    private final int counter;

    public WalkRunnable(int counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < counter; i++) {
            System.out.println("Walking");
//            try {
//                TimeUnit.SECONDS.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }
}
