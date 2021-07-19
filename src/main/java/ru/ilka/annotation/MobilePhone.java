package ru.ilka.annotation;

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

    @Init
    public void test() {
        System.out.println("test");
    }


}
