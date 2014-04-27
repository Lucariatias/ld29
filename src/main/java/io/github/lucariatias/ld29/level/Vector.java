package io.github.lucariatias.ld29.level;

public class Vector {

    private int i;
    private int j;

    public Vector(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public int getHorizontalComponent() {
        return i;
    }

    public int getVerticalComponent() {
        return j;
    }

    public Vector add(Vector vector) {
        return new Vector(i + vector.getHorizontalComponent(), j + vector.getVerticalComponent());
    }

}
