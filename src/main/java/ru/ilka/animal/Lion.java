package ru.ilka.animal;

public class Lion extends Cat {
    private int griva;

    public Lion(int legs,
                int mustache,
                int griva) {
        super(legs, mustache);
        this.griva = griva;
    }

    public int getGriva() {
        return griva;
    }

    public void setGriva(int griva) {
        this.griva = griva;
    }

    @Override
    public void signal() {
        System.out.println("lion roar");
    }

    @Override
    public void jump() {
        System.out.println("Lion Jumping");
    }
}
