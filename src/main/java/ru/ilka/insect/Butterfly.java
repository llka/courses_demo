package ru.ilka.insect;

import ru.ilka.flower.Color;

import java.util.Objects;

public class Butterfly {
    private String name;
    private Double wingsSquareInMM;
    private Color color;

    public Butterfly(String name, Double wingsSquareInMM, Color color) {
        this.name = name;
        this.wingsSquareInMM = wingsSquareInMM;
        this.color = color;
    }

    public Butterfly() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getWingsSquareInMM() {
        return wingsSquareInMM;
    }

    public void setWingsSquareInMM(Double wingsSquareInMM) {
        this.wingsSquareInMM = wingsSquareInMM;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Butterfly butterfly = (Butterfly) o;
        return color == butterfly.color && Objects.equals(name, butterfly.name)
                && Objects.equals(wingsSquareInMM, butterfly.wingsSquareInMM);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, wingsSquareInMM, color);
    }

    @Override
    public String toString() {
        return "Butterfly{" +
                "name='" + name + '\'' +
                ", wingsSquareInMM=" + wingsSquareInMM +
                ", color=" + color +
                '}';
    }
}
