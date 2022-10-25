package ru.ilka.auto;

import java.math.BigDecimal;
import java.util.function.Function;

public enum FuelType {
    GAS(false, CarService::calclulateFuelCostForGas),
    DIESEL(false, CarService::calclulateFuelCostForDiesel),
    ELECTRICITY(true, CarService::calclulateFuelCostForElectricity);

    private final boolean isEcoFriendly;
    private final Function<Integer, BigDecimal> calculateFuelCostFunction;

    FuelType(boolean isEcoFriendly,
             Function<Integer, BigDecimal> calculateUsage) {
        this.isEcoFriendly = isEcoFriendly;
        this.calculateFuelCostFunction = calculateUsage;
    }

    public Function<Integer, BigDecimal> getCalculateFuelCostFunction() {
        return calculateFuelCostFunction;
    }

    public boolean isEcoFriendly() {
        FuelType[] arr = values();
        return isEcoFriendly;
    }

    public FuelType getValue(String name) {
        for (FuelType val : values()) {
            if (val.name().equals(name)) {
                return val;
            }
        }
        return null;
    }

}
