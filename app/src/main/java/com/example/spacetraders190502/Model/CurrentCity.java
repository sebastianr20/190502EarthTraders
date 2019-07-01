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
}
