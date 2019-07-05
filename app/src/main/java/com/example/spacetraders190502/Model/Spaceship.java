package com.example.spacetraders190502.Model;

public enum Spaceship {
    FLEA("Flea",100, 50),
    GNAT("Gnat",100, 50),
    FIREFLY("Firefly",100, 50),
    MOSQUITO("Mosquito",100, 50),
    BUMBLEBEE("Bumblebee",100, 50),
    BEETLE("Beetle",100, 50),
    HORNET("Hornet",100, 50),
    GRASSHOPPER("Grasshopper",100, 50),
    TERMITE("Termite",100, 50),
    WASP("Wasp",100, 50);

    Spaceship(String name, int fuelcapacity, int fueldist) {
        this.name = name;
        this.fuelcapacity = fuelcapacity;
        this.fueldistance = fueldist;
    }

    private String name;
    private int fuelcapacity;
    private int fueldistance;

    public String getName() {
        return name;
    }
    public int getFuelcapacity() {
        return this.fuelcapacity;
    }
    public int getFueldistance() {
        return this.fueldistance;
    }
    public void setFuelcapacity(int newCap) {
        this.fuelcapacity = newCap;
    }
    public void setFueldistance(int newDist) {
        this.fueldistance = newDist;
    }
}

