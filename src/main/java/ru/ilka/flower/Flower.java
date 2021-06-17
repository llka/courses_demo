package ru.ilka.flower;

import java.util.Objects;

public class Flower {
    private int height;
    private Color color;
    private final String title;

    public Flower() {
        this.title = null;
    }

    public Flower(String title) {
        this.title = title;
    }

    public Flower(int height, Color color, String title) {
        this.height = height;
        this.color = color;
        this.title = title;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flower flower = (Flower) o;
        return height == flower.height && color == flower.color && Objects.equals(title, flower.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(height, color, title);
    }

    @Override
    public String toString() {
        return "Flower{" +
                "height=" + height +
                ", color=" + color +
                ", title='" + title + '\'' +
                '}';
    }
}
