package ru.ilka.multithreading;

import java.util.List;
import java.util.concurrent.Callable;

public class CountAverageCallable implements Callable<Double> {
    private List<Integer> numbers;

    public CountAverageCallable(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public Double call() throws Exception {
        if (numbers.isEmpty()) {
            return 0d;
        }
        int sum = 0;
        for (int i = 0; i < numbers.size(); i++) {
            sum += numbers.get(i);
        }
        return (double) sum / numbers.size();
    }
}
