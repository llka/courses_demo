package ru.ilka.multithreading.producerconsumer;

import lombok.SneakyThrows;

import java.util.Queue;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Producer extends AbstractProducerConsumer {
    public Producer(Queue<Integer> queue, AtomicInteger counter, String name) {
        super(queue, counter, name);
    }

    @SneakyThrows
    @Override
    public void run() {
        while (run.get()) {
            if (counter.get() < Config.MAX_COUNT_HANDLED_ELEMENTS) {
                synchronized (queue) {
                    int queueSize = queue.size();
                    if (queueSize < Config.QUEUE_SIZE_UNTIL_PRODUCER_WORK) {
                        int randomNum = ThreadLocalRandom.current().nextInt(1, 101);
                        queue.offer(randomNum);
                        System.out.println("Queue size is: " + queueSize + ". Producer: " + name + " added num: " + randomNum);
                    } else {
                        System.out.println("Queue size is: " + queueSize + ". Producer: " + name + " is sleeping!");
                        TimeUnit.MILLISECONDS.sleep(100);
                    }
                }
            } else {
                run.getAndSet(false);
            }
        }
        System.out.println("Producer: " + name + " finished working!");
    }
}
