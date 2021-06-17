package ru.ilka.auto;

import java.math.BigDecimal;

public class CarService {
    public static final String NAME = "Lada service";

    private static void repair(final Car car) {
        System.out.println("repairing");
    }

    public static BigDecimal calclulateFuelCostForGas(int km) {
        return BigDecimal.valueOf(1.95).multiply(BigDecimal.valueOf(km));
    }

    public static BigDecimal calclulateFuelCostForDiesel(int km) {
        return BigDecimal.valueOf(2).multiply(BigDecimal.valueOf(km));
    }

    public static BigDecimal calclulateFuelCostForElectricity(int km) {
        return BigDecimal.valueOf(0.1).multiply(BigDecimal.valueOf(km));
    }
}
