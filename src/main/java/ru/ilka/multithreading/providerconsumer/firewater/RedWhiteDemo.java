package ru.ilka.multithreading.providerconsumer.firewater;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class RedWhiteDemo {

    public void demo() {
        ReentrantLock queueLock = new ReentrantLock(true);

        Queue<Crystal> queue = new ArrayDeque<>();
        AtomicBoolean isNotFull = new AtomicBoolean(true);
        Thread white = new Thread(new ConsumerWhite(queue, 10, new HashMap<>(), isNotFull));
        Thread red = new Thread(new ConsumerRed(queue, 10, 0, isNotFull));
        Thread producer = new Thread(new CrystalProducer(queue, 100, 0, isNotFull));

        producer.start();
        white.start();
        red.start();
    }
}
