package ru.ilka.multithreading.providerconsumer.firewater;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.Queue;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicBoolean;

@Slf4j
@AllArgsConstructor
@Data
public class CrystalProducer implements Runnable {

    private final Queue<Crystal> queue;
    private final int maxCrystals;
    private volatile int counter = 0;
    private AtomicBoolean finish;

    @SneakyThrows
    @Override
    public void run() {
        log.info("Crystal producer - start creating crystals");
        while (counter < maxCrystals && finish.get()) {
            synchronized (queue) {
                int totalCount = ThreadLocalRandom.current().nextInt(2, 5);
                int redCrystalsCount = ThreadLocalRandom.current().nextInt(0, totalCount);

                for (int i = 0; i < redCrystalsCount; i++) {
                    queue.offer(new Crystal(++counter, CrystalColorEnum.RED));
                }
                for (int i = 0; i < totalCount - redCrystalsCount; i++) {
                    queue.offer(new Crystal(++counter, CrystalColorEnum.WHITE));
                }
                //log.debug("Crystal producer - created {} red and {} white crystals. Queue: {}",
                //   redCrystalsCount, totalCount - redCrystalsCount, queue);
            }
            synchronized (this) {
                wait(100);
            }
        }
        log.info("Crystal producer - finished");

    }
}
