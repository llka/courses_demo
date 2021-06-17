package ru.ilka.auto;

public class Wehicle extends Base {
    private String name;
    protected Wheel wheel;

    @Override
    public String toString() {
        return "Wehicle{" +
                "name='" + name + '\'' +
                ", wheel=" + wheel +
                "} " + super.toString();
    }
}
