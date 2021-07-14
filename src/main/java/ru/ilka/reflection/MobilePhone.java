package ru.ilka.reflection;

public class MobilePhone {
    private String producer;
    private String model;
    private double diagonalInInch;
    private double cameraMegaPixels;

    public MobilePhone(String producer, String model, double diagonalInInch, double cameraMegaPixels) {
        this.producer = producer;
        this.model = model;
        this.diagonalInInch = diagonalInInch;
        this.cameraMegaPixels = cameraMegaPixels;
    }

    public MobilePhone() {
    }

    private void disallowedMethod() {
        System.out.println("Hello you have no permissions to execute me!");
    }

    @Override
    public String toString() {
        return "MobilePhone{" +
                "producer='" + producer + '\'' +
                ", model='" + model + '\'' +
                ", diagonalInInch=" + diagonalInInch +
                ", cameraMegaPixels=" + cameraMegaPixels +
                '}';
    }
}
