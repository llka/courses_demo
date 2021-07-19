package ru.ilka.multithreading.producerconsumer;

import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;

public class Task57Demo {
    public void demo() {
        LinkedBlockingDeque<Integer> queue = new LinkedBlockingDeque<>();
        AtomicInteger counter = new AtomicInteger(0);

        List<AbstractProducerConsumer> producerConsumerList = List.of(
                new Producer(queue, counter, "A"),
                new Producer(queue, counter, "B"),
                new Producer(queue, counter, "C"),
                new Consumer(queue, counter, "A"),
                new Consumer(queue, counter, "B"));
        producerConsumerList.forEach(producerConsumer -> {
            Thread thread = new Thread(producerConsumer);
            thread.start();
        });
    }
}
