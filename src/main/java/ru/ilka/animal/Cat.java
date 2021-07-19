package ru.ilka.animal;

public class Cat extends Animal implements Jumpable {
    protected int mustache;
    private int legs;

    public Cat() {
    }

    public Cat(int legs, int mustache) {
        this.legs = legs;
        this.mustache = mustache;
    }

    public int getLegs() {
        return legs;
    }

    public void setLegs(int legs) {
        this.legs = legs;
    }

    public int getMustache() {
        return mustache;
    }

    public void setMustache(int mustache) {
        this.mustache = mustache;
    }

    public void scratch() {
        System.out.println("cat scratch");
    }

    public void signal() {
        System.out.println("cat signal");
    }

    @Override
    public void eat() {
        System.out.println("Cat eating");
    }

    @Override
    public void jump() {
        System.out.println("Cat jumping");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof Animal) return false;
        Cat cat = (Cat) o;
        return mustache == cat.mustache && legs == cat.legs;
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "legs=" + legs +
                ", mustache=" + mustache +
                '}';
    }
}
