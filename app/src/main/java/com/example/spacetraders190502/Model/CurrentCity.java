package com.example.spacetraders190502.Model;

public class CurrentCity {
    public String name;
    public int x;
    public int y;
    public TechLevel techLevel;
    public Resources res;
    public int ordinal;
    Cities c = new Cities();

    public CurrentCity(int ordinal) {

        this.name = c.names[ordinal];
        this.x = c.xs[ordinal];
        this.y = c.ys[ordinal];
        this.techLevel = c.techLevels[ordinal];
        this.res = c.ress[ordinal];
    }

    public boolean canTravel(Region region, Spaceship ship) {
        int x = this.x;
        int y = this.y;
        int x2 = region.getX();
        int y2 = region.getY();
        double distance = Math.sqrt(Math.pow(x2 - x, 2) + Math.pow(y2 - y, 2));
        if (distance == 0) {
            return false;
        }
        return distance < ship.getFueldistance();
    }
}
