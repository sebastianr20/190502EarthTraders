package com.example.spacetraders190502.Model;

import android.util.Log;

public enum Region {
    NEWDELHI("New Delhi",0, 0, TechLevel.Agriculture, Resources.LIFELESS),
    BANGKOK("Bangkok",10, 10, TechLevel.Medieval, Resources.DESERT),
    NEWYORK("New York City", 50, 50, TechLevel.Renaissance, Resources.MINERALRICH),
    AMSTERDAM("Amsterdam", 47, 48, TechLevel.PreAgriculture, Resources.WEIRDMUSHROOMS),
    ROME("Rome", 45, 32, TechLevel.HiTech, Resources.POORSOIL),
    ATHENS("Athens", 20, 2, TechLevel.PostIndustrial, Resources.ARTISTIC),
    JOHANNESBURG("Johannesburg", 34, 16, TechLevel.Industrial, Resources.LOTSOFWATER),
    BOGOTA("Bogota", 17, 21, TechLevel.HiTech, Resources.RICHFAUNA),
    CAIRO("Cairo", 18, 36, TechLevel.Renaissance, Resources.LOTSOFHERBS),
    SYDNEY("Sydney", 41, 33, TechLevel.Agriculture, Resources.WARLIKE);

    String name;
    TechLevel techLevel;
    Resources res;
    int x, y;

    Region(String name, int x, int y, TechLevel techLevel, Resources res) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.techLevel = techLevel;
        this.res = res;
        Log.i("Region Created", this.toString());
    }

    public String getName() {
        return this.name;
    }
    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    @Override
    public String toString() {
        String s = String.format("Name: %s\nx: %d, y: %d\nTechlevel: %s\nResources: %s\n", name, x, y, techLevel.toString(), res.toString());
        return s;
    }
}
