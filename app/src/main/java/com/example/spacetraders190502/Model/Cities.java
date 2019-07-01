package com.example.spacetraders190502.Model;

public class Cities {
    static String[] names;
    static TechLevel[] techLevels;
    static Resources[] ress;
    static int[] xs, ys;

    public Cities() {
        this.names = new String[]{"New Delhi", "Bangkok", "New York City", "Amsterdam", "Rome", "Athens", "Johannesburg", "Bogota", "Cairo", "Sydney"};
        this.techLevels = new TechLevel[]{TechLevel.Agriculture, TechLevel.Medieval, TechLevel.Renaissance, TechLevel.PreAgriculture, TechLevel.HiTech, TechLevel.PostIndustrial, TechLevel.Industrial, TechLevel.HiTech, TechLevel.Renaissance, TechLevel.Agriculture};
        this.xs = new int[]{0, 10, 50, 100, 45, 92, 74, 103, 134, 96};
        this.ys = new int[]{0, 10, 50, 64, 32, 87, 47, 120, 21, 11};
        this.ress = new Resources[]{Resources.LIFELESS, Resources.DESERT, Resources.MINERALRICH, Resources.WEIRDMUSHROOMS, Resources.POORSOIL, Resources.ARTISTIC, Resources.LOTSOFWATER, Resources.RICHFAUNA, Resources.LOTSOFHERBS, Resources.WARLIKE};
    }
}