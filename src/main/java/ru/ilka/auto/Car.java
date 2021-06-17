package ru.ilka.auto;

import java.util.Objects;

public class Car extends Wehicle {
    private String gaiNumber;
    private int weightInKg;
    private int passengersMaxQnt;
    private int fuelCapacityInLitres;
    private int maxSpeed;
    private Engine engine;
    private FuelType fuelType;

    public static Car.CarBuilder builder() {
        return new Car.CarBuilder();
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public String getGaiNumber() {
        return this.gaiNumber;
    }

    public void setGaiNumber(String gaiNumber) {
        this.gaiNumber = gaiNumber;
    }

    public int getWeightInKg() {
        return this.weightInKg;
    }

    public void setWeightInKg(int weightInKg) {
        this.weightInKg = weightInKg;
    }

    public int getPassengersMaxQnt() {
        return this.passengersMaxQnt;
    }

    public void setPassengersMaxQnt(int passengersMaxQnt) {
        this.passengersMaxQnt = passengersMaxQnt;
    }

    public int getFuelCapacityInLitres() {
        return this.fuelCapacityInLitres;
    }

    public void setFuelCapacityInLitres(int fuelCapacityInLitres) {
        this.fuelCapacityInLitres = fuelCapacityInLitres;
    }

    public int getMaxSpeed() {
        return this.maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public Engine getEngine() {
        return this.engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return weightInKg == car.weightInKg && passengersMaxQnt == car.passengersMaxQnt && fuelCapacityInLitres == car.fuelCapacityInLitres && maxSpeed == car.maxSpeed && Objects.equals(gaiNumber, car.gaiNumber) && Objects.equals(engine, car.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gaiNumber, weightInKg, passengersMaxQnt, fuelCapacityInLitres, maxSpeed, engine);
    }

    @Override
    public String toString() {
        return "Car{" +
                "gaiNumber='" + gaiNumber + '\'' +
                ", weightInKg=" + weightInKg +
                ", passengersMaxQnt=" + passengersMaxQnt +
                ", fuelCapacityInLitres=" + fuelCapacityInLitres +
                ", maxSpeed=" + maxSpeed +
                ", engine=" + engine +
                ", fuelType=" + fuelType +
                ", wheel=" + wheel +
                "} " + super.toString();
    }

    public static class CarBuilder {
        private final Car car = new Car();

        private CarBuilder() {
        }

        public Car.CarBuilder fuelType(FuelType fuelType) {
            this.car.fuelType = fuelType;
            return this;
        }


        public Car.CarBuilder gaiNumber(String gaiNumber) {
            this.car.gaiNumber = gaiNumber;
            return this;
        }

        public Car.CarBuilder weightInKg(int weightInKg) {
            this.car.weightInKg = weightInKg;
            return this;
        }

        public Car.CarBuilder passengersMaxQnt(int passengersMaxQnt) {
            this.car.passengersMaxQnt = passengersMaxQnt;
            return this;
        }

        public Car.CarBuilder fuelCapacityInLitres(int fuelCapacityInLitres) {
            this.car.fuelCapacityInLitres = fuelCapacityInLitres;
            return this;
        }

        public Car.CarBuilder maxSpeed(int maxSpeed) {
            this.car.maxSpeed = maxSpeed;
            return this;
        }

        public Car.CarBuilder engine(Engine engine) {
            this.car.engine = engine;
            return this;
        }

        public Car build() {
            return car;
        }
    }
}
