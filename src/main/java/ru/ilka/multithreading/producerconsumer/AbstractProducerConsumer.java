package ru.ilka.multithreading.producerconsumer;

import java.io.Serializable;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class AbstractProducerConsumer implements Runnable, Cloneable, Serializable {

    protected final Queue<Integer> queue;
    protected AtomicBoolean run;
    protected final AtomicInteger counter;
    protected String name;

    public AbstractProducerConsumer(Queue<Integer> queue, AtomicInteger counter, String name) {
        this.queue = queue;
        this.run = new AtomicBoolean(true);
        this.counter = counter;
        this.name = name;
    }
}
