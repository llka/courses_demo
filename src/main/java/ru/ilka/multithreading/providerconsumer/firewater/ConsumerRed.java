package ru.ilka.multithreading.providerconsumer.firewater;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.Queue;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicBoolean;

@Slf4j
@Data
@AllArgsConstructor
public class ConsumerRed implements Runnable {

    private final Queue<Crystal> queue;
    private final int capacity;
    private int counter = 0;
    private AtomicBoolean finish;

    @SneakyThrows
    @Override
    public void run() {
        log.info("Red consumer - start collecting crystals");
        while (counter < capacity && finish.get()) {
            synchronized (queue) {

                for (int i = 0; i < ThreadLocalRandom.current().nextInt(2, 5); i++) {
                    if (!queue.isEmpty()) {
                        Crystal crystal = queue.poll();
                        if (crystal.getColor() == CrystalColorEnum.RED) {
                            counter++;
                            log.debug("Red consumer - found RED crystal!!! {}", crystal);
                        } else {
                            log.debug("Red consumer - found not red crystal: {}", crystal);
                        }
                    }
                }

            }
            synchronized (this) {
                wait(100);
            }
            if (counter >= capacity) {
                finish.getAndSet(false);
            }
        }
        log.info("Red consumer - is full.");
    }
}
