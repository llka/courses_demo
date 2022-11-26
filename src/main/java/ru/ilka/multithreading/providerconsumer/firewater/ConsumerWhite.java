package ru.ilka.multithreading.providerconsumer.firewater;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;

@Slf4j
@Data
@AllArgsConstructor
public class ConsumerWhite implements Runnable {

    private final Queue<Crystal> queue;
    private final int capacity;
    private Map<CrystalColorEnum, Integer> counter = new HashMap<>();
    private AtomicBoolean finish;

    @SneakyThrows
    @Override
    public void run() {
        log.info("White consumer - start collecting crystals");
        while (getAllColorsCountSum() < capacity && finish.get()) {
            synchronized (queue) {
                if (!queue.isEmpty()) {
                    Crystal crystal = queue.poll();
                    counter.put(crystal.getColor(), counter.get(crystal.getColor()) + 1);
                }
            }
            synchronized (this) {
                wait(100);
            }
            if (getAllColorsCountSum() >= capacity) {
                finish.getAndSet(false);
            }
        }
        log.info("White consumer - is full.");
    }

    private int getAllColorsCountSum() {
        return counter.values().stream().mapToInt(Integer::intValue).sum();
    }

}
