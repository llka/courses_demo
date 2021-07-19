package ru.ilka.multithreading.producerconsumer;

import lombok.SneakyThrows;

import java.util.Queue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Consumer extends AbstractProducerConsumer {
    public Consumer(Queue<Integer> queue, AtomicInteger counter, String name) {
        super(queue, counter, name);
    }

    @SneakyThrows
    @Override
    public void run() {
        while (run.get()) {
            synchronized (counter) {
                if (counter.get() < Config.MAX_COUNT_HANDLED_ELEMENTS) {
                    Integer handledElement = queue.poll();
                    if (handledElement != null) {
                        counter.incrementAndGet();
                        System.out.println("Consumer: " + name + " handled num: " + handledElement +
                                ". Counter: " + counter.get());
                    } else {
                        System.out.println("Queue is empty. Consumer: " + name + " is sleeping!");
                        TimeUnit.MILLISECONDS.sleep(100);
                    }
                } else {
                    run.getAndSet(false);
                }
            }
        }
        System.out.println("Consumer: " + name + " finished working!");
    }
}
