package io.github.lucariatias.ld29.level;

public class Location {

    private int x;
    private int y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int distanceSquared(Location location) {
        return ((x - location.getX()) * (x - location.getX())) + ((y - location.getY()) * (y - location.getY()));
    }

    public Location getRelative(Vector vector) {
        return new Location(x + vector.getHorizontalComponent(), y + vector.getVerticalComponent());
    }

}
